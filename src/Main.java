import Conversaciones.Conversacion;
import Conversaciones.TemaConversacion;
import ManualUsuario.RelacionUsuario;
import ManualUsuario.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Juan", "Juan12LG", "juanito1245@gmail.com", "1234hgjd", "Buenos aires");
        Usuario user2 = new Usuario("Mario", "Mariooo", "mariomm123@gmail.com", "1234qwrt", "Buenos aires");

        Conversacion charla = new Conversacion(user1, user2);
        charla.charlando(user1, user2);

        System.out.println(user1);
        System.out.println(user2);

        TemaConversacion temas = new TemaConversacion();

        temas.agregarTema("FNAF");
        temas.alistarTemas();

        RelacionUsuario rela1 = new RelacionUsuario(user2);
        user1.getRelaciones().add(rela1);
        System.out.println(user1.getRelaciones().toString());
    }
}