package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Sotanos;
import parking.infraRepositories.SotanosRepository;
import java.util.Optional;

@RestController
@RequestMapping("/sotanos")
public class SotanosController {

    @Autowired
    private SotanosRepository sotanosRepository;

    @PostMapping
    public Sotanos createSotano(@RequestBody Sotanos sotano) {
        return sotanosRepository.save(sotano);
    }

    @GetMapping("/{id}")
    public Optional<Sotanos> getSotanoById(@PathVariable Integer id) {
        return sotanosRepository.findById(id);
    }

    @GetMapping
    public Iterable<Sotanos> getAllSotanos() {
        return sotanosRepository.findAll();
    }

    @PutMapping("/{id}")
    public Sotanos updateSotano(@PathVariable Integer id, @RequestBody Sotanos sotano) {
        sotano.setIdSotano(id);
        return sotanosRepository.save(sotano);
    }

    @DeleteMapping("/{id}")
    public void deleteSotano(@PathVariable Integer id) {
        sotanosRepository.deleteById(id);
    }
}
