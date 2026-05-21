package nota;

import java.time.Instant;

public class Nota{
    private final String nota;
    private final Instant hora;
    public Nota(String nota){
        this.nota=nota;
        this.hora=Instant.now();
    }
    public String getNota(){
        return nota;
    }
    public Instant getHora(){
        return hora;
    }
    @Override
    public String toString(){
        return "["+this.getHora()+"] "+ this.getNota();
    }
}