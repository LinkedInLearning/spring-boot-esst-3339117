package linkedin.data;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.checkerframework.checker.units.qual.s;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

  private final DirtySecretsRepository repository;

  private final DirtySecretsService service;

  public DirtySecretsRestController(DirtySecretsRepository repository, DirtySecretsService service) {
    this.repository = repository;
    this.service = service;
  }

  @GetMapping
  public Iterable<DirtySecret> get() {
    return this.repository.findAll();
  }

  @GetMapping("/{id}")
  public DirtySecret getById(@PathVariable UUID id) {
    return this.repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Found nothing."));
  }

  @PostMapping
  public DirtySecret post(@RequestBody DirtySecret secret) {
    // Secret speichern
    var savedSecret = this.repository.save(secret);

    // Secret mit Id zurück geben
    return savedSecret;
  }

  @DeleteMapping
  public void delete(@RequestBody List<UUID> secretIds) {
    service.deleteAll(secretIds);
  }

}
