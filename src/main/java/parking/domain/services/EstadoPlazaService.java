package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.EstadoPlaza;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EstadoPlazaService {

    private final List<EstadoPlaza> estadoPlazaList = new ArrayList<>();
    private Integer idGenerator = 1;

    public EstadoPlaza crearEstadoPlaza(boolean disponible, boolean ocupada, Date fecha, int numeroSotano, int numeroPlaza) {
        EstadoPlaza estadoPlaza = new EstadoPlaza(disponible, ocupada, fecha, numeroSotano, numeroPlaza);
        estadoPlaza.setId(idGenerator++);
        estadoPlazaList.add(estadoPlaza);
        return estadoPlaza;
    }

    public EstadoPlaza obtenerEstadoPlazaPorId(Integer id) {
        for (EstadoPlaza estadoPlaza : estadoPlazaList) {
            if (estadoPlaza.getId().equals(id)) {
                return estadoPlaza;
            }
        }
        return null;
    }

    public void actualizarEstadoPlaza(EstadoPlaza actualizarEstadoPlaza) {
        for (EstadoPlaza estadoPlaza : estadoPlazaList) {
            if (estadoPlaza.getId().equals(actualizarEstadoPlaza.getId())) {
                estadoPlaza.setDisponible(actualizarEstadoPlaza.isDisponible());
                estadoPlaza.setOcupada(actualizarEstadoPlaza.isOcupada());
                estadoPlaza.setFecha(actualizarEstadoPlaza.getFecha());
                estadoPlaza.setNumeroSotano(actualizarEstadoPlaza.getNumeroSotano());
                estadoPlaza.setNumeroPlaza(actualizarEstadoPlaza.getNumeroPlaza());
            }
        }
    }

    public void eliminarEstadoPlaza(Integer id) {
        estadoPlazaList.removeIf(estadoPlaza -> estadoPlaza.getId().equals(id));
    }

    public List<EstadoPlaza> obtenerTodosLosEstadosPlaza(){
        return estadoPlazaList;
    }
}
