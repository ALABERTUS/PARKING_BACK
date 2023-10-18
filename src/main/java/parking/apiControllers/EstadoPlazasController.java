package parking.apiControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.EstadoPlazas;
import parking.domain.services.EstadoPlazasServices;

import java.util.List;

@RestController
@RequestMapping(path="/estado-plazas")
public class EstadoPlazasController {

    private final EstadoPlazasServices estadoPlazasServices;

    public EstadoPlazasController(EstadoPlazasServices estadoPlazasServices) {
        this.estadoPlazasServices = estadoPlazasServices;
    }

    @PostMapping
    public ResponseEntity<Void> crearEstadoPlaza(@RequestBody EstadoPlazas estadoPlazas) {
        estadoPlazasServices.crearEstadoPlaza(estadoPlazas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPlazas> obtenerEstadoPlazaPorId(@PathVariable int id) {
        EstadoPlazas estadoPlazas = estadoPlazasServices.obtenerEstadoPlazaPorId(id);
        if (estadoPlazas != null) {
            return new ResponseEntity<>(estadoPlazas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarEstadoPlaza(@PathVariable int id, @RequestBody EstadoPlazas estadoPlazas) {
        EstadoPlazas existingEstadoPlazas = estadoPlazasServices.obtenerEstadoPlazaPorId(id);
        if (existingEstadoPlazas != null) {
            estadoPlazas.setId(id);
            estadoPlazasServices.actualizarEstadoPlaza(estadoPlazas);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadoPlaza(@PathVariable int id) {
        estadoPlazasServices.eliminarEstadoPlaza(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EstadoPlazas>> obtenerTodosLosEstadoPlazas() {
        List<EstadoPlazas> estadoPlazasList = estadoPlazasServices.obtenerTodosLosEstadoPlazas();
        return new ResponseEntity<>(estadoPlazasList, HttpStatus.OK);
    }
}

