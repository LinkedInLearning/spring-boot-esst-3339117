package linkedin.bbq_joint;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItem, UUID> {

  Iterable<MenuItem> findByOrderByNameDesc();

  Iterable<MenuItem> findByDrinkOrderByNameDesc(boolean drink);

}
