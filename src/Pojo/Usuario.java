package Pojo;

public class Usuario {
    private String nombreUsuario;
    private String nivelEstudios;
    private String edad;
    private String correo;
    private String telefono;

    public Usuario(String nombreUsuario, String nivelEstudios, String edad, String correo, String telefono) {
        this.nombreUsuario = nombreUsuario;
        this.nivelEstudios = nivelEstudios;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreUsuario + " Edad: " + edad +
                " telefono: " + telefono ;
    }
}
