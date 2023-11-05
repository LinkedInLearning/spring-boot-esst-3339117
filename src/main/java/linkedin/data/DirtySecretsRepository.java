package linkedin.data;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface DirtySecretsRepository extends CrudRepository<DirtySecret, UUID> {

}
