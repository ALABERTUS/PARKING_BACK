package parking.domain.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "EstadoPlaza")
public class EstadoPlaza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean libre;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date fecha;
    private int sotano;
    private int plaza;

    public EstadoPlaza(Long id, boolean libre, Date fecha, int sotano, int plaza) {
        this.id = id;
        this.libre = libre;
        this.fecha = fecha;
        this.sotano = sotano;
        this.plaza = plaza;
    }

    public EstadoPlaza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getSotano() {
        return sotano;
    }

    public void setSotano(int sotano) {
        this.sotano = sotano;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

}
