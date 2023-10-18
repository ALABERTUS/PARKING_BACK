package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.UsuariosPlazas;
import parking.infraRepositories.UsuariosPlazasRepository; // Asegúrate de importar el repositorio

import java.util.List;

@Service
public class UsuariosPlazasService {
    private final UsuariosPlazasRepository usuariosPlazasRepository;

    public UsuariosPlazasService(UsuariosPlazasRepository usuariosPlazasRepository) {
        this.usuariosPlazasRepository = usuariosPlazasRepository;
    }

    public void crearUsuariosPlazas(UsuariosPlazas usuariosPlazas) {
        usuariosPlazasRepository.save(usuariosPlazas);
    }

    public UsuariosPlazas obtenerUsuariosPlazasPorId(Integer id) {
        return usuariosPlazasRepository.findById(id).orElse(null);
    }

    public void actualizarUsuariosPlazas(UsuariosPlazas usuariosPlazasActualizado) {
        usuariosPlazasRepository.save(usuariosPlazasActualizado);
    }

    public void eliminarUsuariosPlazas(Integer id) {
        usuariosPlazasRepository.deleteById(id);
    }

    public List<UsuariosPlazas> obtenerTodosLosUsuariosPlazas() {
        return usuariosPlazasRepository.findAll();
    }
}
