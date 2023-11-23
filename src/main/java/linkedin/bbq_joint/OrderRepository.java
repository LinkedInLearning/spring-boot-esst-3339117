package linkedin.bbq_joint;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

  private Map<UUID, Order> orders = new TreeMap<>();

  public Order save(Order order) {
    order.setId(UUID.randomUUID());
    orders.put(order.getId(), order);
    return order;
  }

  public Optional<Order> findById(UUID id) {
    if (!orders.containsKey(id)) {
      return Optional.empty();
    }
    return Optional.ofNullable(orders.get(id));
  }

}
