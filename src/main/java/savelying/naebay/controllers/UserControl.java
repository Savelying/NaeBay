package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import savelying.naebay.models.User;
import savelying.naebay.services.UserService;

@Controller
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
    public String registry() {
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
            return "registry";
        }
        return "redirect:/";
    }
}
