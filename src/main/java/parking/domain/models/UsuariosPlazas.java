package parking.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class UsuariosPlazas {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Usuarios usuario;

    @ManyToOne
    private Plazas plaza;

    private Date fecha;

    public UsuariosPlazas() {
    }

    public UsuariosPlazas(Usuarios usuario, Plazas plaza, Date fecha) {
        this.usuario = usuario;
        this.plaza = plaza;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Plazas getPlaza() {
        return plaza;
    }

    public void setPlaza(Plazas plaza) {
        this.plaza = plaza;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

