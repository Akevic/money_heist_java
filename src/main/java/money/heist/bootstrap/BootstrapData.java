package money.heist.bootstrap;

import money.heist.model.Heist;
import money.heist.model.HeistMember;
import money.heist.model.Sex;
import money.heist.model.HeistMemberStatus;
import money.heist.repositories.HeistMemberRepository;
import money.heist.repositories.HeistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
  private final HeistRepository heistRepository;
  private final HeistMemberRepository heistMemberRepository;

  public BootstrapData(HeistRepository heistRepository, HeistMemberRepository heistMemberRepository) {
    this.heistRepository = heistRepository;
    this.heistMemberRepository = heistMemberRepository;
  }

  @Override
  public void run(String... args) {
    System.out.println("Started bootstrap");

    HeistMember eric = new HeistMember();
    eric.setName("Eric");
    eric.setEmail("eric@email.com");
    eric.setSex(Sex.M);
    eric.setSkills("Driving, Lock-picking");
    eric.setMainSkill("Driving");
    eric.setStatus(HeistMemberStatus.AVAILABLE);

    heistMemberRepository.save(eric);

    Heist bank = new Heist();
    bank.setName("Bank");
    bank.setLocation("Madrid");
    bank.setStartTime("12.9.2021");
    bank.setEndTime("12.10.2021");
    bank.setSkills("Driving, Combat, Lock-picking");


    heistRepository.save(bank);

    System.out.println("Number of heists: " + heistRepository.count());

    System.out.println("Number of heist members: " + heistMemberRepository.count());
  }
}
