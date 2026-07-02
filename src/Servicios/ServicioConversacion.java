package Servicios;

import Conversaciones.MensajesPrecargados;
import Conversaciones.TemaConversacion;
import Excepciones.UsuarioNoEncontrado;
import ManualUsuario.RelacionUsuario;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;

public class ServicioConversacion {
    private MensajesPrecargados msjPrecargados;
    private TemaConversacion temas;
    private RepositorioUsuario repoUsuario;

    public ServicioConversacion(MensajesPrecargados mensajes, TemaConversacion tematicas, RepositorioUsuario repositorioUsuario){
        this.msjPrecargados = mensajes;
        this.temas = tematicas;
        this.repoUsuario = repositorioUsuario;
    }

    public Usuario buscarReceptor(String idUsuario){
        Usuario receptor = repoUsuario.buscarPorId(idUsuario);
        if(receptor == null){
            throw new UsuarioNoEncontrado("El usuario buscado no existe");
        }
        return receptor;
    }

    public boolean mensajeValido(int opcion){
        boolean eligiendo = true;
        if(opcion >= 1 && opcion <= msjPrecargados.cantidadMensajes()){
            msjPrecargados.obtenerMensaje(opcion -1);
            eligiendo = false;
        }
        return eligiendo;
    }

    public RelacionUsuario buscarRelacion(Usuario emisor, Usuario receptor){
        RelacionUsuario relacion = repoUsuario.buscarRelacion(emisor, receptor.getIdUsuario());
        if(relacion == null){
            RelacionUsuario relacionEmisor = new RelacionUsuario(receptor);
            RelacionUsuario relacionReceptor = new RelacionUsuario(emisor);
            emisor.agregarRelacion(relacionEmisor);
            receptor.agregarRelacion(relacionReceptor);
            relacion = relacionEmisor;
        }
        return relacion;
    }
}
