package parking.domain.models;

public class Plazas {
    private int idPlaza;
    private int numeroPlaza;
    private int numeroSotano;
    private String propietario;
    private boolean disponible;

    public Plazas(int idPlaza, int numeroPlaza, int numeroSotano, String propietario, boolean disponible) {
        this.idPlaza = idPlaza;
        this.numeroPlaza = numeroPlaza;
        this.numeroSotano = numeroSotano;
        this.propietario = propietario;
        this.disponible = disponible;
    }

    public int getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(int idPlaza) {
        this.idPlaza = idPlaza;
    }

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    public int getNumeroSotano() {
        return numeroSotano;
    }

    public void setNumeroSotano(int numeroSotano) {
        this.numeroSotano = numeroSotano;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toString() {
        return "Plaza{" +
                "idPlaza=" + idPlaza +
                ", numeroPlaza=" + numeroPlaza +
                ", numeroSotano=" + numeroSotano +
                ", propietario='" + propietario + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}