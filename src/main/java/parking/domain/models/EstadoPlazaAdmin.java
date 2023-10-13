package parking.domain.models;

import java.util.List;
import java.util.ArrayList;

public class EstadoPlazaAdmin {
    public static void mostrarEstadoPlazas(List<EstadoPlaza> estadoPlazasList) {
        System.out.println("Estado de plazas:");
        for (EstadoPlaza estadoPlaza : estadoPlazasList) {
            System.out.println("ID: " + estadoPlaza.getId());
            System.out.println("Disponible: " + estadoPlaza.isDisponible());
            System.out.println("Ocupada: " + estadoPlaza.isOcupada());
            System.out.println("Fecha: " + estadoPlaza.getFecha());
            System.out.println("Numero sotano: " + estadoPlaza.getNumeroSotano());
            System.out.println("Numero plaza: " + estadoPlaza.getNumeroPlaza());
            System.out.println("-------------------");
        }
    }

        public static void main(String[] args) {
            List<EstadoPlaza> estadoPlazasList = new ArrayList<>();
            EstadoPlazaAdmin.mostrarEstadoPlazas(estadoPlazasList);
        }
}
