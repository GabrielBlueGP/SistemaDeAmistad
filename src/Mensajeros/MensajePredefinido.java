package Mensajeros;

import java.util.ArrayList;

public class MensajePredefinido {
    private ArrayList<Mensaje> mensajes;

    public MensajePredefinido(){
        mensajes = new ArrayList<>();
        mensajes.add(new Mensaje("Buenos dias ¿que tal?","Buenos dias, todo bien"));
        mensajes.add(new Mensaje("¡Hola!","¡Hola! mucho gusto"));
        mensajes.add(new Mensaje("¿Que estas haciendo?","Descansando despues de un largo dia"));
    }

    public void mensajeUsuario(String opcion){
        Mensaje msj;
        switch (opcion){
            case "1":
                msj = mensajes.get(0);
                System.out.println(msj);
                break;
            case "2":
                msj = mensajes.get(1);
                System.out.println(msj);
                break;
            case "3":
                msj = mensajes.get(2);
                System.out.println(msj);
                break;
        }
    }
}
