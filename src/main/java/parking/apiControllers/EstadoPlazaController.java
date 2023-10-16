package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.EstadoPlaza;
import parking.infraRepositories.EstadoPlazaRepository;

import java.util.List;

@RestController
@RequestMapping("/estadosplaza")
public class EstadoPlazaController {

    private final EstadoPlazaRepository estadoPlazaRepository;

    @Autowired
    public EstadoPlazaController(EstadoPlazaRepository estadoPlazaRepository) {
        this.estadoPlazaRepository = estadoPlazaRepository;
    }

    @GetMapping
    public List<EstadoPlaza> listarEstadosPlaza(){
        return estadoPlazaRepository.findAll();
    }

    @GetMapping("/{id}")
    public EstadoPlaza obtenerEstadoPlaza(@PathVariable Integer id){
        return estadoPlazaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public EstadoPlaza crearEstadoPlaza(@RequestBody EstadoPlaza estadoPlaza){
        return estadoPlazaRepository.save(estadoPlaza);
    }

    @PutMapping("/{id}")
    public EstadoPlaza actualizarEstadoPlaza(@PathVariable Integer id, @RequestBody EstadoPlaza estadoPlazaActualizado){
        estadoPlazaActualizado.setId(id);
        return estadoPlazaRepository.save(estadoPlazaActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstadoPlaza(@PathVariable Integer id){
        estadoPlazaRepository.deleteById(id);
    }
}
