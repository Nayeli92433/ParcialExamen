package Pojo;

public class Postulacione {
    private String nombreUsuario;
    private String edad;
    private String vacante;

    public Postulacione(String nombreUsuario, String edad, String vacante) {
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.vacante = vacante;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEdad() {
        return edad;
    }

    public String getVacante() {
        return vacante;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreUsuario + "Edad: " + edad  +
                " Vacante: " + vacante ;
    }
}
