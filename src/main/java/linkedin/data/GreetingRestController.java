package linkedin.data;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/greeting")
public class GreetingRestController {

  @Value("${linkedin.greeting}")
  private String greeting;

  @GetMapping
  public String get(@RequestParam(defaultValue = "America", required = false) String name) {
    // return String.format("%s, I'm only getting started.", name);
    return this.greeting;
  }

}
