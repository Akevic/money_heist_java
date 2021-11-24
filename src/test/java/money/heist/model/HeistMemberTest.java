package money.heist.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeistMemberTest {
  HeistMember heistMember;

  @BeforeEach
  void setUp() {
    heistMember = new HeistMember();
  }

  @Test
  void getSex() {
    Sex sex = Sex.M;

    heistMember.setSex(sex);

    assertEquals(sex, heistMember.getSex());
  }

  @Test
  void getSkills() {
    String skills = "driving, lock-picking";

    heistMember.setSkills(skills);

    assertEquals(skills, heistMember.getSkills());
  }

  @Test
  void getStatus() {
    HeistMemberStatus heistMemberStatus = HeistMemberStatus.AVAILABLE;

    heistMember.setStatus(heistMemberStatus);

    assertEquals(heistMemberStatus, heistMember.getStatus());
  }

  @Test
  void getId() {
    Long id = 4L;

    heistMember.setId(id);

    assertEquals(id, heistMember.getId());
  }
}