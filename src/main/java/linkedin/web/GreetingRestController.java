package linkedin.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/greeting")
public class GreetingRestController {

  @GetMapping(produces = { "text/plain" })
  public String get(@RequestParam(defaultValue = "America", required = false) String name) {
    return String.format("%s, I'm only getting started.", name);
  }

  @GetMapping(produces = { "application/json" })
  public Greeting getJson(@RequestParam(defaultValue = "America", required = false) String name) {
    var greeting = new Greeting();
    greeting.setMessage(String.format("%s, I'm only getting started.", name));
    return greeting;
  }

}
