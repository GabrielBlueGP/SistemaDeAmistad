package Servicios;

import Excepciones.CorreoExisteException;
import Excepciones.IDExisteException;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;

public class ServicioUsuario {
    private RepositorioUsuario repoUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario){
        this.repoUsuario = repositorioUsuario;
    }

    public void registrarUsuario(Usuario usuario){
        if(repoUsuario.existeID(usuario.getIdUsuario())) {
            throw new IDExisteException("Este ID ya esta registrado");
        }

        if(repoUsuario.existeCorreo(usuario.getCorreo())){
            throw  new CorreoExisteException("Este correo pertenece a otro usuario");
        }
        repoUsuario.guardar(usuario);
    }
}
