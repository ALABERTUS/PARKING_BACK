package parking.domain.services;

import parking.domain.models.Sotanos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SotanosService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearSotano(Sotanos sotano) {
        entityManager.persist(sotano);
    }

    @Transactional
    public Sotanos obtenerSotanoPorId(Long id) {
        return entityManager.find(Sotanos.class, id);
    }

    @Transactional
    public void actualizarSotano(Sotanos sotano) {
        entityManager.merge(sotano);
    }

    @Transactional
    public void eliminarSotano(Long id) {
        Sotanos sotano = obtenerSotanoPorId(id);
        if (sotano != null) {
            entityManager.remove(sotano);
        }
    }
}
