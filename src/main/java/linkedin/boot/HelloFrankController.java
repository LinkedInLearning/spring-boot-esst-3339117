package linkedin.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFrankController {

  private HelloFrankService service;

  public HelloFrankController(HelloFrankService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String get() {
    return this.service.hello();
  }

}
