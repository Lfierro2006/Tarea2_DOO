package reunion;

import empleado.Empleado;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String ubicacion;
    public ReunionPresencial(Empleado organizador,String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipoReunion/*, List invitacion*/){
        super(organizador,fecha,horaPrevista,duracionPrevista,tipoReunion/*, invitaciones*/);
        this.ubicacion=sala;
    }
    public String getSala() {
        return ubicacion;
    }

}