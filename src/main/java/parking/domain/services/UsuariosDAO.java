package parking.domain.services;

import parking.domain.models.Usuarios;
import parking.domain.models.Rol;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
    private List<Usuarios> usuarios = new ArrayList<>();
    private Integer usuarioId = 1;

    public Usuarios crearUsuario(String nombre, String email, String dni, Integer telefono, Rol rol) {
        Usuarios usuario = new Usuarios(usuarioId, nombre, email, dni, telefono, rol);
        usuario.setId(usuarioId);
        usuarios.add(usuario);
        usuarioId++;
        return usuario;
    }

    public Usuarios obtenerUsuarioPorId(Integer id) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(Usuarios usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuario.getId())) {
                usuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(Integer id) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public List<Usuarios> listarUsuarios() {
        return usuarios;
    }
}
