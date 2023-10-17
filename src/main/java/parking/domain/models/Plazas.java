package parking.domain.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Plazas {
    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return idPlaza;
    }

    private Integer idPlaza;
    private int numeroPlaza;

    @ManyToOne
    private Sotanos sotano;
    private String propietario;
    private boolean disponible;

    @OneToMany(mappedBy = "plaza")
    private List<PlazasEstados> plazasEstados;

    public Plazas(Integer idPlaza, int numeroPlaza, Sotanos sotano, String propietario, boolean disponible, List<PlazasEstados> plazasEstados) {
        this.idPlaza = idPlaza;
        this.numeroPlaza = numeroPlaza;
        this.sotano = sotano;
        this.propietario = propietario;
        this.disponible = disponible;
        this.plazasEstados = plazasEstados;
    }

    public Integer getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(Integer idPlaza) {
        this.idPlaza = idPlaza;
    }

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public Sotanos getSotano() {return sotano;}

    public void setSotano(Sotanos sotano) { this.sotano = sotano; }

    public String getPropietario() { return propietario; }

    public void setPropietario(String propietario) { this.propietario = propietario; }

    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public List<PlazasEstados> getPlazasEstados() { return plazasEstados; }

    public void setPlazasEstados(List<PlazasEstados> plazasEstados) { this.plazasEstados = plazasEstados; }

    @OneToMany(mappedBy = "plaza")
    private List<UsuariosPlazas> usuariosPlazas;

    public String toString() {
        return "Plazas{" +
                "idPlaza=" + idPlaza +
                ", numeroPlaza=" + numeroPlaza +
                ", sotano=" + sotano.getNumeroSotano() +
                ", propietario='" + propietario + '\'' +
                ", disponible=" + disponible +
                ", plazasEstados=" + plazasEstados +
                '}';
    }
}



