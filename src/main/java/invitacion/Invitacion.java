package invitacion;

import invitable.Invitable;
import java.time.Instant;

public class Invitacion{
    private final Invitable invitado;
    private final Instant hora;

    public Invitacion(Invitable invitado, Instant hora){
        this.invitado = invitado;
        this.hora = hora;
    }

    public Invitable getInvitado(){
        return invitado;
    }
    public Instant getHora(){
        return hora;
    }
    public void enviar() {
        invitado.invitar();
    }

    @Override
    public String toString(){
        return "Invitación a: " + invitado.toString() + " | Hora: " + hora;
    }
}