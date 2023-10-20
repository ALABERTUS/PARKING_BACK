package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Plazas;
import parking.domain.services.PlazasServices;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plazas")
public class PlazasController {
    private final PlazasServices plazasServices;

    @Autowired
    public PlazasController(PlazasServices plazasServices) {
        this.plazasServices = plazasServices;
    }

    @PostMapping
    public void crearPlaza(@RequestBody Plazas plaza) {
        plazasServices.crearPlaza(plaza);
    }

    @GetMapping("/{id}")
    public Plazas obtenerPlazaPorId(@PathVariable Integer id) { // Cambio de Long a Integer
        return plazasServices.obtenerPlazaPorId(id);
    }

    @GetMapping
    public List<Plazas> obtenerTodasLasPlazas() {
        return plazasServices.obtenerTodasLasPlazas();
    }

    @PutMapping("/{id}")
    public void actualizarPlaza(@PathVariable Integer id, @RequestBody Plazas plazaActualizada) { // Cambio de Long a Integer
        plazaActualizada.setId(id);
        plazasServices.actualizarPlaza(id, plazaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlaza(@PathVariable Integer id) { // Cambio de Long a Integer
        plazasServices.eliminarPlaza(id);
    }
}
