package savelying.naebay.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import savelying.naebay.models.User;
import savelying.naebay.models.enums.Rule;
import savelying.naebay.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.getRules().add(Rule.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
