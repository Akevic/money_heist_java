package money.heist.controllers;

import money.heist.model.Heist;
import money.heist.repositories.HeistRepository;
import money.heist.utils.HeistNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeistController {
  private final HeistRepository heistRepository;

  public HeistController(HeistRepository heistRepository) {
    this.heistRepository = heistRepository;
  }

  @GetMapping("/heists")
  Iterable<Heist> GetHeists() {
    return heistRepository.findAll();
  }

  @PostMapping("/heist")
  Heist addHeist(@RequestBody Heist newHeist) {
    return heistRepository.save(newHeist);
  }

  @GetMapping("/heist/{id}")
  Heist getOne(@PathVariable Long id) {
    return heistRepository.findById(id)
      .orElseThrow(() -> new HeistNotFoundException(id));
  }
}
