package parking.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "sotanos")
public class Sotanos {
    @Id
    @GeneratedValue
    private Integer id;
    private int numeroSotano;
    private int numeroPlazas;

    public Sotanos() {
    }

    public Sotanos(int numeroSotano, int numeroPlazas) {
        this.numeroSotano = numeroSotano;
        this.numeroPlazas = numeroPlazas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroSotano() {
        return numeroSotano;
    }

    public void setNumeroSotano(int numeroSotano) {
        this.numeroSotano = numeroSotano;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    @Override
    public String toString() {
        return "Sotanos{" +
                "id=" + id +
                ", numeroSotano=" + numeroSotano +
                ", numeroPlazas=" + numeroPlazas +
                '}';
    }
}
