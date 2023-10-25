package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Plazas")
public class Plazas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroPlazas; // Cambiado a String
    private String sotano; // Cambiado a String
    private boolean disponible;
    private String propietario;

    public Plazas(Integer id, String numeroPlazas, String sotano, boolean disponible, String propietario) {
        this.id = id;
        this.numeroPlazas = numeroPlazas;
        this.sotano = sotano;
        this.disponible = disponible;
        this.propietario = propietario;
    }

    public Plazas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(String numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getSotano() {
        return sotano;
    }

    public void setSotano(String sotano) {
        this.sotano = sotano;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}

