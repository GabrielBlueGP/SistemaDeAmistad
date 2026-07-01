import Controladores.ControlUsuario;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;
import Servicios.ServicioConversacion;
import Servicios.ServicioUsuario;

public class Main {
    public static void main(String[] args) {
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        ServicioUsuario servicioUsuario = new ServicioUsuario(repositorioUsuario);
        ServicioConversacion servicioConversacion = new ServicioConversacion(repositorioUsuario);
        ControlUsuario controlUsuario = new ControlUsuario(servicioUsuario, servicioConversacion);
        servicioUsuario.precargarUsuarios();

        controlUsuario.menuIngreso();
    }
}