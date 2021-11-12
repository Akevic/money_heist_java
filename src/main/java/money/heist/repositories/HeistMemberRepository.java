package money.heist.repositories;

import money.heist.model.HeistMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeistMemberRepository extends JpaRepository<HeistMember, Long> {
}