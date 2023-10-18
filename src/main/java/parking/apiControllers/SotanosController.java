package parking.apiControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parking.domain.models.Sotanos;
import parking.domain.services.SotanosService;

@RestController
@RequestMapping(path = "/sotanos")
public class SotanosController {

    private final SotanosService sotanosService;

    public SotanosController(SotanosService sotanosService) {
        this.sotanosService = sotanosService;
    }

    @PostMapping
    public ResponseEntity<Void> crearSotano(@RequestBody Sotanos sotano) {
        sotanosService.crearSotano(sotano);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sotanos> obtenerSotanoPorId(@PathVariable Integer id) { // Cambio de Long a Integer
        Sotanos sotano = sotanosService.obtenerSotanoPorId(id);
        if (sotano != null) {
            return new ResponseEntity<>(sotano, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarSotano(@PathVariable Integer id, @RequestBody Sotanos sotano) { // Cambio de Long a Integer
        Sotanos existingSotano = sotanosService.obtenerSotanoPorId(id);
        if (existingSotano != null) {
            sotano.setId(id);
            sotanosService.actualizarSotano(sotano);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSotano(@PathVariable Integer id) { // Cambio de Long a Integer
        sotanosService.eliminarSotano(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

