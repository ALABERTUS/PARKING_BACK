package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import parking.domain.models.UsuariosPlazas;

@Service
public class UsuariosPlazasServices {
    private final EntityManagerFactory emf;

    public UsuariosPlazasServices() {
        emf = Persistence.createEntityManagerFactory("parking");
    }

    public void crearRelacion(UsuariosPlazas relacion) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(relacion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public UsuariosPlazas obtenerRelacion(int id) {
        EntityManager em = emf.createEntityManager();
        UsuariosPlazas relacion = em.find(UsuariosPlazas.class, id);
        em.close();
        return relacion;
    }

    public void actualizarRelacion(UsuariosPlazas relacion) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(relacion);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void eliminarRelacion(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            UsuariosPlazas relacion = em.find(UsuariosPlazas.class, id);
            if (relacion != null) {
                em.remove(relacion);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }
}
