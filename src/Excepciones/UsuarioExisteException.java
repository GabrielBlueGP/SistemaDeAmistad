package Excepciones;

public class UsuarioExisteException extends SistemaAmistadException{
    public UsuarioExisteException(String mensaje){
        super(mensaje);
    }
}
