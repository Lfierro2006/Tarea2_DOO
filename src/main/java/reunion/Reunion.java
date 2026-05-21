package reunion;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import asistencia.Asistencia;
import asistencia.Retraso;
import empleado.Empleado;
import invitable.Invitable;
import invitacion.Invitacion;
import nota.Nota;

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

    public Reunion(Empleado organizador,Date fecha,Instant horaPrevista,Duration duracionPrevista,tipoReunion tipo, List<Invitacion> invitaciones){
        this.organizador=organizador;
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.tipo=tipo;
        this.notas=new ArrayList<>();
        this.invitaciones=new ArrayList<>(invitaciones);
        this.asistencias=new ArrayList<>();
        this.horaInicio=null;
        this.horaFinal=null;
    }
    public void registrarAsistencia(Invitable invitado,Instant horaLlegada){
        Instant horaInvitacion=null;
        for (Invitacion invitacion:invitaciones){
            if(invitacion.getInvitado().equals(invitado)){
                horaInvitacion=invitacion.getHora();
                break;
            }
        }
        if(horaLlegada.isAfter(horaInvitacion)){
            asistencias.add(new Retraso(invitado,horaLlegada));
        }else{
            asistencias.add(new Asistencia(invitado,horaLlegada));
        }
    }

    public void nuevaNota(String nota){
        notas.add(new Nota(nota));
    }

    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }
    public List<Invitable> obtenerAusencias(){
        List<Invitable> ausencias= new ArrayList<>();
        for (Invitacion invitado:invitaciones){
            boolean asistio=false;
            for(Asistencia asistente:asistencias){
                if(asistente.getInvitado().equals(invitado.getInvitado())){
                    asistio=true;
                    break;
                }
            }
    public float calcularTiempoReal(){
        return Duration.between(horaInicio,horaFinal).toNanos()/3_600_000_000_000.0f;
    }
    public void iniciar(){
        this.horaInicio=Instant.now();
    }
    public void finalizar(){
        this.horaFinal=Instant.now();
    }
}