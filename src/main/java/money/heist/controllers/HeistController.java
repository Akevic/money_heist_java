package money.heist.controllers;

import com.google.common.collect.Iterables;
import money.heist.model.Heist;
import money.heist.model.HeistStatus;
import money.heist.model.UpdateSkills;
import money.heist.repositories.HeistRepository;
import money.heist.utils.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HeistController {
  private final HeistRepository heistRepository;

  public HeistController(HeistRepository heistRepository) {
    this.heistRepository = heistRepository;
  }

  @GetMapping("/heists")
  Iterable<Heist> fetchAll() {
    Iterable<Heist> heists = heistRepository.findAll();

    if (Iterables.size(heists) == 0) throw new NotFoundException();

    return heists;
  }

  @PostMapping("/heist")
  Heist add(@RequestBody Heist newHeist) {
    return heistRepository.save(newHeist);
  }

  @GetMapping("/heist/{id}")
  Heist getOne(@PathVariable Long id) {
    return heistRepository.findById(id)
      .orElseThrow(NotFoundException::new);
  }

  @DeleteMapping("/heist/{id}")
  HttpStatus delete(@PathVariable Long id) {
    heistRepository.deleteById(id);

    return HttpStatus.NO_CONTENT;
  }

  @PutMapping("/heist/{id}")
  HttpStatus update(@PathVariable Long id, @RequestBody UpdateSkills value) {
    Optional<Heist> targetHeist = heistRepository.findById(id);

    targetHeist.map(target -> {
      target.setSkills(value.getSkill());
      return heistRepository.save(target);
    });

    return HttpStatus.NO_CONTENT;
  }

  @PutMapping("/heist/{id}/start")
  HttpStatus start(@PathVariable Long id) {
    Heist heist = heistRepository.findById(id).orElse(null);

    if (heist == null) throw new NotFoundException();

    heist.setStatus(HeistStatus.READY);
    heistRepository.save(heist);

    return HttpStatus.OK;
  }

  @GetMapping("/heist/{id}/skills")
  String getSkills(@PathVariable Long id) {
    Heist heist = heistRepository.findById(id).orElse(null);

    if (heist == null) throw new NotFoundException();

    return heist.getSkills();
  }

  @GetMapping("heist/{id}/status")
  HeistStatus getStatus(@PathVariable Long id) {
    Heist heist = heistRepository.findById(id).orElse(null);

    if (heist == null) throw new NotFoundException();

    return heist.getStatus();
  }
}
