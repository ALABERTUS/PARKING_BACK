package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Plazas;
import parking.domain.services.PlazasServices;
import parking.domain.models.Usuarios;
import parking.domain.models.UsuariosPlazas;
import parking.domain.services.UsuariosPlazasServices;
import parking.domain.services.UsuariosServices;

import java.util.List;

@RestController
@RequestMapping("/usuariosPlazas")
public class UsuariosPlazasController {

    @Autowired
    private UsuariosServices usuariosServices;

    @Autowired
    private final UsuariosPlazasServices usuariosPlazasServices;

    @Autowired
    private PlazasServices plazasServices;

    @GetMapping("/usuarios/{id}")
    public Usuarios obtenerUsuario(@PathVariable Integer id) {
        return usuariosServices.obtenerUsuarioPorId(id);
    }

    @Autowired
    public UsuariosPlazasController(UsuariosPlazasServices usuariosPlazasServices) {
        this.usuariosPlazasServices = usuariosPlazasServices;
    }

    @GetMapping
    public List<UsuariosPlazas> listarRelaciones() {
        return usuariosPlazasServices.listarRelaciones();
    }

    @GetMapping("/{id}")
    public UsuariosPlazas obtenerRelacion(@PathVariable Integer id) {
        return usuariosPlazasServices.obtenerRelacion(id);
    }

    @PostMapping
    public UsuariosPlazas crearRelacion(@RequestBody UsuariosPlazas relacion) {
        return usuariosPlazasServices.crearRelacion(relacion);
    }

    @PutMapping("/asignarPlaza")
    public UsuariosPlazas asignarPlaza(@RequestBody UsuariosPlazas nuevarelacion) {
        Usuarios usuario = usuariosPlazasServices.obtenerUsuario(nuevarelacion.getUsuario().getId());
        Plazas plaza = plazasServices.obtenerPlazaporId(nuevarelacion.getPlaza().getId());

        if (usuario != null && plaza != null) {
            nuevarelacion.setUsuario(usuario);
            nuevarelacion.setPlaza(plaza);
            return usuariosPlazasServices.crearRelacion(nuevarelacion);
        } else {
            return null;
        }

    }

    @PutMapping("/{id}")
    public UsuariosPlazas actualizarRelacion(@PathVariable Integer id, @RequestBody UsuariosPlazas relacionActualizada) {
        UsuariosPlazas relacionExistente = usuariosPlazasServices.obtenerRelacion(id);
        if (relacionExistente != null) {
            relacionExistente.setPlaza(relacionActualizada.getPlaza());
            relacionExistente.setUsuario(relacionActualizada.getUsuario());
            relacionExistente.setFecha(relacionActualizada.getFecha());

            usuariosPlazasServices.actualizarRelacion(relacionExistente);
            return relacionExistente;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarRelacion(@PathVariable Integer id) {
        usuariosPlazasServices.eliminarRelacion(id);
    }
}
