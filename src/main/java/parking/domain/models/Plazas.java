

package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Plazas")
public class Plazas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numeroPlazas;
    private int sotano;
    private boolean disponible;
    private String propietario;

    public Plazas(Integer id, int numeroPlazas, int sotano, boolean disponible, String propietario) {
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

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public int getSotano() {
        return sotano;
    }

    public void setSotano(int sotano) {
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
