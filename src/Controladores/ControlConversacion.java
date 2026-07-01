package Controladores;

import ConsolaEscritura.Consola;
import ConsolaEscritura.Textos;
import Conversaciones.Mensaje;
import Conversaciones.MensajesPrecargados;
import Conversaciones.TemaConversacion;
import Excepciones.UsuarioNoEncontrado;
import ManualUsuario.Usuario;
import Servicios.ServicioConversacion;

import java.util.InputMismatchException;

public class ControlConversacion {
    private ServicioConversacion servConversacion;

    public ControlConversacion(ServicioConversacion servicioConversacion){
        this.servConversacion = servicioConversacion;
    }

    public void buscarCharla(Usuario emisor){
        Usuario receptor = null;
        String busqueda = "";
        do{
            try {
                System.out.println("¿Con quien desea charlar?");
                System.out.println("(En caso de no querer una conversacion, precione 0)");
                System.out.print("Ingrese el @ del usuario buscado: ");
                busqueda = Consola.teclado.nextLine();
                if(busqueda.equals(emisor.getIdUsuario())){
                    System.out.println("No puede ingresar su propio @, ingrese otro");
                } else {
                    receptor = servConversacion.buscarReceptor(busqueda);
                }
            } catch (UsuarioNoEncontrado e) {
                System.out.println();
            }
        } while (!busqueda.equals("0") && receptor == null);
        menuConversacion(emisor, receptor);
    }

    public void menuConversacion(Usuario emisor, Usuario receptor){
        System.out.println("--------------------------------------------------------");
        System.out.println(emisor.getNombre()+" esta conversando con "+ receptor.getNombre()+"\n");
        String opcion;
        MensajesPrecargados mensajes = new MensajesPrecargados();
        TemaConversacion temas = new TemaConversacion();
        int interes = 20;
        int nivelCharla = 0;
        do {
            Textos.menuConversacion();
            System.out.println("Ingrese la opcion");
            opcion = Consola.teclado.nextLine();
            switch (opcion){
                case "1":
                    menuMensajes(mensajes);
                    break;
                case "2":
                    break;
                default:
                    break;
            }
        } while (!opcion.equals("0") && interes > 0);
    }

    private void menuMensajes(MensajesPrecargados mensajes){
        mensajes.mostrarMensajes();
        int opcion;
        boolean eligiendo = true;
        do{
            try{
                System.out.print("Ingrese el numero del mensaje: ");
                opcion = Consola.teclado.nextInt();
                Consola.teclado.nextLine();
                if(opcion >= 1 && opcion <= mensajes.cantidadMensajes()){
                    mensajes.obtenerMensaje(opcion -1);
                    eligiendo = false;
                } else {
                    System.out.println("El numero ingresado no pertenece a ningun mensaje");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo es valido ingresar numeros.");
                Consola.teclado.nextLine();
            }
        } while (eligiendo);
    }

}
