package Servicios;

import Conversaciones.MensajesPrecargados;
import Conversaciones.TemaConversacion;
import Excepciones.UsuarioNoEncontrado;
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
}
