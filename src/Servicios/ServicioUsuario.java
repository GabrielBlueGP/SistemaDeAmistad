package Servicios;

import Excepciones.UsuarioExisteException;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;

public class ServicioUsuario {
    private RepositorioUsuario repoUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario){
        this.repoUsuario = repositorioUsuario;
    }

    public void registrarUsuario(Usuario usuario){
        if(repoUsuario.existeUsuario(usuario.getIdUsuario())) {
            throw new UsuarioExisteException("Este usuario ya existe");
        }
        repoUsuario.guardar(usuario);
    }
}
