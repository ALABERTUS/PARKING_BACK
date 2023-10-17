package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.PlazasEstados;
import parking.infraRepositories.PlazasEstadosRepository;

import java.util.List;

@RestController
@RequestMapping("/plazasestados")
public class PlazasEstadosController {

    private PlazasEstadosRepository plazasEstadosRepository;

    @Autowired
    public PlazasEstadosController(PlazasEstadosRepository plazasEstadosRepository) {
        this.plazasEstadosRepository = plazasEstadosRepository;
    }

    @GetMapping("/")
    public List<PlazasEstados> getAllPlazasEstados() {
        return plazasEstadosRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlazasEstados getPlazasEstadosById(@PathVariable Integer id) {
        return plazasEstadosRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void createPlazasEstados(@RequestBody PlazasEstados plazasEstados) {
        plazasEstadosRepository.save(plazasEstados);
    }

    @PutMapping("/{id}")
    public void updatePlazasEstados(@PathVariable Integer id, @RequestBody PlazasEstados plazasEstados) {
        if (plazasEstadosRepository.existsById(id)) {
            plazasEstados.setId(id);
            plazasEstadosRepository.save(plazasEstados);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlazasEstados(@PathVariable Integer id) {
        plazasEstadosRepository.deleteById(id);
    }
}

