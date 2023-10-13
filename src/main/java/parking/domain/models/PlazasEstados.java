package parking.domain.models;

public class PazasEstados {
    private Integer id;
    private Plazas plaza;
    private EstadoPlaza estado;

    public PazasEstados(Integer id, Plazas plaza, EstadoPlaza estado) {
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
