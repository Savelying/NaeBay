package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import savelying.naebay.services.ItemService;

import java.security.Principal;

@Controller
public class HomeControl {

    private final ItemService itemService;

    public HomeControl(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("user", itemService.getUserByPrincipal(principal));
        return "home";
    }
}
