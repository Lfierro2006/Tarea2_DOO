package reunion;

import empleado.Empleado;
import invitacion.Invitacion;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(Empleado organizador, String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, List<Invitacion> invitaciones){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipo,invitaciones);
        this.sala=sala;
    }
    public String getSala() {
        return sala;
    }
    @Override
    public String toString(){
        return super.toString()+"| Sala: "+this.getSala();
    }
}