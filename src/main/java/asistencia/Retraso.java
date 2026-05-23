package asistencia;

import invitable.Invitable;

import java.time.Instant;
/**
 * Representa la asistencia tardía de un invitado a una reunión.
 */
public class Retraso extends Asistencia {
    /**
     * Crea un registro de retraso.
     *
     * @param invitado    El asistente que llegó tarde.
     * @param horaLlegada La hora exacta de su llegada.
     */
    public Retraso(Invitable invitado, Instant horaLlegada){
        super(invitado,horaLlegada);
    }
    /**
     * Devuelve el texto indicando que el invitado llegó con retraso junto a su hora.
     *
     * @return Cadena descriptiva del retraso.
     */
    @Override
    public String toString(){
        return this.getInvitado().toString()+" asistió pero llegó con retraso a las "+this.getHoraLlegada()+"\n";
    }
}
