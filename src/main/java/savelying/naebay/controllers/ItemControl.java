package savelying.naebay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.models.Item;
import savelying.naebay.services.ItemService;

import java.io.IOException;

@Controller
@RequestMapping("/item")
public class ItemControl {

    private final ItemService itemService;

    public ItemControl(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Item());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Item item, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3) throws IOException {
        itemService.saveItem(item, file1, file2, file3);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String item(@PathVariable long id, Model model) {
        if (itemService.getItemById(id) != null) {
            model.addAttribute("item", itemService.getItemById(id));
            model.addAttribute("images", itemService.getItemById(id).getImages());
        } else return "redirect:/item";
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        if (itemService.getItemById(id) != null) {
            model.addAttribute("item", itemService.getItemById(id));
        } else return "redirect:/item";
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute("item") Item item) {
        if (itemService.getItemById(id) != null) {
            itemService.updateItem(item);
            return "redirect:/";
        } else return "redirect:/item";
    }


    @PostMapping("/{id}/del")
    public String delete(@PathVariable long id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
