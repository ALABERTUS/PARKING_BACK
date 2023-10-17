package parking.domain.services;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import java.util.ArrayList;
import parking.domain.models.PlazasEstados;

import java.util.List;


public class PlazasEstadosServices {

    private List<PlazasEstados> plazasEstadosList = new ArrayList<>();

    public List<PlazasEstados> getAllPlazasEstados() {
        return plazasEstadosList;
    }

    public PlazasEstados getPlazasEstadosById(Integer id) {
        for (PlazasEstados plazasEstados : plazasEstadosList) {
            if (plazasEstados.getId().equals(id)) {
                return plazasEstados;
            }
        }
        return null;
    }

    public void createPlazasEstados(PlazasEstados plazasEstados) {
        plazasEstadosList.add(plazasEstados);
    }

    public void updatePlazasEstados(PlazasEstados plazasEstados) {
        for (int i = 0; i < plazasEstadosList.size(); i++) {
            if (plazasEstadosList.get(i).getId().equals(plazasEstados.getId())) {
                plazasEstadosList.set(i, plazasEstados);
                break;
            }
        }
    }
    public void deletePlazasEstados(Integer id) {
        plazasEstadosList.removeIf(plazasEstados -> plazasEstados.getId().equals(id));
    }
}
