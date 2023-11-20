package linkedin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DirtySecretsRestController {

  private DirtySecretsRepository repository;

  public DirtySecretsRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public DirtySecret getById(@PathVariable String id) {
    return this.repository.getById(id).orElseThrow();
  }

}