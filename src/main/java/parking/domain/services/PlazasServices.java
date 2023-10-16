package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking.domain.models.Plazas;

import java.util.List;

@Service
public class PlazasServices {
    @PersistenceContext
    private EntityManager entityManager;

    private final EntityManagerFactory emf;

    public PlazasServices() {
        emf = Persistence.createEntityManagerFactory("parking");
    }
    public Plazas obtenerPlazaporId(int id) {
        EntityManager em = emf.createEntityManager();
        Plazas plaza = em.find(Plazas.class, id);
        em.close();
        return plaza;
    }

    public List<Plazas> listarPlazas() {
        return entityManager.createQuery("SELECT p FROM Plazas p", Plazas.class).getResultList();
    }

    public Plazas obtenerPlaza(int idPlaza) {
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

