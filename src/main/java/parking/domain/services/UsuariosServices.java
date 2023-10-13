package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import parking.domain.models.Usuarios;

import java.util.List;

public class UsuariosServices {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ParkingPU");

    @Transactional
    public void crearUsuario(Usuarios usuario) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public Usuarios obtenerUsuarioPorId(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Usuarios usuario = em.find(Usuarios.class, id);
        em.close();
        return usuario;
    }

    @Transactional
    public void actualizarUsuario(Usuarios usuarioActualizado) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(usuarioActualizado);
        em.getTransaction().commit();
        em.close();
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Usuarios usuario = em.find(Usuarios.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        EntityManager em = entityManagerFactory.createEntityManager();
        TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
        List<Usuarios> usuarios = query.getResultList();
        em.close();
        return usuarios;
    }
}




