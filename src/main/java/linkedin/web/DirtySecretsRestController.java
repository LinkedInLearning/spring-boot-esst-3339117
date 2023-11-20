package linkedin.web;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretsRestController {

  private Map<String, DirtySecret> secrets = new TreeMap<>();

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