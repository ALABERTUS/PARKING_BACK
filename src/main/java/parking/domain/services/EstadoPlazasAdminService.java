package parking.domain.services;
import parking.domain.models.EstadoPlazasAdmin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoPlazasAdminService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearEstadoPlazasAdmin(EstadoPlazasAdmin estadoPlazasAdmin) {
        entityManager.persist(estadoPlazasAdmin);
    }

    @Transactional
    public EstadoPlazasAdmin obtenerEstadoPlazasAdminPorId(Long id) {
        return entityManager.find(EstadoPlazasAdmin.class, id);
    }

    @Transactional
    public void actualizarEstadoPlazasAdmin(EstadoPlazasAdmin estadoPlazasAdmin) {
        entityManager.merge(estadoPlazasAdmin);
    }

    @Transactional
    public void eliminarEstadoPlazasAdmin(Long id) {
        EstadoPlazasAdmin estadoPlazasAdmin = obtenerEstadoPlazasAdminPorId(id);
        if (estadoPlazasAdmin != null) {
            entityManager.remove(estadoPlazasAdmin);
        }
    }
}
