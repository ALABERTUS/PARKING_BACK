package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking.domain.models.Rol;

import java.util.List;

@Service
public class RolService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearRol(Rol rol) {
        entityManager.persist(rol);
    }

    @Transactional
    public Rol obtenerRolPorId(Integer id) { // Cambio de Long a Integer
        return entityManager.find(Rol.class, id);
    }

    @Transactional
    public void actualizarRol(Rol rol) {
        entityManager.merge(rol);
    }

    @Transactional
    public void eliminarRol(Integer id) { // Cambio de Long a Integer
        Rol rol = obtenerRolPorId(id);
        if (rol != null) {
            entityManager.remove(rol);
        }
    }

    @Transactional
    public List<Rol> obtenerTodosLosRoles() {
        return entityManager.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
    }
}


