package money.heist.repositories;

import money.heist.model.Heist;
import org.springframework.data.repository.CrudRepository;

public interface HeistRepository extends CrudRepository<Heist, Long> {
}
