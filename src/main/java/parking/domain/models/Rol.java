package parking.domain.models;

public class Rol {
    private Integer id;
    private String nombreRol;

    public Rol() {
    }

    public Rol(int id, String nombreRol) {
        this.id = id; this.nombreRol = nombreRol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "RolUsuario{" +
                "id=" + id +
                ", rol='" + nombreRol + '\'' +
                '}';
    }
}
