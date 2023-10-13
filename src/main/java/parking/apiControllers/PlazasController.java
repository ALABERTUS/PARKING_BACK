package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Plazas;
import parking.domain.services.PlazasServices;

import java.util.List;

@RestController
@RequestMapping("/plazas")
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
    public Plazas obtenerPlazaPorId(@PathVariable Long id) {
        return plazasServices.obtenerPlazaPorId(id);
    }

    @GetMapping
    public List<Plazas> obtenerTodasLasPlazas() {
        return plazasServices.obtenerTodasLasPlazas();
    }

    @PutMapping("/{id}")
    public void actualizarPlaza(@PathVariable Long id, @RequestBody Plazas plazaActualizada) {
        plazaActualizada.setId(id);
        plazasServices.actualizarPlaza(plazaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlaza(@PathVariable Long id) {
        plazasServices.eliminarPlaza(id);
    }
}
