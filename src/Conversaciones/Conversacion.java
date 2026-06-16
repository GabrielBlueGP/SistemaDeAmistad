package Conversaciones;

public class Conversacion {
    private Usuario emisor;
    private Usuario receptor;
    private int interes;
    private int nivelCharla;

    public Conversacion(Usuario emisor, Usuario receptor){
        this.emisor = emisor;
        this.receptor = receptor;
        this.interes = 20;
        this.nivelCharla = 0;
    }


}
