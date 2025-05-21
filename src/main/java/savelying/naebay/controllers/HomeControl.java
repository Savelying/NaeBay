package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import savelying.naebay.dto.UserDTO;
import savelying.naebay.mappers.UserMapper;
import savelying.naebay.services.ItemService;
import savelying.naebay.services.UserService;

import java.security.Principal;

@Controller
public class HomeControl {
    private final UserService userService;
    private final ItemService itemService;
    private final UserMapper userMapper;

    public HomeControl(UserService userService, ItemService itemService, UserMapper userMapper) {
        this.userService = userService;
        this.itemService = itemService;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "hello";
    }

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "login";
    }

    @GetMapping("/registry")
    public String regUser(Model model, Principal principal) {
        boolean isLog = principal != null;
        model.addAttribute("isLog", isLog);
        model.addAttribute("userLog", itemService.getUserByPrincipal(principal));
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute UserDTO userDTO, Model model) {
//        model.addAttribute("user", user);
        if (!userService.createUser(userMapper.toUser(userDTO))) {
            model.addAttribute("error", "User with this email (" + userDTO.getEmail() + ") already exists!");
            return "registry";
        }
        return "redirect:/login";
    }

}
