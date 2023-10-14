package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking.domain.models.Usuarios;

import java.util.List;

@Service
public class UsuariosServices {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearUsuario(Usuarios usuario) {
        entityManager.persist(usuario);
    }

    public Usuarios obtenerUsuarioPorId(Long id) {
        return entityManager.find(Usuarios.class, id);
    }

    @Transactional
    public void actualizarUsuario(Usuarios usuarioActualizado) {
        entityManager.merge(usuarioActualizado);
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        Usuarios usuario = obtenerUsuarioPorId(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        return entityManager.createQuery("SELECT u FROM Usuarios u", Usuarios.class).getResultList();
    }
}




