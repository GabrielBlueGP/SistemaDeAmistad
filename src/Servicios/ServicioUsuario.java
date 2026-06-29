package Servicios;

import Excepciones.CorreoExisteException;
import Excepciones.IDExisteException;
import Excepciones.UsuarioNoEncontrado;
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

    public void precargarUsuarios(){
        registrarUsuario(new Usuario("Gabriel", "@Gabriel", "gabrielpabon@gmail.com", "1234", "Buenos Aires"));
        registrarUsuario(new Usuario("Chris", "@Christian", "chirstian@gmail.com", "1234", "Buenos Aires"));
        registrarUsuario(new Usuario("Fabi", "@Fabian", "Fabian@gmail.com", "1234", "La Pampa"));
    }

    public Usuario hacerLogin(String correo){
        Usuario user = repoUsuario.buscarPorCorreo(correo);
        if(user == null){
            throw new UsuarioNoEncontrado("El usuario no fue encontrado");
        }
        return user;
    }

    public Usuario mostrarPerfil(String idUsuario){
        return repoUsuario.mostrarPerfil(idUsuario);
    }


    public void modificarDatosUsuario(Usuario user, String nuevoDato, String opcion) {
        switch (opcion){
            case "1":
                repoUsuario.nuevoNombre(user, nuevoDato);
                break;
            case "2":
                if(repoUsuario.existeCorreo(nuevoDato)){
                    throw  new CorreoExisteException("Este correo pertenece a otro usuario");
                }
                repoUsuario.nuevoCorreo(user, nuevoDato);
                break;
            case "3":
                repoUsuario.nuevaContrasenia(user, nuevoDato);
                break;
            case "4":
                repoUsuario.nuevaUbicacion(user, nuevoDato);
                break;
        }
    }

}
