package linkedin.bbq_joint;

import java.util.UUID;

public class Order {

  private UUID id;

  private String name;

  private MenuItem drink;

  private MenuItem food;

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

  public MenuItem getDrink() {
    return drink;
  }

  public void setDrink(MenuItem drink) {
    this.drink = drink;
  }

  public MenuItem getFood() {
    return food;
  }

  public void setFood(MenuItem food) {
    this.food = food;
  }

  @Override
  public String toString() {
    return String.format("Order<id: %s, drink: %s, food: %s>", id, food, drink);
  }

}
