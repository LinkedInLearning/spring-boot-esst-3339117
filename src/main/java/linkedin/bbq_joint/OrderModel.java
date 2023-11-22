package linkedin.bbq_joint;

import java.util.List;
import java.util.UUID;

public class OrderModel {

  private UUID id;

  private String name;

  private List<UUID> menuItemIds;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<UUID> getMenuItemIds() {
    return menuItemIds;
  }

  public void setMenuItemIds(List<UUID> menuItemIds) {
    this.menuItemIds = menuItemIds;
  }

}
