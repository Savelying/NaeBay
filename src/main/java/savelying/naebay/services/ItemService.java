package savelying.naebay.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.models.Image;
import savelying.naebay.models.Item;
import savelying.naebay.repositories.ItemRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(long id) {
        return !itemRepository.existsById(id) ? null : itemRepository.findById(id).orElse(null);
    }

    public void saveItem(Item item, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        if (file1.getSize() != 0) {
            Image image1 = toImageEntity(file1);
            item.addImageToItem(image1);
        }
        if (file2.getSize() != 0) {
            Image image2 = toImageEntity(file2);
            item.addImageToItem(image2);
        }
        if (file3.getSize() != 0) {
            Image image3 = toImageEntity(file3);
            item.addImageToItem(image3);
        }
        itemRepository.save(item);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        return new Image(file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize(), file.getBytes());
    }

    public void updateItem(Item item) {
        Item itemToUpdate = itemRepository.findById(item.getId()).orElse(null);
        if (itemToUpdate != null) {
            item.setDate(itemToUpdate.getDate());
            itemRepository.save(item);
        }
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }
}
