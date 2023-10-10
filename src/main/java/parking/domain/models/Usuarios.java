package parking.domain.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Usuarios{
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private String dni;
    private Integer telefono;
    private String rol;

    public Usuarios() {
    }
    public  Usuarios(Long id, String nombre, String email, String dni, Integer telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.rol = rol;
    }
    public Usuarios(String nombre, String email, String dni, Integer telefono, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

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