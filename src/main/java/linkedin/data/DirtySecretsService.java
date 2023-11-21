package linkedin.data;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DirtySecretsService {

  private final DirtySecretsRepository repository;

  public DirtySecretsService(DirtySecretsRepository repository) {
    this.repository = repository;
  }


}
