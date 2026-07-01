package Conversaciones;

public class Mensaje {
    private String emite;
    private String responde;
    private int puntos;

    public Mensaje(String emite, String responde, int puntos){
        this.emite = emite;
        this.responde = responde;
        this.puntos = puntos;
    }

    public String getEmite() {
        return emite;
    }

    public String getResponde() {
        return responde;
    }

    public int getPuntos() {
        return puntos;
    }
}
