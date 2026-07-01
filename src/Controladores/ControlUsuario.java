package Controladores;

import ConsolaEscritura.Consola;
import ConsolaEscritura.Textos;
import Excepciones.CorreoExisteException;
import Excepciones.IDExisteException;
import Excepciones.UsuarioNoEncontrado;
import ManualUsuario.Usuario;
import Servicios.ServicioConversacion;
import Servicios.ServicioUsuario;

public class ControlUsuario {
    private ServicioUsuario servUsuario;
    private ControlConversacion contConversacion;

    public ControlUsuario(ServicioUsuario servicioUsuario, ControlConversacion controlConversacion){
        this.servUsuario = servicioUsuario;
        this.contConversacion = controlConversacion;
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
            menuDeUsuario(usuario);
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
        menuDeUsuario(user);
    }

    public void menuIngreso(){
        String opcion;
        do {
            Textos.menuIngreso();
            System.out.print("Ingrese su opcion: ");
            opcion = Consola.teclado.nextLine();
            switch (opcion){
                case "1":
                    System.out.println("--------------------------------------------------------");
                    System.out.println("                  Iniciando sesion");
                    System.out.println("--------------------------------------------------------");
                    menuSesion();
                    break;
                case "2":
                    System.out.println("--------------------------------------------------------");
                    System.out.println("             Registrando nuevo usuario");
                    System.out.println("--------------------------------------------------------");
                    menuRegistro();
                    break;
                default:

                    break;
            }
        } while (!opcion.equals("0"));
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
                    System.out.println("                   Perfil publico");
                    System.out.println(servUsuario.mostrarPerfil(user.getIdUsuario()));
                    break;
                case "2":
                    modificarUsuario(user);
                    break;
                case "3":

                    break;

                case "5":
                    System.out.println("--------------------------------------------------------");
                    System.out.println("                    Buscando platica");
                    contConversacion.buscarCharla(user);
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
            if(!ubicacion.matches("[a-zA-Z0-9 ]+")){
                System.out.println("Ubicacion invalida, re ingresela por favor");
            }

        } while(!ubicacion.matches("[a-zA-Z0-9 ]+"));
        return ubicacion;

    }

    private void modificarUsuario(Usuario user){
        try{
            String opcion;
            do{
                Textos.modificarPerfilUsuario();
                System.out.print("Ingrese la opcion del modificable: ");
                opcion = Consola.teclado.nextLine();
                switch (opcion){
                    case "1":
                        System.out.println("--------------------------------------------------------");
                        System.out.print("Ingrese su nuevo nombre: ");
                        String nombre = Consola.teclado.nextLine();
                        servUsuario.modificarDatosUsuario(user, nombre, opcion);
                        mostrarModificados(user);
                        break;
                    case "2":
                        System.out.println("--------------------------------------------------------");
                        System.out.print("Ingresa tu nuevo correo: ");
                        String correo = pedirCorreo();
                        servUsuario.modificarDatosUsuario(user, correo, opcion);
                        mostrarModificados(user);
                        break;
                    case "3":
                        System.out.println("--------------------------------------------------------");
                        System.out.print("Ingresa tu nueva contraseña: ");
                        String contrasenia = pedirContrasenia();
                        servUsuario.modificarDatosUsuario(user, contrasenia, opcion);
                        mostrarModificados(user);
                        break;
                    case "4":
                        System.out.println("--------------------------------------------------------");
                        System.out.print("Ingresa tu nueva ubicación: ");
                        String ubicacion = pedirUbicacion();
                        servUsuario.modificarDatosUsuario(user, ubicacion, opcion);
                        mostrarModificados(user);
                        break;
                    case "0":
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Volviendo...");
                        break;
                    default:
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Opcion no reconocida, reintentar");
                        break;
                }
            } while(!opcion.equals("0"));
        } catch (CorreoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    private void mostrarModificados(Usuario user){
        System.out.println("--------------------------------------------------------");
        System.out.println("Perfil de usuario tras las modificaciones: ");
        System.out.println("Nombre: "+user.getNombre());
        System.out.println("Correo: "+user.getCorreo());
        System.out.println("Contraseña: "+user.getContrasenia());
        System.out.println("Ubicación: "+user.getUbicacion());
    }

}
