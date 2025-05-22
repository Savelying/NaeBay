package savelying.naebay.mappers;

import org.springframework.stereotype.Component;
import savelying.naebay.dto.UserDTO;
import savelying.naebay.models.User;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();

        if (user != null) {
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setRoles(user.getRoles());
            userDTO.setActive(user.isActive());
            userDTO.setAva(user.getAva());
            userDTO.setItems(user.getItems());
            userDTO.setDate(user.getDate());
            return userDTO;
        } else return null;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();

        if (userDTO != null) {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setPhone(userDTO.getPhone());
            user.setAva(userDTO.getAva());
            return user;
        } else return null;
    }
}
