package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Plazas;
import parking.domain.models.UsuariosPlazas;
import parking.domain.services.PlazasServices;
import parking.domain.services.UsuariosPlazasServices;

import java.util.List;

@RestController
@RequestMapping("/plazas")
public class PlazasController {
    private final PlazasServices plazasServices;
    private final UsuariosPlazasServices usuariosPlazasServices;

    @Autowired
    public PlazasController(PlazasServices plazasServices, UsuariosPlazasServices usuariosPlazasServices) {
        this.plazasServices = plazasServices;
        this.usuariosPlazasServices = usuariosPlazasServices;
    }

    @GetMapping("/{id}/usuariosPlazas")
    public List<UsuariosPlazas> obtenerRelacionPorPlaza(@PathVariable int id) {
        return usuariosPlazasServices.obtenerRelacionPorPlaza(id);
    }

    @GetMapping
    public List<Plazas> listarPlazas() {
        return plazasServices.listarPlazas();
    }

    @GetMapping("/{id}")
    public Plazas obtenerPlazas(@PathVariable Integer id) {
        return plazasServices.obtenerPlaza(id);
    }

    @PostMapping
    public void crearPlaza(@RequestBody Plazas plaza) {
        plazasServices.crearPlaza(plaza);
    }

    @PutMapping("/{id}")
    public void actualizarPlaza(@PathVariable Integer id, @RequestBody Plazas plaza) {
        plaza.setIdPlaza(id);
        plazasServices.actualizarPlaza(plaza);
    }

    @DeleteMapping("/{id}")
    public void eliminarPlaza(@PathVariable Integer id) {
        plazasServices.eliminarPlaza(id);
    }
}
