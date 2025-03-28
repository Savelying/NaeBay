package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.models.User;
import savelying.naebay.repositories.UserRepository;
import savelying.naebay.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserControl {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserControl(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{user}")
    public String userInfo(@ModelAttribute User user, Model model, Principal principal) {
        boolean myLog = false;
        if (principal != null) {
            myLog = user.getId() == (userRepository.findByEmail(principal.getName()).getId());
        }
        model.addAttribute("myLog", myLog);
        model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
        model.addAttribute("items", user.getItems());
        return "user-info";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute User user, Model model, Principal principal) {
        assert principal != null;
        model.addAttribute("user", userRepository.findByEmail(principal.getName()));
        return "my-edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute User user, Model model, Principal principal) {
        assert principal != null;
        assert user != null;
            if (!userService.updateUser(user, principal)) {
                model.addAttribute("error", "User with this email (" + user.getEmail() + ") already exists");
                return "redirect:/user/edit";
            }
        return "redirect:/user/" + userRepository.findByEmail(principal.getName()).getId();
    }
}
