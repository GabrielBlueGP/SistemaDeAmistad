package Servicios;

import Excepciones.UsuarioNoEncontrado;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;

public class ServicioConversacion {
    private RepositorioUsuario repoUsuario;

    public ServicioConversacion(RepositorioUsuario repositorioUsuario){
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
