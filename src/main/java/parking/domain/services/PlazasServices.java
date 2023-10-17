package parking.domain.services;

import org.springframework.stereotype.Service;
import parking.domain.models.Plazas;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlazasServices {
    private List<Plazas> plazasList = new ArrayList<>();
    private int idGenerator = 1; // Tipo de dato Integer

    public void crearPlaza(Plazas plaza) {
        plaza.setId(idGenerator++);
        plazasList.add(plaza);
    }

    public Plazas obtenerPlazaPorId(Integer idPlaza) { // Tipo de dato Integer
        for (Plazas plaza : plazasList) {
            if (plaza.getId().equals(idPlaza)) {
                return plaza;
            }
        }
        return null;
    }

    public void actualizarPlaza(Integer idPlaza, Plazas plazaActualizada) { // Tipo de dato Integer
        for (Plazas plaza : plazasList) {
            if (plaza.getId().equals(idPlaza)) {
                plaza.setNumeroPlazas(plazaActualizada.getNumeroPlazas());
                plaza.setSotano(plazaActualizada.getSotano());
                plaza.setPropietario(plazaActualizada.getPropietario());
                plaza.setDisponible(plazaActualizada.isDisponible());
            }
        }
    }

    public void eliminarPlaza(Integer idPlaza) { // Tipo de dato Integer
        plazasList.removeIf(plaza -> plaza.getId().equals(idPlaza));
    }

    public List<Plazas> obtenerTodasLasPlazas() {
        return plazasList;
    }
}
