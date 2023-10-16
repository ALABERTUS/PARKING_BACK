package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.Rol;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolServices {
    private List<Rol> roles;

    public RolServices() {
        roles = new ArrayList<>();
    }

    public void crearRol(String nombreRol) {
        int newId = roles.size() + 1;
        Rol rol = new Rol (newId, nombreRol);
        roles.add(rol);
    }

    public Rol obtenerRol(Integer id) {
        for (Rol rol : roles) {
            if (rol.getId() == id) {
                return rol;
            }
        }
        return null;
    }

    public void actualizarRol(Rol actualizarRol) {
        for (Rol rol : roles) {
            if (rol.getId() == actualizarRol.getId()) {
                rol.setNombreRol(actualizarRol.getNombreRol());
                break;
            }
        }
    }

    public void eliminarRol(Integer id) {
        Rol rolToEliminar = null;
        for (Rol rol : roles) {
            if (rol.getId() == id) {
                rolToEliminar = rol;
                break;
            }
        }
        if (rolToEliminar != null) {
            roles.remove(rolToEliminar);
        }
    }

    public List<Rol> listarRoles() {
        return roles;
    }
}
