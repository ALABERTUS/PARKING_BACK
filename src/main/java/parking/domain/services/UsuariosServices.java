package parking.domain.services;

import parking.domain.models.Usuarios;
import parking.infra.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosServices(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Usuarios findById(Integer id) {
        Optional<Usuarios> optionalUsuario = usuariosRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public Usuarios save(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public Usuarios update(Integer id, Usuarios usuario) {
        if (usuariosRepository.existsById(id)) {
            usuario.setId(id);  // Ensure the ID is set for the update
            return usuariosRepository.save(usuario);
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        usuariosRepository.deleteById(id);
    }
}