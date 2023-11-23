package linkedin.bbq_joint;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity()
@Table(name = "bbq_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @ManyToOne()
  @JoinColumn(name = "drink_id")
  private MenuItem drink;

  @ManyToOne()
  @JoinColumn(name = "food_id")
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
