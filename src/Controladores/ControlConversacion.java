package Controladores;

import ConsolaEscritura.Consola;
import ConsolaEscritura.Textos;
import Excepciones.UsuarioNoEncontrado;
import ManualUsuario.Usuario;
import Servicios.ServicioConversacion;

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
        do {
            Textos.menuConversacion();
            System.out.println("");
            opcion = Consola.teclado.nextLine();
        } while (!opcion.equals("0"));

    }
}
