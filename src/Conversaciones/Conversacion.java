package Conversaciones;

import ManualUsuario.Usuario;

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

    public Usuario getEmisor() {
        return emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public int getInteres() {
        return interes;
    }

    public int getNivelCharla() {
        return nivelCharla;
    }


}
