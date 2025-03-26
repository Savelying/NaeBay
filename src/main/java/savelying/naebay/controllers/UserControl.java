package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.models.User;
import savelying.naebay.repositories.UserRepository;
import savelying.naebay.services.UserService;

@Controller
public class UserControl {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserControl(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registry")
    public String registry() {
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
            return "registry";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@ModelAttribute User user, Model model) {
        model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
        model.addAttribute("items", user.getItems());
        return "user-info";
    }
}
