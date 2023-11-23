package linkedin.bbq_joint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/menu-items")
public class MenuItemRestController {

  private MenuItemRepository menuItemRepository;

  public MenuItemRestController(MenuItemRepository menuItemRepository) {
    this.menuItemRepository = menuItemRepository;
  }

  @GetMapping
  public Iterable<MenuItem> get(@RequestParam(name = "drink", defaultValue = "false") String isDrink) {
    return this.menuItemRepository.findByDrinkOrderByNameDesc(Boolean.parseBoolean(isDrink));
  }

  @PostMapping
  public MenuItem post(@RequestBody MenuItem menuItem) {
    return this.menuItemRepository.save(menuItem);
  }

}
