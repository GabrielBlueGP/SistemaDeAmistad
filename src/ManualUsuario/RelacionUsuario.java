package ManualUsuario;

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

    public boolean isLoSigo() {
        return loSigo;
    }

    public boolean isMeSigue() {
        return meSigue;
    }

    public boolean isAmigo() {
        return amigo;
    }

    public int getConfianza() {
        return confianza;
    }

    public Usuario getUsuarioRelacionado() {
        return usuarioRelacionado;
    }

    public void setLoSigo(boolean loSigo) {
        this.loSigo = loSigo;
    }

    public void setMeSigue(boolean meSigue) {
        this.meSigue = meSigue;
    }

    public void setAmigo(boolean amigo) {
        this.amigo = amigo;
    }

    public void setConfianza(int confianza) {
        this.confianza = confianza;
    }

    @Override
    public String toString() {
        return "Relacion con: "+
                usuarioRelacionado.getNombre()+
                "| amigo: "+amigo+
                "| loSigo: "+loSigo+
                "| meSigue: "+meSigue+
                "| confianza: "+confianza;
    }
}
