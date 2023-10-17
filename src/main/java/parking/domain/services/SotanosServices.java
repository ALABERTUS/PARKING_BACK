package parking.domain.services;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import parking.domain.models.Sotanos;

@Service
public class SotanosServices {
    private EntityManagerFactory emf;

    public SotanosServices() {
        emf = Persistence.createEntityManagerFactory("parking");
    }

    public void createSotano(Sotanos sotano) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(sotano);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Sotanos getSotanoById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Sotanos.class, id);
        } finally {
            em.close();
        }
    }

    public List<Sotanos> getAllSotanos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Sotanos s", Sotanos.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void updateSotano(Sotanos sotano) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sotano);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteSotano(Sotanos sotano) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            sotano = em.find(Sotanos.class, sotano.getIdSotano());
            if (sotano != null) {
                em.remove(sotano);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

