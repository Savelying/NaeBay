package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.dto.ItemDTO;
import savelying.naebay.mappers.ItemMapper;
import savelying.naebay.mappers.UserMapper;
import savelying.naebay.repositories.UserRepository;
import savelying.naebay.services.ItemService;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/items")
public class ItemControl {
    private final UserRepository userRepository;
    private final ItemService itemService;
    private final UserMapper userMapper;
    private final ItemMapper itemMapper;

    public ItemControl(UserRepository userRepository, ItemService itemService, UserMapper userMapper, ItemMapper itemMapper) {
        this.userRepository = userRepository;
        this.itemService = itemService;
        this.userMapper = userMapper;
        this.itemMapper = itemMapper;
    }

    @GetMapping("")
    public String items(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", userMapper.toDTO(itemService.getUserByPrincipal(principal)));
        model.addAttribute("items", itemService.getItems());
        return "items";
    }

    @GetMapping("/create")
    public String create(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", userMapper.toDTO(itemService.getUserByPrincipal(principal)));
        return "item-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") ItemDTO itemDTO,
                         Principal principal,
                         @RequestParam("file1") MultipartFile file1,
                         @RequestParam("file2") MultipartFile file2,
                         @RequestParam("file3") MultipartFile file3) throws IOException {
        itemService.saveItem(itemMapper.toItem(itemDTO), principal, file1, file2, file3);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String item(@PathVariable long id, Model model, Principal principal) {
        boolean myLog = false;
        boolean isLog = principal != null;
        if (principal != null) {
            if (itemService.getItem(id).getUser().getId() == userRepository.findByEmail(principal.getName()).getId())
                myLog = true;
        }
        if (itemService.getItem(id) != null) {
            model.addAttribute("myLog", myLog);
            model.addAttribute("isLog", isLog);
            model.addAttribute("userLog", userMapper.toDTO(itemService.getUserByPrincipal(principal)));
            model.addAttribute("item", itemMapper.toDTO(itemService.getItem(id)));
            model.addAttribute("images", itemService.getItem(id).getImages());
        } else return "redirect:/items";
        return "item-view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model, Principal principal) {
        assert principal != null;
        model.addAttribute("isLog", true);
        model.addAttribute("userLog", userMapper.toDTO(itemService.getUserByPrincipal(principal)));
        if (itemService.getItem(id) != null) {
            if (itemService.getItem(id).getUser().getId() == userRepository.findByEmail(principal.getName()).getId()) {
                model.addAttribute("item", itemMapper.toDTO(itemService.getItem(id)));
            } else return "redirect:/items";
        } else return "redirect:/items";
        return "item-edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute("item") ItemDTO itemDTO) {
        if (itemService.getItem(id) != null) {
            itemService.updateItem(itemMapper.toItem(itemDTO));
            return "redirect:/items/view/" + id;
        } else return "redirect:/items";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id, Principal principal) {
        assert principal != null;
        if (itemService.getItem(id) != null) {
            itemService.deleteItem(id);
            return "redirect:/user/" + userRepository.findByEmail(principal.getName()).getId();
        } else return "redirect:/items";
    }
}
