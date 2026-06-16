public class RelacionUsuario {
    private Usuario usuarioRelacionado;
    private boolean loSigo;
    private boolean meSigue;
    private boolean amigo;
    private int confianza;

    public RelacionUsuario(Usuario usuarioRelacionado){
        this.usuarioRelacionado = usuarioRelacionado;
        this.loSigo = false;
        this.meSigue = false;
        this.amigo = false;
        this.confianza = 0;
    }


}
