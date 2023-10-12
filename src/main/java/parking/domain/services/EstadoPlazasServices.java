

package parking.domain.services;

import parking.domain.models.EstadoPlazas;

import java.util.ArrayList;
import java.util.List;

public class EstadoPlazasServices {
    private List<EstadoPlazas> estadoPlazasList = new ArrayList<>();
    private long idGenerator = 1;

    public void crearEstadoPlaza(EstadoPlazas estadoPlazas) {
        estadoPlazas.setId(idGenerator++);
        estadoPlazasList.add(estadoPlazas);
    }

    public EstadoPlazas obtenerEstadoPlazaPorId(long id) {
        for (EstadoPlazas estadoPlazas : estadoPlazasList) {
            if (estadoPlazas.getId() == id) {
                return estadoPlazas;
            }
        }
        return null;
    }

    public void actualizarEstadoPlaza(EstadoPlazas estadoPlazaActualizado) {
        for (EstadoPlazas estadoPlazas : estadoPlazasList) {
            if (estadoPlazas.getId() == estadoPlazaActualizado.getId()) {
                estadoPlazas.setLibre(estadoPlazaActualizado.isLibre());
                estadoPlazas.setFecha(estadoPlazaActualizado.getFecha());
                estadoPlazas.setSotano(estadoPlazaActualizado.getSotano());
                estadoPlazas.setPlaza(estadoPlazaActualizado.getPlaza());
            }
        }
    }

    public void eliminarEstadoPlaza(long id) {
        estadoPlazasList.removeIf(estadoPlazas -> estadoPlazas.getId() == id);
    }

    public List<EstadoPlazas> obtenerTodosLosEstadoPlazas() {
        return estadoPlazasList;
    }
}
