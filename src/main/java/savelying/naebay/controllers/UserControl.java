package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.dto.UserDTO;
import savelying.naebay.mappers.UserMapper;
import savelying.naebay.repositories.UserRepository;
import savelying.naebay.services.ItemService;
import savelying.naebay.services.UserService;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserControl {
    private final UserService userService;
    private final UserRepository userRepository;
    private final ItemService itemService;
    private final UserMapper userMapper;

    public UserControl(UserService userService, UserRepository userRepository, ItemService itemService, UserMapper userMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.itemService = itemService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public String userInfo(@PathVariable long id, Model model, Principal principal) {
        boolean myLog = false;
        boolean isLog = principal != null;
        if (principal != null) myLog = id == (userRepository.findByEmail(principal.getName()).getId());
        model.addAttribute("myLog", myLog);
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        model.addAttribute("user", userMapper.toDTO(userRepository.findById(id)));
        model.addAttribute("items", userMapper.toDTO(userRepository.findById(id)).getItems());
        return "user-info";
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal) {
        assert principal != null;
        model.addAttribute("isLog", true);
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "my-edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute UserDTO userDTO, Model model, Principal principal,
                         @RequestParam("file") MultipartFile file) throws IOException {
        assert principal != null;
        if (!userService.updateUser(userMapper.toUser(userDTO), principal, file)) {
            model.addAttribute("error", "User with this email (" + userDTO.getEmail() + ") has not been updated!");
            return "redirect:/user/edit";
        }
        return "redirect:/user/" + userRepository.findByEmail(principal.getName()).getId();
    }

    @PostMapping("/delAva")
    public String deleteAva(/*@ModelAttribute User user, Model model, */Principal principal) {
        assert principal != null;
        userService.delAva(principal);
        return "redirect:/user/edit";
    }
}
