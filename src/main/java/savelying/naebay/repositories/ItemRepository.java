package savelying.naebay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import savelying.naebay.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
