package linkedin.data;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class DirtySecretsRepository {

  private Map<UUID, DirtySecret> secrets = new TreeMap<>();

  public DirtySecretsRepository() {
    var secret = new DirtySecret();
    secret.setId(UUID.randomUUID());
    secret.setName("Doug");
    secret.setSecret("Ex Alcoholic");
    this.secrets.put(secret.getId(), secret);
  }

  Optional<DirtySecret> getById(UUID id) {
    if (!this.secrets.containsKey(id)) {
      return Optional.empty();
    }
    return Optional.of(this.secrets.get(id));
  }

  int count() {
    return this.secrets.size();
  }

  DirtySecret save(DirtySecret secret) {
    // Id generieren
    secret.setId(UUID.randomUUID());

    // Secret merken
    this.secrets.put(secret.getId(), secret);

    // Secret mit Id zurück geben
    return secret;
  }

}
