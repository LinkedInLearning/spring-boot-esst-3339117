package linkedin.data;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Collection;

@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

  private final DirtySecretsRepository repository;

  public DirtySecretsRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  private Map<String, DirtySecret> secrets = new TreeMap<String, DirtySecret>();

  @GetMapping
  public Iterable<DirtySecret> get() {
    return this.repository.findAll();
  }

  @GetMapping("/{id}")
  public DirtySecret getByIdV2a(@PathVariable String id) {
    return this.repository.findById(UUID.fromString(id))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Found nothing."));
  }

  @PostMapping
  public DirtySecret post(@RequestBody DirtySecret secret) {
    // Secret speichern
    var savedSecret = this.repository.save(secret);

    // Secret mit Id zurück geben
    return savedSecret;
  }

}
