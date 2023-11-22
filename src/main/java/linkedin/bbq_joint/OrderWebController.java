package linkedin.bbq_joint;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/orders")
public class OrderWebController {

  private MenuItemRepository menuItemRepository;
  private OrderRepository orderRepository;

  public OrderWebController(MenuItemRepository menuItemRepository, OrderRepository orderRepository) {
    this.menuItemRepository = menuItemRepository;
    this.orderRepository = orderRepository;
  }

  @GetMapping()
  public String getMethodName(Model model) {
    model.addAttribute("drinkItems", menuItemRepository.findByDrinkOrderByNameDesc(true));
    model.addAttribute("foodItems", menuItemRepository.findByDrinkOrderByNameDesc(false));
    model.addAttribute("orderForm", new OrderForm());
    return "order-form";
  }

  @PostMapping(value = "/place")
  public String submit(@ModelAttribute OrderForm orderForm, Model model) {
    model.addAttribute("orderForm", orderForm);

    var order = new Order();
    order.setName(orderForm.getName());

    var sum = 0;
    if (StringUtils.hasText(orderForm.getDrinkId())) {
      var drink = this.menuItemRepository.findById(UUID.fromString(orderForm.getDrinkId())).orElseThrow();
      order.setDrink(drink);
      sum += drink.getPrice();
    }
    if (StringUtils.hasText(orderForm.getFoodId())) {
      var food = this.menuItemRepository.findById(UUID.fromString(orderForm.getFoodId())).orElseThrow();
      order.setFood(food);
      sum += food.getPrice();
    }

    var orderPlaced = this.orderRepository.save(order);
    model.addAttribute("orderPlaced", orderPlaced);
    model.addAttribute("sum", sum);

    return "order-placed";
  }

}
