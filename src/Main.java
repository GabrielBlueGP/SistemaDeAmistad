import Controladores.ControlConversacion;
import Controladores.ControlUsuario;
import Conversaciones.Mensaje;
import Conversaciones.MensajesPrecargados;
import Conversaciones.TemaConversacion;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;
import Servicios.ServicioConversacion;
import Servicios.ServicioUsuario;

public class Main {
    public static void main(String[] args) {
        MensajesPrecargados msjPrecargados = new MensajesPrecargados();
        msjPrecargados.precargarMensajes();
        TemaConversacion tematicas = new TemaConversacion();
        tematicas.precargaTemas();

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        ServicioUsuario servicioUsuario = new ServicioUsuario(repositorioUsuario);
        ServicioConversacion servicioConversacion = new ServicioConversacion(msjPrecargados, tematicas, repositorioUsuario);
        ControlConversacion controlConversacion = new ControlConversacion(servicioConversacion);
        ControlUsuario controlUsuario = new ControlUsuario(servicioUsuario, controlConversacion);
        servicioUsuario.precargarUsuarios();

        controlUsuario.menuIngreso();
    }
}