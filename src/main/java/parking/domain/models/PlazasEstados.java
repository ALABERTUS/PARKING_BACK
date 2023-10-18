package parking.domain.models;

import jakarta.persistence.*;
import parking.domain.models.EstadoPlazas;

@Entity
@Table(name = "plazas_estados")
public class PlazasEstados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Plazas plaza;

    @ManyToOne
    private EstadoPlazas estado;

    public PlazasEstados() {
    }

    public PlazasEstados(Plazas plaza, EstadoPlazas estado) {
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

    public EstadoPlazas getEstado() {
        return estado;
    }

    public void setEstado(EstadoPlazas estado) {
        this.estado = estado;
    }
}

