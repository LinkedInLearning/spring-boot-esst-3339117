package linkedin.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @GetMapping
  public String get(@RequestParam(defaultValue = "America", required = false) String name) {
    return String.format("%s, I'm only getting started.", name);
  }

}
