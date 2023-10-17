package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.UsuariosPlazas;
import parking.domain.services.UsuariosPlazasService;

import java.util.List;

@RestController
@RequestMapping("/usuariosplazas")
public class UsuariosPlazasController {
    private final UsuariosPlazasService usuariosPlazasService;

    @Autowired
    public UsuariosPlazasController(UsuariosPlazasService usuariosPlazasService) {
        this.usuariosPlazasService = usuariosPlazasService;
    }

    @PostMapping
    public void crearUsuariosPlazas(@RequestBody UsuariosPlazas usuariosPlazas) {
        usuariosPlazasService.crearUsuariosPlazas(usuariosPlazas);
    }

    @GetMapping("/{id}")
    public UsuariosPlazas obtenerUsuariosPlazas(@PathVariable Integer id) {
        return usuariosPlazasService.obtenerUsuariosPlazasPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarUsuariosPlazas(@PathVariable Integer id, @RequestBody UsuariosPlazas usuariosPlazasActualizado) {
        UsuariosPlazas usuariosPlazasExistente = usuariosPlazasService.obtenerUsuariosPlazasPorId(id);
        if (usuariosPlazasExistente != null) {
            usuariosPlazasActualizado.setId(id);
            usuariosPlazasService.actualizarUsuariosPlazas(usuariosPlazasActualizado);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuariosPlazas(@PathVariable Integer id) {
        usuariosPlazasService.eliminarUsuariosPlazas(id);
    }

    @GetMapping
    public List<UsuariosPlazas> obtenerTodosLosUsuariosPlazas() {
        return usuariosPlazasService.obtenerTodosLosUsuariosPlazas();
    }
}

