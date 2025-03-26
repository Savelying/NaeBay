package savelying.naebay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import savelying.naebay.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
