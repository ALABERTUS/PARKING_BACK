package parking.domain.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue

    private Integer id;

    private String nombre;
    private String email;
    private String dni;
    private Integer telefono;
    private Rol rol;

    public Usuarios() {
    }
    public  Usuarios(Integer id, String nombre, String email, String dni, Integer telefono, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.rol = rol;
    }


    public Usuarios(String nombre, String email, String dni, Integer telefono, Rol rol) {
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @OneToMany(mappedBy = "usuario")
    private List<UsuariosPlazas> usuariosPlazas;

    public String toString(){
        return "Usuario{" +
                "id=" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono=" + telefono +
                ", rol='" + rol + '\'' +
                '}';
    }
}