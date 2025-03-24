package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import savelying.naebay.services.ItemService;

@Controller
public class HomeControl {

    private final ItemService itemService;

    public HomeControl(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "items";
    }
}
