package reunion;

import Persona.Empleado;
import invitacion.Invitacion;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * Representa una reunión que se realiza de forma remota a través de un enlace web.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;
    /**
     * Crea una nueva reunión virtual.
     *
     * @param organizador      El empleado que organiza la reunión.
     * @param link             El enlace web para conectarse a la videollamada.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora programada de inicio.
     * @param duracionPrevista La duración estimada.
     * @param tipoReunion      La categoría de la reunión.
     * @param invitaciones     La lista de invitaciones.
     */
    public ReunionVirtual(Empleado organizador, String link, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion, List<Invitacion> invitaciones){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipoReunion,invitaciones);
        this.enlace=link;
    }
    /**
     * Obtiene el enlace de la reunión.
     *
     * @return El enlace web.
     */
    public String getLink(){
        return enlace;
    }
    /**
     * Devuelve los datos de la reunión incluyendo el enlace de conexión.
     *
     * @return Cadena descriptiva de la reunión virtual.
     */
    @Override
    public String toString(){
        return super.toString()+" | Enlace Reunion: "+this.getLink();
    }
}
