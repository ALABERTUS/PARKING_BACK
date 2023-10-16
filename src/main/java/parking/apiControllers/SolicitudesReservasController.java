package parking.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.SolicitudesReservas;
import parking.infraRepositories.SolicitudesReservasRepository;

import java.util.List;

@RestController
@RequestMapping("/solicitudesReservas")
public class SolicitudesReservasController {

    private final SolicitudesReservasRepository solicitudesReservasRepository;

    @Autowired
    public SolicitudesReservasController(SolicitudesReservasRepository solicitudesReservasRepository) {
        this.solicitudesReservasRepository = solicitudesReservasRepository;
    }

    @GetMapping
    public List<SolicitudesReservas> listarSolicitudesReservas(){
        return solicitudesReservasRepository.findAll();
    }

    @GetMapping("/{id}")
    public SolicitudesReservas obtenerSolicitudReserva(@PathVariable Integer id){
        return solicitudesReservasRepository.findById(id).orElse(null);
    }

    @PostMapping
    public SolicitudesReservas crearSolicitudReservas(@RequestBody SolicitudesReservas solicitud){
        return solicitudesReservasRepository.save(solicitud);
    }

    @PostMapping("/{id}")
    public SolicitudesReservas actualizarSolicitudesReservas(@PathVariable Integer id, @RequestBody SolicitudesReservas solicitudActualizada){
        solicitudActualizada.setId(id);
        return solicitudesReservasRepository.save(solicitudActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarSolicitudesReservas(@PathVariable Integer id){
        solicitudesReservasRepository.deleteById(id);
    }
}
