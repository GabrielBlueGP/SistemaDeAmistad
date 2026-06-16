package Conversaciones;

import java.util.ArrayList;

public class TemaConversacion {
    private ArrayList<String> temas;

    public TemaConversacion(){
        temas = new ArrayList<>();
        temas.add("Cocina");
        temas.add("Electronica");
        temas.add("Videojuegos");
        temas.add("Series");
        temas.add("Peliculas");
        temas.add("Politica");
        temas.add("Cultura local");
        temas.add("Estudios");
    }

    public void agregarTema(String tematica){
        temas.add(tematica);
    }
}
