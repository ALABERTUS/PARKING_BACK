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
        // Validación de entrada (puedes agregar validaciones aquí)
        entityManager.persist(solicitudReserva);
    }

    @Transactional
    public SolicitudesReservas obtenerSolicitudReservaPorId(Integer id) { // Cambio de Long a Integer
        // Puedes manejar excepciones aquí si la solicitud no existe
        return entityManager.find(SolicitudesReservas.class, id);
    }

    @Transactional
    public void actualizarSolicitudReserva(SolicitudesReservas solicitudReserva) {
        // Puedes manejar excepciones aquí si la solicitud no existe
        entityManager.merge(solicitudReserva);
    }

    @Transactional
    public void eliminarSolicitudReserva(Integer id) { // Cambio de Long a Integer
        SolicitudesReservas solicitudReserva = obtenerSolicitudReservaPorId(id);
        if (solicitudReserva != null) {
            entityManager.remove(solicitudReserva);
        }
        // Puedes manejar excepciones aquí si la solicitud no existe
    }
}
