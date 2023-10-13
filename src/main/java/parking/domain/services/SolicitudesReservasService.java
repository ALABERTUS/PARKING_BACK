package parking.domain.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking.domain.models.SolicitudesReservas;

@Service
public class SolicitudesReservasService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearSolicitudReserva(SolicitudesReservas solicitudReserva) {
        entityManager.persist(solicitudReserva);
    }

    @Transactional
    public SolicitudesReservas obtenerSolicitudReservaPorId(Long id) {
        return entityManager.find(SolicitudesReservas.class, id);
    }

    @Transactional
    public void actualizarSolicitudReserva(SolicitudesReservas solicitudReserva) {
        entityManager.merge(solicitudReserva);
    }

    @Transactional
    public void eliminarSolicitudReserva(Long id) {
        SolicitudesReservas solicitudReserva = obtenerSolicitudReservaPorId(id);
        if (solicitudReserva != null) {
            entityManager.remove(solicitudReserva);
        }
    }
}
