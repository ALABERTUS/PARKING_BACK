package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_plazas")
public class UsuariosPlazas {
    @Id
    @GeneratedValue
    private Integer id;

    private String usuario;
    private String plaza;
    private String fecha;

    public UsuariosPlazas() {
    }

    public UsuariosPlazas(String usuario, String plaza, String fecha) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

