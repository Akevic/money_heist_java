package money.heist.controllers;

import money.heist.model.HeistMember;
import money.heist.repositories.HeistMemberRepository;
import money.heist.utils.HeistNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeistMemberController {
  private final HeistMemberRepository heistMemberRepository;

  public HeistMemberController(HeistMemberRepository heistMemberRepository) {
    this.heistMemberRepository = heistMemberRepository;
  }

  @GetMapping("/heist_members")
  Iterable<HeistMember> getMembers() {
    return heistMemberRepository.findAll();
  }

  @PostMapping("/heist_member")
  HeistMember addHeistMember(@RequestBody HeistMember newMember) {
    return heistMemberRepository.save(newMember);
  }

  @GetMapping("/heist_member/{id}")
  HeistMember getOne(@PathVariable Long id) {
    return heistMemberRepository.findById(id)
      .orElseThrow(() -> new HeistNotFoundException(id));
  }
}
