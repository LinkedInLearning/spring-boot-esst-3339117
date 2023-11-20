package linkedin.web;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DirtySecretsRestController {

  private Map<String, DirtySecret> secrets = new TreeMap<>();

  public DirtySecretsRestController() {
    var secret = new DirtySecret();
    secret.setId("test-123");
    secret.setName("Doug");
    secret.setSecret("Ex Alcoholic");
    this.secrets.put(secret.getId(), secret);
  }

}
