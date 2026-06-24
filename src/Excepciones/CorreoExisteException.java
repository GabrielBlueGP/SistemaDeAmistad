package Excepciones;

public class CorreoExisteException extends SistemaAmistadException {
    public CorreoExisteException(String mensaje){
        super(mensaje);
    }
}
