package parking.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Sotanos")
public class Sotanos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroSotano;
    private String numeroPlaza;

    public Sotanos(Integer id, String numeroSotano, String numeroPlaza) {
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

    public String getNumeroSotano() {
        return numeroSotano;
    }

    public void setNumeroSotano(String numeroSotano) {
        this.numeroSotano = numeroSotano;
    }

    public String getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(String numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
}
