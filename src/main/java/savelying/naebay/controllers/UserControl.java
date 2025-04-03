package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.models.User;
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

    public UserControl(UserService userService, UserRepository userRepository, ItemService itemService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.itemService = itemService;
    }

    @GetMapping("/{user}")
    public String userInfo(@ModelAttribute User user, Model model, Principal principal) {
        boolean myLog = false;
        boolean isLog = principal != null;
        if (principal != null) myLog = user.getId() == (userRepository.findByEmail(principal.getName()).getId());
        model.addAttribute("myLog", myLog);
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
        model.addAttribute("items", user.getItems());
        return "user-info";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute User user, Model model, Principal principal) {
        assert principal != null;
        model.addAttribute("isLog", true);
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "my-edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute User user, Model model, Principal principal,
                         @RequestParam("file") MultipartFile file) throws IOException {
        assert principal != null;
        assert user != null;
            if (!userService.updateUser(user, principal, file)) {
                model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
                return "redirect:/user/edit";
            }
        return "redirect:/user/" + userRepository.findByEmail(principal.getName()).getId();
    }

    @PostMapping("/delAva")
    public String deleteAva(@ModelAttribute User user, Model model, Principal principal) {
        assert principal != null;
        userService.delAva(principal);
        return "redirect:/user/edit";
    }
}
