import Controladores.ControlUsuario;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;
import Servicios.ServicioUsuario;

public class Main {
    public static void main(String[] args) {
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        ServicioUsuario servicioUsuario = new ServicioUsuario(repositorioUsuario);
        ControlUsuario controlUsuario = new ControlUsuario(servicioUsuario);
        servicioUsuario.precargarUsuarios();

        controlUsuario.menuIngreso();
    }
}