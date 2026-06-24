package Excepciones;

public class UsuarioNoEncontrado extends SistemaAmistadException{
    public UsuarioNoEncontrado(String mensaje){
        super(mensaje);
    }
}
