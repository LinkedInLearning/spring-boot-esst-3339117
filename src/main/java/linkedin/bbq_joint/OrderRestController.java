package linkedin.bbq_joint;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

  private MenuItemRepository menuItemRepository;
  private OrderRepository orderRepository;

  public OrderRestController(MenuItemRepository menuItemRepository, OrderRepository orderRepository) {
    this.menuItemRepository = menuItemRepository;
    this.orderRepository = orderRepository;
  }

  @PostMapping
  public Order post(@RequestBody OrderModel orderModel) {

    var order = new Order();
    // order.setCustomer(orderModel.;

    var sm = this.menuItemRepository.findAllById(orderModel.getMenuItemIds());

    return null;

  }

}
