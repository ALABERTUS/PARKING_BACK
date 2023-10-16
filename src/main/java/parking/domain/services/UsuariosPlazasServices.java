package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;
import parking.domain.models.Usuarios;
import parking.domain.models.UsuariosPlazas;

import java.util.List;
import java.util.ArrayList;

@Service
public class UsuariosPlazasServices {

    @Autowired
    private UsuariosServices usuariosServices;

    @GetMapping("/usuarios/{id}")
    public Usuarios obtenerUsuario(@PathVariable Integer id) {
        return usuariosServices.obtenerUsuarioPorId(id);
    }

    public List<UsuariosPlazas> obtenerRelacionPorPlaza(int idPlaza) {
        EntityManager em = emf.createEntityManager();
        List<UsuariosPlazas> relaciones = em.createQuery("SELECT r FROM UsuariosPlazas r WHERE r.plaza.idPlaza = :idPlaza", UsuariosPlazas.class)
                .setParameter("idPlaza", idPlaza).getResultList();
        em.close();
        return relaciones;
    }
    private final EntityManagerFactory emf;

    public UsuariosPlazasServices() {
        emf = Persistence.createEntityManagerFactory("parking");
    }

    public List<UsuariosPlazas> listarRelaciones() {
        EntityManager em = emf.createEntityManager();
        List<UsuariosPlazas> relaciones = em.createQuery("SELECT r FROM UsuariosPlazas r", UsuariosPlazas.class).getResultList();
        em.close();
        return relaciones;
    }

    public UsuariosPlazas crearRelacion(UsuariosPlazas relacion) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        UsuariosPlazas nuevarelacion = null;

        try {
            tx.begin();
            em.persist(relacion);
            tx.commit();
            nuevarelacion = relacion;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

        return nuevarelacion;
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
