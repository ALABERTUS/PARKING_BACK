package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.Usuarios;
import parking.infraRepositories.UsuariosRepository;

import java.util.List;

@Service
public class UsuariosServices {
    private final UsuariosRepository usuariosRepository;

    public UsuariosServices(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public void crearUsuario(Usuarios usuario) {
        usuariosRepository.save(usuario);
    }

    public Usuarios obtenerUsuarioPorId(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    public void actualizarUsuario(Usuarios usuarioActualizado) {
        usuariosRepository.save(usuarioActualizado);
    }

    public void eliminarUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return usuariosRepository.findAll();
    }
}



