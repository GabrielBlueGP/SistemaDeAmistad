package ManualUsuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String idUsuario;
    private String correo;
    private String contrasenia;
    private String ubicacion;
    private LocalDate fechaCreacion;
    private ArrayList<String> gustos;
    private ArrayList<String> disgustos;
    private ArrayList<RelacionUsuario> relaciones;

    public Usuario(String nombre, String idUsuario, String correo, String contrasenia, String ubicacion){
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.ubicacion = ubicacion;
        gustos = new ArrayList<>();
        disgustos = new ArrayList<>();
        relaciones = new ArrayList<>();
        fechaCreacion = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public ArrayList<RelacionUsuario> getRelaciones() {
        return relaciones;
    }

    public ArrayList<String> getGustos() {
        return gustos;
    }

    public ArrayList<String> getDisgustos() {
        return disgustos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return nombre+"\n@"+idUsuario+"\nUbicacion; "+ubicacion+"\nSe unio: "+fechaCreacion;
    }
}
