package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Sotanos")
public class Sotanos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Cambio de Long a Integer
    private int numeroSotano;
    private int numeroPlaza;

    public Sotanos(Integer id, int numeroSotano, int numeroPlaza) { // Cambio de Long a Integer
        this.id = id;
        this.numeroSotano = numeroSotano;
        this.numeroPlaza = numeroPlaza;
    }

    public Sotanos() {
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

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
}
