package linkedin.bbq_joint;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MenuItem {

  @Id
  private UUID id;

  private String name;

  private Integer price;

  private boolean drink = false;

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

  public boolean isDrink() {
    return drink;
  }

  public void setDrink(boolean drink) {
    this.drink = drink;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("MenuItem<id: %s, name: %s, price: %s>", id, name, price);
  }

}
