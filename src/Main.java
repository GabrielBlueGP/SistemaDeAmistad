import Controladores.ControlUsuario;
import Conversaciones.Conversacion;
import Conversaciones.TemaConversacion;
import ManualUsuario.RelacionUsuario;
import ManualUsuario.Usuario;
import Repositorios.RepositorioUsuario;
import Servicios.ServicioUsuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Usuario user1 = new Usuario("Juan", "Juan12LG", "juanito1245@gmail.com", "1234hgjd", "Buenos aires");
//        Usuario user2 = new Usuario("Mario", "Mariooo", "mariomm123@gmail.com", "1234qwrt", "Buenos aires");
//
//        RepositorioUsuario repoUser = new RepositorioUsuario();
//
//        repoUser.guardar(user1);
//        repoUser.guardar(user2);
//        System.out.println("Buscando...\n");
//        repoUser.buscarPorId("Juan12LG");
//        System.out.println("Listado:");
//        repoUser.listar();
//        System.out.println("Eliminar");
//        repoUser.eliminar("Juan12LG");
//        System.out.println("Listado:");
//        repoUser.listar();
//
//        TemaConversacion temas = new TemaConversacion();
//
//        temas.agregarTema("FNAF");
//        temas.alistarTemas();
//
//        RelacionUsuario rela1 = new RelacionUsuario(user2);
//        user1.getRelaciones().add(rela1);
//        System.out.println(user1.getRelaciones().toString());

        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        ServicioUsuario servicioUsuario = new ServicioUsuario(repositorioUsuario);
        ControlUsuario controlUsuario = new ControlUsuario(servicioUsuario);
    }
}