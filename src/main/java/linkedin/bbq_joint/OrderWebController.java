package linkedin.bbq_joint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/orders")
public class OrderWebController {

  private MenuItemRepository menuItemRepository;

  public OrderWebController(MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  @GetMapping()
  public String getMethodName(Model model) {
    model.addAttribute("menuItems", menuItemRepository.findByOrderByNameDesc());
    model.addAttribute("orderForm", new OrderForm());
    return "order-form";
  }

  @PostMapping(value = "/place")
  public String submit(@ModelAttribute OrderForm orderForm, Model model) {
    model.addAttribute("orderForm", orderForm);
    return "order-placed";
  }

}
