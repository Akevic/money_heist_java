package money.heist.repositories;

import money.heist.model.Heist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeistRepository extends JpaRepository<Heist, Long> {
}
