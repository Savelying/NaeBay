package savelying.naebay.mappers;

import org.springframework.stereotype.Component;
import savelying.naebay.dto.ItemDTO;
import savelying.naebay.models.Item;

@Component
public class ItemMapper {

    private final UserMapper userMapper;

    public ItemMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ItemDTO toDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setTitle(item.getTitle());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setCity(item.getCity());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setDate(item.getDate());
        itemDTO.setUserDTO(userMapper.toDTO(item.getUser()));
        itemDTO.setImagesDTO(item.getImages());
        return itemDTO;
    }

    public Item toItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setTitle(itemDTO.getTitle());
        item.setDescription(itemDTO.getDescription());
        item.setCity(itemDTO.getCity());
        item.setPrice(itemDTO.getPrice());
        item.setUser(userMapper.toUser(itemDTO.getUser()));
        return item;
    }
}
