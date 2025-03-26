package savelying.naebay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import savelying.naebay.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findById(long id);
}
