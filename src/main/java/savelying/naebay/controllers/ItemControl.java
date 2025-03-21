package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import savelying.naebay.models.Item;
import savelying.naebay.services.ItemService;

@Controller
@RequestMapping("/items")
public class ItemControl {

    private final ItemService itemService;

    public ItemControl(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String items(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "items";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Item());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String item(@PathVariable long id, Model model) {
        if (itemService.getItem(id) != null) {
            model.addAttribute("item", itemService.getItem(id));
        } else return "redirect:/items";
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        if (itemService.getItem(id) != null) {
            model.addAttribute("item", itemService.getItem(id));
        } else return "redirect:/items";
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute("item") Item item) {
        if (itemService.getItem(id) != null) {
            itemService.saveItem(item);
            return "redirect:/";
        } else return "redirect:/items";
    }


    @PostMapping("/{id}/del")
    public String delete(@PathVariable long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
