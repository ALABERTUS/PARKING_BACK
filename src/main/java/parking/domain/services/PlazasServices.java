package parking.domain.services;
import org.springframework.stereotype.Service;
import parking.domain.models.Plazas;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlazasServices {
    private List<Plazas> plazasList = new ArrayList<>();
    private long idGenerator = 1;

    public void crearPlaza(Plazas plaza) {
        plaza.setId(idGenerator++);
        plazasList.add(plaza);
    }

    public Plazas obtenerPlazaPorId(Long idPlaza) {
        for (Plazas plaza : plazasList) {
            if (plaza.getId().equals(idPlaza)) {
                return plaza;
            }
        }
        return null;
    }

    public void actualizarPlaza(Plazas plazaActualizada) {
        for (Plazas plaza : plazasList) {
            if (plaza.getId().equals(plazaActualizada.getId())) {
                plaza.setNumeroPlazas(plazaActualizada.getNumeroPlazas());
                plaza.setSotano(plazaActualizada.getSotano());
                plaza.setPropietario(plazaActualizada.getPropietario());
                plaza.setDisponible(plazaActualizada.isDisponible());
            }
        }
    }

    public void eliminarPlaza(Long idPlaza) {
        plazasList.removeIf(plaza -> plaza.getId().equals(idPlaza));
    }

    public List<Plazas> obtenerTodasLasPlazas() {
        return plazasList;
    }
}
