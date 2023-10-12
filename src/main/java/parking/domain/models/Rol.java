package parking.domain.models;

import jakarta.persistence.*;

@Entity

@Table(name = "Rol")

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String rol;

    public Rol(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public Rol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
