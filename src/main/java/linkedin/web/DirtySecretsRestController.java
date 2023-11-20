package linkedin.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

  private DirtySecretsRepository repository;

  public DirtySecretsRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/e1/{id}")
  public DirtySecret getByIdE1(@PathVariable String id) {
    return this.repository.getById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            ":-( Found nothing."));
  }

  @GetMapping("/e2/{id}")
  public DirtySecret getByIdE2(@PathVariable String id) {
    return this.repository.getById(id)
        .orElseThrow(() -> new NoSecretFoundWebException());
  }

  @GetMapping("/e3/{id}")
  public DirtySecret getByIdE3(@PathVariable String id) {
    return this.repository.getById(id).orElseThrow(() -> new NoSecretFoundException());
  }

  @ExceptionHandler({ NoSecretFoundException.class })
  public ResponseEntity<String> handleNoSecretFoundException() {
    return ResponseEntity.internalServerError().body("No secret found.");
  }

}