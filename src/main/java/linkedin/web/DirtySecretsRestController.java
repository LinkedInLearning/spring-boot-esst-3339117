package linkedin.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

  private DirtySecretsRepository repository;

  public DirtySecretsRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/count")
  public int count() {
    return this.repository.count();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DirtySecret> getById(@PathVariable String id) {
    var secret = this.repository.getById(id);
    if (secret.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(secret.get());
  }

}
