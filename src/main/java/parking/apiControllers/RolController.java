package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Rol;
import parking.domain.services.RolService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public void crearRol(@RequestBody Rol rol) {
        rolService.crearRol(rol);
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable Integer id) { // Cambio de Long a Integer
        return rolService.obtenerRolPorId(id);
    }

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PutMapping("/{id}")
    public void actualizarRol(@PathVariable Integer id, @RequestBody Rol rolActualizado) { // Cambio de Long a Integer
        rolActualizado.setId(id);
        rolService.actualizarRol(rolActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Integer id) { // Cambio de Long a Integer
        rolService.eliminarRol(id);
    }
}

