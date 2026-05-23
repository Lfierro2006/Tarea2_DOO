package asistencia;

import invitable.Invitable;

import java.time.Instant;
/**
 * Registro de asistencia de un invitado a una reunión.
 */
public class Asistencia {
    private final Invitable invitado;
    private final Instant horaLlegada;
    /**
     * Crea un registro de asistencia.
     *
     * @param invitado    El asistente a la reunión.
     * @param horaLlegada La hora exacta de su llegada.
     */
    public Asistencia(Invitable invitado,Instant horaLlegada){
        this.invitado=invitado;
        this.horaLlegada=horaLlegada;
    }
    /**
     * Obtiene la hora a la que llegó el invitado.
     *
     * @return La hora de llegada.
     */
    public Instant getHoraLlegada(){
        return horaLlegada;
    }
    /**
     * Obtiene el invitado asociado a esta asistencia.
     *
     * @return El asistente.
     */
    public Invitable getInvitado(){
        return invitado;
    }
    /**
     * Devuelve el texto indicando que el invitado asistió y su hora de llegada.
     *
     * @return Cadena descriptiva de la asistencia.
     */
    @Override
    public String toString(){
        return invitado.toString()+" ha asistido y llegó a las "+this.getHoraLlegada()+"\n";
    }
}
