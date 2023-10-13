package parking.domain.models;
import java.util.Date;

public class EstadoPlazas {
    private Integer id;
    private boolean disponible;
    private boolean ocupada;
    private Date fecha;
    private int numeroSotano;
    private int numeroPlaza;

    public EstadoPlazas() {
    }

    public EstadoPlazas(boolean disponible, boolean ocupada, Date fecha, int numeroSotano, int numeroPlaza) {
        this.disponible = disponible;
        this.ocupada = ocupada;
        this.fecha = fecha;
        this.numeroSotano = numeroSotano;
        this.numeroPlaza = numeroPlaza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroSotano() {
        return numeroSotano;
    }

    public void setNumeroSotano(int numeroSotano) {
        this.numeroSotano = numeroSotano;
    }

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

        public static void main(String[] args) {
            EstadoPlazas plaza1 = new EstadoPlazas(true, false, new Date(), 1, 101);
            EstadoPlazas plaza2 = new EstadoPlazas(false, true, new Date(), 1, 102);
        }
}