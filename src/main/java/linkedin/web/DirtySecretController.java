package linkedin.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.TreeMap;


@RestController
@RequestMapping("/dirty-secrets")

public class DirtySecretController {

  private Map<String, DirtySecret> secrets = new TreeMap<String, DirtySecret>();

  @GetMapping
  public Flux<DirtySecret> get() {
    return Flux.fromIterable(this.secrets.values());
  }

  @GetMapping("/{id}")
  public Mono<DirtySecret> getById(@PathVariable String id) {
    return Mono.just(this.secrets.get(id));
  }

}
