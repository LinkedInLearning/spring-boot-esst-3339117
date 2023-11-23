package linkedin.bbq_joint;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class MenuItemRepository {

  private Map<UUID, MenuItem> menuItems = new TreeMap<>();

  public Optional<MenuItem> findById(UUID id) {
    if (!menuItems.containsKey(id)) {
      return Optional.empty();
    }
    return Optional.ofNullable(menuItems.get(id));
  }

  MenuItem save(MenuItem menuItem) {
    if (menuItem.getId() == null) {
      menuItem.setId(UUID.randomUUID());
    }
    menuItems.put(menuItem.getId(), menuItem);
    return menuItem;
  }

  public Iterable<MenuItem> findByOrderByDrinkDescNameDesc() {
    return menuItems.values();
  }

  public Iterable<MenuItem> findByDrinkOrderByNameDesc(boolean drink) {
    return menuItems.values().stream()
        .filter((menuItem) -> menuItem.isDrink() == drink)
        .collect(Collectors.toList());
  }

}
