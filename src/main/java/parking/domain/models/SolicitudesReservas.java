package parking.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Table(name = "SolicitudesReservas")
public class SolicitudesReservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Cambio de Long a Integer

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    private String estado;

    public SolicitudesReservas(Integer id, Date fecha, Usuarios usuario, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.usuario = usuario;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

