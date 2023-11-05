package linkedin.webflux;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/chucknorris-jokes")
public class ChuckNorrisJokesRestController {

  @GetMapping
  public Mono<String> get() {
    var client = WebClient.create();
    var request = client
        .get()
        .uri("https://api.chucknorris.io/jokes/random")
        .accept(MediaType.TEXT_PLAIN);
    return request.exchangeToMono(response -> response.bodyToMono(String.class));
  }

}
