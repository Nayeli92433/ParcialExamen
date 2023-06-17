package Pojo;

public class Vacante {
    private String nombreVacante;
    private String numVacante;
    private String experiencia;
    private String fecha;
    private String sueldo;
    private String descripcion;

    public Vacante(String nombreVacante, String numVacante, String experiencia, String fecha, String sueldo, String descripcion) {
        this.nombreVacante = nombreVacante;
        this.numVacante = numVacante;
        this.experiencia = experiencia;
        this.fecha = fecha;
        this.sueldo = sueldo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vacante: " + nombreVacante +
                " sueldo: " + sueldo +
                " descripcion:" + descripcion ;
    }

    public String getNombreVacante() {
        return nombreVacante;
    }

    public String getNumVacante() {
        return numVacante;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSueldo() {
        return sueldo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
