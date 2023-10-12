package parking.domain.services;

import parking.domain.models.Plazas;

import java.util.ArrayList;
import java.util.List;

public class PlazasServices {
    private List<Plazas> plazasList = new ArrayList<>();
    private int idGenerator = 1;

    public void crearPlaza(Plazas plaza) {
        plaza.setId((long) idGenerator++);
        plazasList.add(plaza);
    }

    public Plazas obtenerPlazaPorId(int idPlaza) {
        for (Plazas plaza : plazasList) {
            if (plaza.getId() == idPlaza) {
                return plaza;
            }
        }
        return null;
    }

    public void actualizarPlaza(Plazas plazaActualizada) {
        for (Plazas plaza : plazasList) {
            if (plaza.getId() == plazaActualizada.getId()) {
                plaza.setNumeroPlazas(plazaActualizada.getNumeroPlazas());
                plaza.setSotano(plazaActualizada.getSotano());
                plaza.setPropietario(plazaActualizada.getPropietario());
                plaza.setDisponible(plazaActualizada.isDisponible());
            }
        }
    }

    public void eliminarPlaza(int idPlaza) {
        plazasList.removeIf(plaza -> plaza.getId() == idPlaza);
    }

    public List<Plazas> obtenerTodasLasPlazas() {
        return plazasList;
    }
}
