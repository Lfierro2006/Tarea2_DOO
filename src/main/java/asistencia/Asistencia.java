package asistencia;

public class Asistencia {
    private final Invitable invitado;
    private final Instant horaLlegada;
    public Asistencia(Invitable invitado,Instant horaLlegada){
        this.invitado=invitado;
        this.horaLlegada=horaLlegada;
    }

    public Instant getHoraLlegada(){
        return horaLlegada;
    }
    public Invitable getInvitado(){
        return invitado;
    }
}
