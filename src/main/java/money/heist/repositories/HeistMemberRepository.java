package money.heist.repositories;

import money.heist.model.HeistMember;
import org.springframework.data.repository.CrudRepository;

public interface HeistMemberRepository extends CrudRepository<HeistMember, Long> {
}
