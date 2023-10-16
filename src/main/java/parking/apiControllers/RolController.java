package parking.apiControllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Rol;
import parking.domain.services.RolServices;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolServices rolServices;

    @Autowired
    public RolController(RolServices rolServices) {
        this.rolServices = rolServices;
    }

    @GetMapping
    public List<Rol> listarRoles() {
        return rolServices.listarRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol>obtenerRol(@PathVariable Integer id) {
        Rol rol = rolServices.obtenerRol(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crearRol(@RequestBody String nombreRol) {
        rolServices.crearRol(nombreRol);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol Creado Correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarRol(@PathVariable Integer id, @RequestBody String nombreRol) {
        Rol rol = rolServices.obtenerRol(id);
        if (rol != null) {
            rol.setNombreRol(nombreRol);
            rolServices.actualizarRol(rol);
            return ResponseEntity.ok("Rol Actualizado Correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRol(@PathVariable Integer id) {
        Rol rol = rolServices.obtenerRol(id);
        if (rol != null) {
            rolServices.eliminarRol(id);
            return ResponseEntity.ok("Rol Eliminado Correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
