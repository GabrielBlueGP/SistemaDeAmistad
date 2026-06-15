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
}
