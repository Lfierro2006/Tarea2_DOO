package reunion;

import Persona.Empleado;
import invitacion.Invitacion;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * Representa una reunión que se realiza físicamente en una sala.
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    /**
     * Crea una nueva reunión presencial.
     *
     * @param organizador      El empleado que organiza la reunión.
     * @param sala             El lugar o sala donde se llevará a cabo.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora programada de inicio.
     * @param duracionPrevista La duración estimada.
     * @param tipo             La categoría de la reunión.
     * @param invitaciones     La lista de invitaciones.
     */
    public ReunionPresencial(Empleado organizador, String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, List<Invitacion> invitaciones){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipo,invitaciones);
        this.sala=sala;
    }
    /**
     * Obtiene la sala de la reunión.
     *
     * @return El nombre o identificador de la sala.
     */
    public String getSala() {
        return sala;
    }
    /**
     * Devuelve los datos de la reunión incluyendo la sala.
     *
     * @return Cadena descriptiva de la reunión presencial.
     */
    @Override
    public String toString(){
        return super.toString()+"| Sala: "+this.getSala();
    }
}