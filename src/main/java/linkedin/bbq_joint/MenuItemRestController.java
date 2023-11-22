package linkedin.bbq_joint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu-items")
public class MenuItemRestController {

  private MenuItemRepository menuItemRepository;

  public MenuItemRestController(MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  @PostMapping
  public MenuItem post(@RequestBody MenuItem menuItem) {
    return this.menuItemRepository.save(menuItem);
  }

}
