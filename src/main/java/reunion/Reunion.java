package reunion;

import java.time.*;
import java.util.Date;
import java.util.List;

import empleado.Empleado;
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private Empleado organizador;
    private tipoReunion tipo;
    private final List<Invitacion> invitaciones;
    private final List<Asistencia> asistencias;
    private List<Nota> notas;

    public enum tipoReunion{
        TECNICA,
        MARKETING,
        OTRO
    }
    public Reunion(Empleado organizador,Date fecha,Instant horaPrevista,Duration duracionPrevista,tipoReunion tipoReunion/*, List invitacion*/){
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
    }

    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetraos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){
        return Duration.between(horaInicio,horaFinal).toNanos()/3_600_000_000_000.0f;
    }
    public void iniciar(){
        this.horaInicio=Instant.now();
        this.horaFinal=null;
    }
    public void finalizar(){
        this.horaFinal=Instant.now();
    }
}