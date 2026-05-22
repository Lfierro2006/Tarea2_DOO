package invitacion;

import invitable.Invitable;
import java.time.Instant;
/**
 * Representa una invitación a una reunión para un destinatario específico.
 */
public class Invitacion{
    private final Invitable invitado;
    private final Instant hora;
    /**
     * Crea una nueva invitación.
     *
     * @param invitado A quién va dirigida la invitación.
     * @param hora     La hora programada para la reunión.
     */
    public Invitacion(Invitable invitado, Instant hora){
        this.invitado = invitado;
        this.hora = hora;
    }
    /**
     * Obtiene el destinatario de la invitación.
     *
     * @return El invitado.
     */
    public Invitable getInvitado(){
        return invitado;
    }
    /**
     * Obtiene la hora programada para la reunión.
     *
     * @return La hora de la invitación.
     */
    public Instant getHora(){
        return hora;
    }
    /**
     * Envía la invitación ejecutando la acción de invitar en el destinatario.
     */
    public void enviar() {
        invitado.invitar();
    }
    /**
     * Devuelve un texto descriptivo con los datos de la invitación.
     *
     * @return Cadena que indica el invitado y la hora.
     */
    @Override
    public String toString(){
        return "Invitación a: " + invitado.toString() + " | Hora: " + hora;
    }
}