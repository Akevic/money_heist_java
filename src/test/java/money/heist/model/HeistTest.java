package money.heist.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeistTest {

  Heist heist;

  @BeforeEach
  void setUp() {
    heist = new Heist();
  }

  @Test
  void getStatus() {
    HeistStatus status = HeistStatus.READY;

    heist.setStatus(status);

    assertEquals(status, heist.getStatus());
  }

  @Test
  void getSkills() {
    String skills = "combat, driving";

    heist.setSkills(skills);

    assertEquals(skills, heist.getSkills());
  }

  @Test
  void getId() {
    Long idValue = 4L;

    heist.setId(idValue);

    assertEquals(idValue, heist.getId());
  }
}