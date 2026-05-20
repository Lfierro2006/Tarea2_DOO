package reunion;

import empleado.Empleado;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String ubicacion;
    public ReunionVirtual(Empleado organizador,String link, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion/*, List invitacion*/){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipoReunion/*, invitaciones*/);
        this.ubicacion=link;
    }
    public String getLink(){
        return ubicacion;
    }
}
