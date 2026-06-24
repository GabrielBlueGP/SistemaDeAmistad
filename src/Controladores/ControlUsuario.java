package Controladores;

import ConsolaEscritura.Consola;
import Excepciones.CorreoExisteException;
import Excepciones.IDExisteException;
import ManualUsuario.Usuario;
import Servicios.ServicioUsuario;

public class ControlUsuario {
    private ServicioUsuario servUsuario;

    public ControlUsuario(ServicioUsuario servicioUsuario){
        this.servUsuario = servicioUsuario;
    }

    public void menuRegistro(){
        try{
            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = Consola.teclado.nextLine();
            String idUsuario = pedirUsuarioID();
            String correo = pedirCorreo();
            String contrasenia = pedirContrasenia();
            String ubicacion = pedirUbicacion();
            Usuario usuario = new Usuario(nombre, idUsuario, correo, contrasenia, ubicacion);
            servUsuario.registrarUsuario(usuario);
            System.out.println("Usuario registrado correctamente");
        } catch (IDExisteException e){
            System.out.println(e.getMessage());
        } catch (CorreoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    private String pedirUsuarioID(){
        String idUsuario;
        do{
            System.out.print("Ingrese su id de usuario: ");
            idUsuario = Consola.teclado.nextLine();
            if(!idUsuario.matches("@[a-zA-Z_]+")){
                System.out.println("Formato invalido, reingrese ID");
            }
        }
        while (!idUsuario.matches("@[a-zA-Z_]+"));
        return idUsuario;
    }

    private String pedirCorreo(){
        String correo;
        do{
            System.out.print("Ingrese su gmail: ");
            correo = Consola.teclado.nextLine();
            if(!correo.matches(".+@.+\\..+")){
                System.out.println("Formato invalido, reingrese el gmail por favor");
            }
        }
        while (!correo.matches(".+@.+\\..+"));
        return correo;
    }

    private String pedirContrasenia(){
        String contrasenia;
        do {
            System.out.print("Ingrese su contraseña: ");
            contrasenia = Consola.teclado.nextLine();
            if(!contrasenia.matches("^\\S+$")){
                System.out.println("re ingrese la contraseña sin espacios");
            }
        } while(!contrasenia.matches("^\\S+$"));
        return contrasenia;

    }

    private String pedirUbicacion(){
        String ubicacion;
        do {
            System.out.print("Ingrese su ubicación: ");
            ubicacion = Consola.teclado.nextLine();
            if(!ubicacion.matches("[a-zA-Z0-9]+")){
                System.out.println("Ubicacion invalida, re ingresela por favor");
            }

        } while(!ubicacion.matches("[a-zA-Z0-9 ]+"));
        return ubicacion;

    }
}
