package linkedin.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFrankController {

  @GetMapping("/")
  public String get() {
    return "America, I'm only getting started.";
  }

}
