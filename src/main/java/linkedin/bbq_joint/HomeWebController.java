package linkedin.bbq_joint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeWebController {

  private MenuItemRepository menuItemRepository;

  public HomeWebController(MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  @GetMapping()
  public String getMethodName(Model model) {
    model.addAttribute("menuItems", menuItemRepository.findByOrderByNameDesc());
    return "home";
  }

}
