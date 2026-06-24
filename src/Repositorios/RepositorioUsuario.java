package Repositorios;

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

}
