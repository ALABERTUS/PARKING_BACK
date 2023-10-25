package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "plazas_estados")
public class PlazasEstados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String plaza;
    private String estado;

    public PlazasEstados() {
    }

    public PlazasEstados(String plaza, String estado) {
        this.plaza = plaza;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
