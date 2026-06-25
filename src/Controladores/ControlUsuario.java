package Controladores;

import ConsolaEscritura.Consola;
import ConsolaEscritura.Textos;
import Excepciones.CorreoExisteException;
import Excepciones.IDExisteException;
import Excepciones.UsuarioNoEncontrado;
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
            servUsuario.loginAutomatico(correo, contrasenia);
            System.out.println("Usuario registrado correctamente");
        } catch (IDExisteException e){
            System.out.println(e.getMessage());
        } catch (CorreoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    public void menuSesion(){
        Usuario user = null;
        String correo;
        while (user == null){
            correo = pedirCorreo();
            if(correo.equals("salir")){
                return;
            }
            try {
                user = servUsuario.hacerLogin(correo);
            } catch (UsuarioNoEncontrado e) {
                System.out.println(e.getMessage()+"\nintente con otro o haga \"salir\"");
            }
        }
        int intentos = 3;
        while (intentos > 0){
            System.out.println("Intentos para su contraseña: "+intentos);
            String contrasenia = pedirContrasenia();
            if(contrasenia.equals(user.getContrasenia())){
                break;
            }
            intentos--;
            System.out.println("Contraseña incorrecta");
        }
        if (intentos == 0){
            System.out.println("Fin de intentos. Acceso denegado");
        }
    }

    public void menuDeUsuario(Usuario user){
        String opcion;
        do {
            Textos.menuUsuario();
            System.out.print("Ingrese la opcion: ");
            opcion = Consola.teclado.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("--------------------------------------------------------");
                    System.out.println("                  perfil de usuario\n");
                    System.out.println(servUsuario.mostrarPerfil(user.getIdUsuario()));
                    System.out.println("--------------------------------------------------------");
                    break;
                case "2":
                    System.out.println("--------------------------------------------------------");
                    System.out.println("                  Modificar perfil\n");
                    System.out.println("--------------------------------------------------------");
                    break;
                case "0":
                    break;
                default:
                    break;
            }
        }
        while (!opcion.equals("0"));
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

    private void modificarUsuario(){
        String opcion;
        do{
            System.out.print("Ingrese la opcion del modificable: ");
        } while(opcion.equals("0"));
    }


    private void  pedirNuevoCorreo(String correo){
        servUsuario.nuevoCorreo(correo);
    }
}
