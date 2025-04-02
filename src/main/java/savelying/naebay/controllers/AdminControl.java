package savelying.naebay.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.models.Role;
import savelying.naebay.models.User;
import savelying.naebay.services.ItemService;
import savelying.naebay.services.UserService;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminControl {
    private final UserService userService;
    private final ItemService itemService;

    public AdminControl(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping("")
    public String admin(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        model.addAttribute("users", userService.getUsers());
        return "admin";
    }

    @PostMapping("/user/ban/{id}")
    public String banUser(@PathVariable long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{user}")
    public String editUser(@PathVariable("user") User user, Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/user/edit")
    public String editUser(@RequestParam("userId") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRole(user, form);
        return "redirect:/admin";
    }
}
