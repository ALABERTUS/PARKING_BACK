package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Sotanos;
import parking.domain.services.SotanosServices;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sotanos")
public class SotanosController {

    private final SotanosServices sotanosServices;

    @Autowired
    public SotanosController(SotanosServices sotanosServices) {
        this.sotanosServices = sotanosServices;
    }

    @GetMapping
    public List<Sotanos> listarSotanos() {
        return sotanosServices.listarSotanos();
    }

    @GetMapping("/{id}")
    public Sotanos obtenerSotano(@PathVariable Integer id) {
        return sotanosServices.obtenerSotanoPorId(id);
    }

    @PostMapping
    public Sotanos crearSotano(@RequestBody Sotanos sotano) {
        return sotanosServices.crearSotano(sotano);
    }

    @PutMapping("/{id}")
    public Sotanos actualizarSotano(@PathVariable Integer id, @RequestBody Sotanos sotanoActualizado) {
        return sotanosServices.actualizarSotano(id, sotanoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarSotano(@PathVariable Integer id) {
        sotanosServices.eliminarSotano(id);
    }
}
