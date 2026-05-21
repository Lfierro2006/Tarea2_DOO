package asistencia;

import invitable.Invitable;

import java.time.Instant;

public class Retraso extends Asistencia {
    public Retraso(Invitable invitado, Instant horaLlegada){
        super(invitado,horaLlegada);
    }
    @Override
    public String toString(){
        return this.getInvitado().toString()+" asistió pero llegó con retraso a las "+this.getHoraLlegada();
    }
}
