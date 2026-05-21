package reunion;

import empleado.Empleado;
import invitacion.Invitacion;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(Empleado organizador, String link, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion, List<Invitacion> invitaciones){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipoReunion,invitaciones);
        this.enlace=link;
    }
    public String getLink(){
        return enlace;
    }
    @Override
    public String toString(){
        return super.toString()+" | Enlace Reunion: "+this.getLink();
    }
}
