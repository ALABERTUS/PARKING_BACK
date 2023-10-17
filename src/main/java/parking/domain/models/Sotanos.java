package parking.domain.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "sotanos")
public class Sotanos {
    @Id
    @GeneratedValue
    private Integer idSotano;

    @OneToMany(mappedBy = "sotano")
    private List<Plazas> plazas;

    public Integer getIdSotano() {
        return idSotano;
    }

    public void setIdSotano(Integer idSotano) {
        this.idSotano = idSotano;
    }

    public List<Plazas> getPlazas() {
        return plazas;
    }

    public void setPlazas(List<Plazas> plazas) {
        this.plazas = plazas;
    }
}