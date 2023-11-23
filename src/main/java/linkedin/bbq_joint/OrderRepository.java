package linkedin.bbq_joint;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

  public Order save(Order order) {
    return order;
  }

  public Optional<Order> findById(UUID id) {
    return Optional.empty();
  }

}
