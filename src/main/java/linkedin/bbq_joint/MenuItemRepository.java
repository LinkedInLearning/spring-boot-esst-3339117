package linkedin.bbq_joint;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class MenuItemRepository {

  public Optional<MenuItem> findById(UUID id) {
    return Optional.empty();
  }

  MenuItem save(MenuItem menuItem) {
    return menuItem;
  }

  public Iterable<MenuItem> findByOrderByDrinkDescNameDesc() {
    return null;
  }

  public Iterable<MenuItem> findByDrinkOrderByNameDesc(boolean drink) {
    return null;

  }

}
