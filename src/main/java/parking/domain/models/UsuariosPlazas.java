package parking.domain.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuarios_plazas")
public class UsuariosPlazas {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Usuarios usuario;

    @ManyToOne
    private Plazas plaza;

    private String fecha;

    public UsuariosPlazas() {
    }

    public UsuariosPlazas(Usuarios usuario, Plazas plaza, String fecha) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

