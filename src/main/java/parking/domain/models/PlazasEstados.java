package parking.domain.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PlazasEstados {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Plazas plaza;

    @ManyToOne
    private EstadoPlaza estado;

    public PlazasEstados(Integer id, Plazas plaza, EstadoPlaza estado) {
        this.id = id;
        this.plaza = plaza;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plazas getPlaza() {
        return plaza;
    }

    public void setPlaza(Plazas plaza) {
        this.plaza = plaza;
    }

    public EstadoPlaza getEstado() {
        return estado;
    }

    public void setEstado(EstadoPlaza estado) {
        this.estado = estado;
    }
}
