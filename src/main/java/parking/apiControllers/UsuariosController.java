package parking.apiControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Usuarios;
import parking.domain.services.UsuariosServices;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/usuarios")
public class UsuariosController {
    private final UsuariosServices usuariosServices;

    public UsuariosController(UsuariosServices usuariosServices) {
        this.usuariosServices = usuariosServices;
    }

    @PostMapping
    public ResponseEntity<Void> crearUsuario(@RequestBody Usuarios usuario) {
        usuariosServices.crearUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable Integer id) {
        Usuarios usuario = usuariosServices.obtenerUsuarioPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioActualizado) {
        Usuarios existingUsuario = usuariosServices.obtenerUsuarioPorId(id);
        if (existingUsuario != null) {
            usuarioActualizado.setId(id);
            usuariosServices.actualizarUsuario(usuarioActualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuariosServices.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuarios>> obtenerTodosLosUsuarios() {
        List<Usuarios> usuarios = usuariosServices.obtenerTodosLosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}

