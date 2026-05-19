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
    enum tipoReunion{
        TECNICA,
        MARKETING,
        OTRO
    }
    public Reunion(Empleado organizador,Date fecha,Duration duracionPrevista/*, List invitacion*/){
        this.fecha=fecha;
        this.duracionPrevista=duracionPrevista;
    }
    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetraos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){}
    public void iniciar(){}
    public void finalizar(){}

}
