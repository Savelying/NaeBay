package savelying.naebay.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.dto.UserDTO;
import savelying.naebay.mappers.UserMapper;
import savelying.naebay.models.Role;
import savelying.naebay.repositories.UserRepository;
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
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public AdminControl(UserService userService, ItemService itemService, UserMapper userMapper, UserRepository userRepository) {
        this.userService = userService;
        this.itemService = itemService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
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

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable long id, Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        model.addAttribute("user", userMapper.toDTO(userRepository.findById(id)));
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/user/edit")
    public String editUser(@RequestParam("userId") UserDTO userDTO, @RequestParam Map<String, String> form) {
        userService.changeUserRole(userMapper.toUser(userDTO), form);
        return "redirect:/admin";
    }
}
