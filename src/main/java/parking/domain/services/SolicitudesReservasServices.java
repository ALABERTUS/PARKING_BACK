package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import parking.domain.models.SolicitudesReservas;

import java.util.List;

@Service
public class SolicitudesReservasServices {
    private final EntityManagerFactory emf;

    public SolicitudesReservasServices() {
        emf = Persistence.createEntityManagerFactory("parking");
    }

    public void crearSolicitud(SolicitudesReservas solicitud) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(solicitud);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public SolicitudesReservas obtenerSolicitudes(int id) {
        EntityManager em = emf.createEntityManager();
        SolicitudesReservas solicitud = em.find(SolicitudesReservas.class, id);
        em.close();
        return solicitud;
    }

    public void actualizarSolicitudes(SolicitudesReservas solicitud) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(solicitud);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void eliminarSolicitudes(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            SolicitudesReservas solicitud = em.find(SolicitudesReservas.class, id);
            if (solicitud != null) {
                em.remove(solicitud);
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

    public List<SolicitudesReservas> listarSolicitudes() {
        EntityManager em = emf.createEntityManager();
        List<SolicitudesReservas> solicitudes = em.createQuery("SELECT s FROM SolicitudesReservas s", SolicitudesReservas.class).getResultList();
        em.close();
        return solicitudes;
    }
}
