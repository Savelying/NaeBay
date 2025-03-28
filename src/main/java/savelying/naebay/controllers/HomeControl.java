package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import savelying.naebay.models.User;
import savelying.naebay.services.ItemService;
import savelying.naebay.services.UserService;

import java.security.Principal;

@Controller
public class HomeControl {
    private final UserService userService;
    private final ItemService itemService;

    public HomeControl(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("user", itemService.getUserByPrincipal(principal));
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registry")
    public String regUser() {
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        if (!userService.createUser(user)) {
            model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
            return "registry";
        }
        return "redirect:/login";
    }

}
