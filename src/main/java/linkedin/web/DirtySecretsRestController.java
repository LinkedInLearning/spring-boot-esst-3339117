package linkedin.web;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DirtySecretsRestController {

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