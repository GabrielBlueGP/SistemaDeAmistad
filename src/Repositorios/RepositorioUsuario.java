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
        for(Usuario usuario : usuarios.values()){
            System.out.println(usuario);
        }
    }

    public boolean existeUsuario(String usuarioID){
        if(buscarPorId(usuarioID) != null){
            return true;
        } else {
            return false;
        }
    }

}
