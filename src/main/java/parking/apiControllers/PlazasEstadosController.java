package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.PlazasEstados;
import parking.domain.services.PlazasEstadosService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plazasestados")
public class PlazasEstadosController {
    private final PlazasEstadosService plazasEstadosService;

    @Autowired
    public PlazasEstadosController(PlazasEstadosService plazasEstadosService) {
        this.plazasEstadosService = plazasEstadosService;
    }

    @PostMapping
    public void crearPlazasEstados(@RequestBody PlazasEstados plazasEstados) {
        plazasEstadosService.crearPlazasEstados(plazasEstados);
    }

    @GetMapping("/{id}")
    public PlazasEstados obtenerPlazasEstados(@PathVariable Integer id) {
        return plazasEstadosService.obtenerPlazasEstadosPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarPlazasEstados(@PathVariable Integer id, @RequestBody PlazasEstados plazasEstadosActualizado) {
        PlazasEstados plazasEstadosExistente = plazasEstadosService.obtenerPlazasEstadosPorId(id);
        if (plazasEstadosExistente != null) {
            plazasEstadosActualizado.setId(id);
            plazasEstadosService.actualizarPlazasEstados(plazasEstadosActualizado);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarPlazasEstados(@PathVariable Integer id) {
        plazasEstadosService.eliminarPlazasEstados(id);
    }

    @GetMapping
    public List<PlazasEstados> obtenerTodasLasPlazasEstados() {
        return plazasEstadosService.obtenerTodasLasPlazasEstados();
    }
}
