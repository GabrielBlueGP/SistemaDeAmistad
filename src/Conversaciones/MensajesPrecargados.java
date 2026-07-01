package Conversaciones;

import java.util.ArrayList;

public class MensajesPrecargados {
    private ArrayList<Mensaje> mensajes;

    public MensajesPrecargados(){
        mensajes = new ArrayList<>();
    }

    public void precargarMensajes(){
        mensajes.add(new Mensaje("¡Hola! ¿Como estas?", "Bien, gracias", 2));
        mensajes.add(new Mensaje("Espero tengas un lindo dia", "Ahhh, gracias :D", 5));
        mensajes.add(new Mensaje("La verdad, no quiero verte", "Emmm ¿Okey?", -10));
    }

    public void mostrarMensajes(){
        System.out.println("--------Mensajes--------");
        int num = 1;
        for(Mensaje m : mensajes){
            System.out.println(num + "." + m.getEmite());
            num++;
        }
    }

    public int cantidadMensajes(){
        return mensajes.size();
    }

    public Mensaje obtenerMensaje(int posicion){
        return mensajes.get(posicion);
    }
}
