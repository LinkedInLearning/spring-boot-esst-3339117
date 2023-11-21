package linkedin.data;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/greeting")
public class GreetingRestController {

  @GetMapping
  public String get() {
    return "America, I'm only getting started.";
  }

}
