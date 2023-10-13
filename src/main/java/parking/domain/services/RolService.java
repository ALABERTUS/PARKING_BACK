package parking.domain.services;
import parking.domain.models.Rol;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearRol(Rol rol) {
        entityManager.persist(rol);
    }

    @Transactional
    public Rol obtenerRolPorId(Integer id) {
        return entityManager.find(Rol.class, id);
    }

    @Transactional
    public void actualizarRol(Rol rol) {
        entityManager.merge(rol);
    }

    @Transactional
    public void eliminarRol(Integer id) {
        Rol rol = obtenerRolPorId(id);
        if (rol != null) {
            entityManager.remove(rol);
        }
    }
}
