package parking.domain.models;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Plazas {
    @Id
    @GeneratedValue
    private int idPlaza;
    private int numeroPlaza;

    @ManyToOne
    private Sotanos sotano;
    private String propietario;
    private boolean disponible;

    public Plazas(int idPlaza, int numeroPlaza, Sotanos sotano, String propietario, boolean disponible) {
        this.idPlaza = idPlaza;
        this.numeroPlaza = numeroPlaza;
        this.sotano = sotano;
        this.propietario = propietario;
        this.disponible = disponible;
    }

    public int getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(int idPlaza) {
        this.idPlaza = idPlaza;
    }

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public Sotanos getSotano() { return sotano; }

    public void setSotano(Sotanos sotano) { this.sotano = sotano; }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toString() {
        return "Plaza{" +
                "idPlaza=" + idPlaza +
                ", numeroPlaza=" + numeroPlaza +
                ", sotano=" + sotano.getNumeroSotano() +
                ", propietario='" + propietario + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}

