package Mensajeros;

public class Mensaje {
    private String pregunta;
    private String respuesta;

    public Mensaje(String pregunta, String respuesta){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
