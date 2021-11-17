package money.heist.controllers;

import com.google.common.collect.Iterables;
import money.heist.model.HeistMember;
import money.heist.model.UpdateSkills;
import money.heist.repositories.HeistMemberRepository;
import money.heist.utils.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HeistMemberController {
  private final HeistMemberRepository heistMemberRepository;

  public HeistMemberController(HeistMemberRepository heistMemberRepository) {
    this.heistMemberRepository = heistMemberRepository;
  }

  @GetMapping("/heist_members")
  Iterable<HeistMember> fetchAll() {
    Iterable<HeistMember> heistMembers = heistMemberRepository.findAll();

    if (Iterables.size(heistMembers) == 0) throw new NotFoundException();

    return heistMembers;
  }

  @PostMapping("/heist_member")
  HeistMember add(@RequestBody HeistMember newMember) {
    return heistMemberRepository.save(newMember);
  }

  @GetMapping("/heist_member/{id}")
  HeistMember fetchOne(@PathVariable Long id) {
    return heistMemberRepository.findById(id)
      .orElseThrow(NotFoundException::new); //* method reference (className :: methodName)
  }

  @DeleteMapping("/heist_member/{id}")
  HttpStatus delete(@PathVariable Long id) {
    heistMemberRepository.deleteById(id);

    return HttpStatus.NO_CONTENT;
  }

  @PutMapping("/heist_member/{id}")
  HttpStatus update(@PathVariable Long id, @RequestBody UpdateSkills value) {
    Optional<HeistMember> targetHeistMember = heistMemberRepository.findById(id);

    targetHeistMember.map(target -> {
      target.setSkills(value.getSkill());
      return heistMemberRepository.save(target);
    });

    return HttpStatus.NO_CONTENT;
  }

  @GetMapping("/heist_member/{id}/skills")
  String getSkills(@PathVariable Long id) {
    HeistMember heistMember = heistMemberRepository.findById(id).orElse(null);

    if (heistMember == null) throw new NotFoundException();

    return heistMember.getSkills();
  }
}
