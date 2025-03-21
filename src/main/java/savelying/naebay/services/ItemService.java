package savelying.naebay.services;

import org.springframework.stereotype.Service;
import savelying.naebay.models.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    {   // добавили в список два товара с целью обкатки движка
        items.add(new Item(1, "PS5", "PlayStation 5", "Ufa", "Vitaly", 700));
        items.add(new Item(2, "XBox", "XBox One Special Edition", "Perm", "Savely", 850));
    }

    public List<Item> getItems() {
        return items;
    }

    public void saveItem(Item item) {
        item.setId(items.size() + 1);
        items.add(item);
    }

    public void deleteItem(long id) {
        items.removeIf(i -> i.getId() == id);
    }

    public Item getItem(long id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public void updateItem(Item item, long id) {
        items.remove(items.stream().filter(i -> i.getId() == id).findFirst().orElse(null));
        items.add(item);
    }
}
