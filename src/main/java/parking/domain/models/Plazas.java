package parking.domain.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Plazas {
    @Id
    @GeneratedValue
    public int getId() {
        return idPlaza;
    }
    private int idPlaza;
    private int numeroPlaza;

    @ManyToOne
    private Sotanos sotano;
    private String propietario;
    private boolean disponible;

    @OneToMany(mappedBy = "plaza")
    private List<PlazasEstados> plazasEstados;

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

    @OneToMany(mappedBy = "plaza")
    private List<UsuariosPlazas> usuariosPlazas;

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


