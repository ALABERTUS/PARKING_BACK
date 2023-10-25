package parking.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SolicitudesReservas")
public class SolicitudesReservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String fecha;

    @OneToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuarios;

    private String estado;

    public SolicitudesReservas(Integer id, String fecha, Usuarios usuario, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.usuarios = usuario;
        this.estado = estado;
    }

    public SolicitudesReservas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

