package parking.domain.services;

import parking.domain.models.Plazas;
import java.util.ArrayList;
import java.util.List;

public class PlazasServices {
    private List<Plazas> plazasList;

    public PlazasServices() {
        plazasList = new ArrayList<>();
    }
    public void crearPlaza(int numeroPlaza, int numeroSotano, String propietario, boolean disponible) {
        int newId = plazasList.size() + 1;
        Plazas plaza = new Plazas(newId, numeroPlaza, numeroSotano, propietario, disponible);
        plazasList.add(plaza);
    }

    public Plazas obtenerPlaza(int idPlaza) {
        for (Plazas plaza : plazasList) {
            if (plaza.getIdPlaza() == idPlaza) {
                return plaza;
            }
        }
        return null;
    }

    public void actualizarPlaza(Plazas actualizarplaza) {
        for (Plazas plaza : plazasList) {
            if (plaza.getIdPlaza() == actualizarplaza.getIdPlaza()) {
               plaza.setNumeroPlaza(actualizarplaza.getNumeroPlaza());
               plaza.setNumeroSotano(actualizarplaza.getNumeroSotano());
               plaza.setPropietario(actualizarplaza.getPropietario());
               plaza.setDisponible(actualizarplaza.isDisponible());
               break;
            }
        }
    }

    public void eliminarPlaza(int idPlaza) {
        Plazas plazaToEliminar = null;
        for (Plazas plaza : plazasList) {
            if (plaza.getIdPlaza() == idPlaza) {
                plazaToEliminar = plaza;
                break;
            }
        }
       if (plazaToEliminar != null) {
           plazasList.remove(plazaToEliminar);
       }
    }

    public List<Plazas> listarPlazas() {
        return plazasList;
    }
}

