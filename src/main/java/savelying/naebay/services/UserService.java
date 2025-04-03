package savelying.naebay.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import savelying.naebay.models.Image;
import savelying.naebay.models.Role;
import savelying.naebay.models.User;
import savelying.naebay.repositories.ImageRepository;
import savelying.naebay.repositories.UserRepository;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ImageRepository imageRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.imageRepository = imageRepository;
    }

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void banUser(long id) {
        User user = userRepository.findById(id);
        assert user != null;
        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    public void changeUserRole(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) user.getRoles().add(Role.valueOf(key));
        }
        userRepository.save(user);
    }

    public boolean updateUser(User user, Principal principal, MultipartFile file) throws IOException {
        User userToUpdate = userRepository.findByEmail(principal.getName());
        if ((userRepository.findByEmail(user.getEmail()) != null) &&
                (!user.getEmail().equals(userToUpdate.getEmail()))) return false;
        user.setId(userToUpdate.getId());
        user.setPassword(userToUpdate.getPassword());
        user.setActive(userToUpdate.isActive());
        user.setDate(userToUpdate.getDate());
        user.setRoles(userToUpdate.getRoles());
        if (file.getSize() != 0) {
            Image image = new Image(file.getName(), file.getOriginalFilename(), file.getContentType(), file.getSize(), file.getBytes());
            if (userToUpdate.getAva() != null) image.setId(userToUpdate.getAva().getId());
            user.setAva(image);
        }
        userRepository.save(user);
        return true;
    }

    public void delAva(Principal principal) {
        long avaId = userRepository.findByEmail(principal.getName()).getAva().getId();
        System.out.println(avaId + "-" + imageRepository.findById(avaId).get().getOriginFileName());
        User userToUpdate = userRepository.findByEmail(principal.getName());
        userToUpdate.setAva(null);
        userRepository.save(userToUpdate);
        imageRepository.deleteById(avaId);
    }
}
