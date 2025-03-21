package savelying.naebay.services;

import org.springframework.stereotype.Service;
import savelying.naebay.models.Item;
import savelying.naebay.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    {   // добавили в список два товара с целью обкатки движка
//        items.add(new Item(1, "PS5", "PlayStation 5", "Ufa", "Vitaly", 700));
//        items.add(new Item(2, "XBox", "XBox One Special Edition", "Perm", "Savely", 850));
//    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(long id) {
        return !itemRepository.existsById(id) ? null : itemRepository.findById(id).orElse(null);
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void updateItem(Item item, long id) {
        if (!itemRepository.existsById(id)) {}
//        Item itemToUpdate = itemRepository.findById(id).orElse(null);
        itemRepository.save(item);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }
}
