package linkedin.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.core.Ordered;
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

public class DirtySecretController {

  private Map<String, DirtySecret> secrets = new TreeMap<String, DirtySecret>();

  @GetMapping
  public Collection<DirtySecret> get() {
    return this.secrets.values();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DirtySecret> getById(@PathVariable String id) {
    if (!this.secrets.containsKey(id)) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(this.secrets.get(id));
  }

  @GetMapping("/v2a/{id}")
  public DirtySecret getByIdV2a(@PathVariable String id) {
    if (!this.secrets.containsKey(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Found nothing.");
    }
    return this.secrets.get(id);
  }

  @GetMapping("/v2b/{id}")
  public DirtySecret getByIdV2b(@PathVariable String id) {
    if (!this.secrets.containsKey(id)) {
      throw new NoSecretFoundWebException();
    }
    return this.secrets.get(id);
  }

  @GetMapping("/v2c/{id}")
  public DirtySecret getByIdV2c(@PathVariable String id) {
    if (!this.secrets.containsKey(id)) {
      throw new NoSecretFoundException();
    }
    return this.secrets.get(id);
  }

  @ExceptionHandler({ NoSecretFoundException.class })
  public ResponseEntity<String> handleNoSecretFoundException() {
    // Render custom Message
    
    return ResponseEntity.internalServerError().body("No secret found.");
  }

  @PostMapping
  public DirtySecret post(@RequestBody DirtySecret secret) {
    // Id generieren
    secret.setId(UUID.randomUUID().toString());

    // Secret merken
    this.secrets.put(secret.getId(), secret);

    // Secret mit Id zurück geben
    return secret;
  }

}
