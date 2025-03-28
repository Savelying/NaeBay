package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.models.Item;
import savelying.naebay.models.User;
import savelying.naebay.repositories.UserRepository;
import savelying.naebay.services.ItemService;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/items")
public class ItemControl {
    private final UserRepository userRepository;
    private final ItemService itemService;

    public ItemControl(UserRepository userRepository, ItemService itemService) {
        this.userRepository = userRepository;
        this.itemService = itemService;
    }

    @GetMapping("")
    public String items(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "items";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Item());
        return "item-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Item item,
                         Principal principal,
                         @RequestParam("file1") MultipartFile file1,
                         @RequestParam("file2") MultipartFile file2,
                         @RequestParam("file3") MultipartFile file3) throws IOException {
        itemService.saveItem(item, principal, file1, file2, file3);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String item(@PathVariable long id, Model model, Principal principal) {
        boolean myLog = false;
        if (principal != null) {
            if (itemService.getItem(id).getUser().getId() == userRepository.findByEmail(principal.getName()).getId())
                myLog = true;
        }
        if (itemService.getItem(id) != null) {
            model.addAttribute("myLog", myLog);
            model.addAttribute("item", itemService.getItem(id));
            model.addAttribute("images", itemService.getItem(id).getImages());
        } else return "redirect:/items";
        return "item-view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model, Principal principal) {
        assert principal != null;
        if (itemService.getItem(id) != null) {
            if (itemService.getItem(id).getUser().getId() == userRepository.findByEmail(principal.getName()).getId()) {
                model.addAttribute("item", itemService.getItem(id));
            } else return "redirect:/items";
        } else return "redirect:/items";
        return "item-edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute("item") Item item) {
        if (itemService.getItem(id) != null) {
            itemService.updateItem(item);
            return "redirect:/user/" + item.getUser().getId();
        } else return "redirect:/items";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id, @ModelAttribute("item") Item item, Principal principal) {
        assert principal != null;
        if (itemService.getItem(id) != null) {
            if (itemService.getItem(id).getUser().getId() == userRepository.findByEmail(principal.getName()).getId()) {
                itemService.deleteItem(id);
                return "redirect:/user/" + item.getUser().getId();
            } else return "redirect:/items";
        } else return "redirect:/items";
    }
}
