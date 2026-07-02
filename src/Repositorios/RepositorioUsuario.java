package Repositorios;

import ManualUsuario.RelacionUsuario;
import ManualUsuario.Usuario;

import java.util.HashMap;

public class RepositorioUsuario {
    private HashMap<String, Usuario> usuarios;

    public RepositorioUsuario(){
        usuarios = new HashMap<>();
    }

    public void guardar(Usuario usuario){
        usuarios.put(usuario.getIdUsuario(), usuario);
    }

    public Usuario buscarPorId(String idUsuario){
        return usuarios.get(idUsuario);
    }

    public void eliminar(String idUsuario){
        usuarios.remove(idUsuario);
    }

    public void listar(){
        usuarios.values().forEach(System.out::println);
    }

    public boolean existeID(String usuarioID){
        return buscarPorId(usuarioID) != null;
    }

    public boolean existeCorreo(String correo){
        for(Usuario u : usuarios.values()){
            if(u.getCorreo().equals(correo)){
                return true;
            }
        }
        return false;
    }

    public Usuario buscarPorCorreo(String correo){
        for(Usuario u : usuarios.values()){
            if(u.getCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    public Usuario mostrarPerfil(String idUsuario){
        return buscarPorId(idUsuario);
    }

    public void nuevoNombre(Usuario user, String nombre){
        user.setNombre(nombre);
    }

    public void nuevoCorreo(Usuario user, String correo){
        user.setCorreo(correo);
    }

    public void nuevaContrasenia(Usuario user, String contrasenia){
        user.setContrasenia(contrasenia);
    }

    public void nuevaUbicacion(Usuario user, String ubicacion){
        user.setUbicacion(ubicacion);
    }

    public RelacionUsuario buscarRelacion(Usuario user, String idUserRel){
        for(RelacionUsuario relacion: user.getRelaciones()){
            if(relacion.getUsuarioRelacionado().getIdUsuario().equals(idUserRel)){
                return relacion;
            }
        }
        return null;
    }



}
