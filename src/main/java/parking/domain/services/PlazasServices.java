package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import parking.domain.models.Plazas;
import parking.domain.models.Sotanos;

import java.util.ArrayList;
import java.util.List;

public class PlazasServices {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Plazas> listarPlazas() {
        return entityManager.createQuery("SELECT p FROM Plazas p", Plazas.class).getResultList();
    }

    public Plazas obtenerPlazas(int idPlaza) {
        return entityManager.find(Plazas.class, idPlaza);
    }

    @Transactional
    public void crearPlaza(Plazas plaza) {
        entityManager.merge(plaza);
    }

    @Transactional
    public void actualizarPlaza(Plazas plaza) {
        entityManager.merge(plaza);
    }

    @Transactional
    public void eliminarPlaza(int idPlaza) {
        Plazas plaza = entityManager.find(Plazas.class, idPlaza);
        entityManager.remove(plaza);
    }
}

