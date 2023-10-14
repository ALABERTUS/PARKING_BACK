package parking.apiControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.SolicitudesReservas;
import parking.domain.services.SolicitudesReservasService;

@RestController
@RequestMapping("/solicitudes-reservas")
public class SolicitudesReservasController {

    private final SolicitudesReservasService solicitudesReservasService;

    public SolicitudesReservasController(SolicitudesReservasService solicitudesReservasService) {
        this.solicitudesReservasService = solicitudesReservasService;
    }

    @PostMapping
    public ResponseEntity<Void> crearSolicitudReserva(@RequestBody SolicitudesReservas solicitudReserva) {
        solicitudesReservasService.crearSolicitudReserva(solicitudReserva);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudesReservas> obtenerSolicitudReservaPorId(@PathVariable Long id) {
        SolicitudesReservas solicitudReserva = solicitudesReservasService.obtenerSolicitudReservaPorId(id);
        if (solicitudReserva != null) {
            return new ResponseEntity<>(solicitudReserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarSolicitudReserva(@PathVariable Long id, @RequestBody SolicitudesReservas solicitudReserva) {
        SolicitudesReservas existingSolicitudReserva = solicitudesReservasService.obtenerSolicitudReservaPorId(id);
        if (existingSolicitudReserva != null) {
            solicitudReserva.setId(id);
            solicitudesReservasService.actualizarSolicitudReserva(solicitudReserva);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitudReserva(@PathVariable Long id) {
        solicitudesReservasService.eliminarSolicitudReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
