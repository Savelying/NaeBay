package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.models.User;
import savelying.naebay.services.UserService;

@Controller
@RequestMapping("/user")
public class UserControl {

    private final UserService userService;

    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registry")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registry";
    }

    @PostMapping("/registry")
    public String createUser(@ModelAttribute User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
            return "registry";
        }
        return "redirect:/user/hello";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }
}
