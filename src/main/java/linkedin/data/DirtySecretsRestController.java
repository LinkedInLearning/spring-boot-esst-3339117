package linkedin.data;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
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

  private Map<String, DirtySecret> secrets = new TreeMap<String, DirtySecret>();

  @GetMapping
  public Collection<DirtySecret> get() {
    return this.secrets.values();
  }

  @GetMapping("/{id}")
  public DirtySecret getById(@PathVariable String id) {
    if (!this.secrets.containsKey(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Found nothing.");
    }
    return this.secrets.get(id);
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
