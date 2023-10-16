package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Usuarios;
import parking.domain.services.UsuariosServices;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final UsuariosServices usuariosServices;

    @Autowired
    public UsuariosController(UsuariosServices usuariosServices) {
        this.usuariosServices = usuariosServices;
    }

    @PostMapping
    public void crearUsuario(@RequestBody Usuarios usuario) {
        usuariosServices.crearUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuarios obtenerUsuario(@PathVariable Integer id) {
        return usuariosServices.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioActualizado) {
        Usuarios usuarioExistente = usuariosServices.obtenerUsuarioPorId(id);
        if (usuarioExistente != null) {
            usuarioActualizado.setId(id);
            usuariosServices.actualizarUsuario(usuarioActualizado);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuariosServices.eliminarUsuario(id);
    }

    @GetMapping
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return usuariosServices.obtenerTodosLosUsuarios();
    }
}
