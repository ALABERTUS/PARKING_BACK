package parking.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class SolicitudesReservas {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Usuarios usuario;

    @ManyToOne
    private Plazas plaza;
    private Sotanos sotano;

    private Date fecha;
    private String estadoSolicitud;

    public SolicitudesReservas() {
    }

    public SolicitudesReservas(Usuarios usuario, Plazas plaza, Sotanos sotano, Date fecha, String estadoSolicitud) {
        this.usuario = usuario;
        this.plaza = plaza;
        this.sotano = sotano;
        this.fecha = fecha;
        this.estadoSolicitud = estadoSolicitud;
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

    public Sotanos getSotano() {
        return sotano;
    }

    public void setSotano(Sotanos sotano) {
        this.sotano = sotano;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public String toString() {
        return "SolicitudesReservas{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", plaza=" + plaza +
                ", sotano=" + sotano +
                ", fecha=" + fecha +
                ", estadoSolicitud='" + estadoSolicitud + '\'' +
                '}';
    }
}
