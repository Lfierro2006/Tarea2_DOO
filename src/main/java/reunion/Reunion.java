package reunion;

import excepciones.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import asistencia.Asistencia;
import asistencia.Retraso;
import Persona.Empleado;
import informe.Informe;
import invitable.Invitable;
import invitacion.Invitacion;
import nota.Nota;
/**
 * Representa una reunión genérica en el sistema, gestionando asistencias, tiempos y notas.
 */
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
    /**
     * Categorías disponibles para clasificar una reunión.
     */
    public enum tipoReunion{
        TECNICA,
        MARKETING,
        OTRO
    }
    /**
     * Crea una nueva reunión y valida que los datos iniciales sean correctos.
     *
     * @param organizador      El empleado que organiza la reunión.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora programada de inicio.
     * @param duracionPrevista La duración estimada.
     * @param tipo             La categoría de la reunión.
     * @param invitaciones     La lista inicial de invitaciones.
     * @throws DatosIncompletosException Si algún parámetro obligatorio es nulo.
     * @throws TiempoInvalidoException   Si la duración prevista es nula o negativa.
     */
    public Reunion(Empleado organizador,Date fecha,Instant horaPrevista,Duration duracionPrevista,tipoReunion tipo, List<Invitacion> invitaciones){

        if (organizador == null || fecha == null || horaPrevista == null || duracionPrevista == null || tipo == null || invitaciones == null) {
            throw new DatosIncompletosException("Error: Faltan datos obligatorios para agendar la reunión (se detectó un valor nulo).");
        }

        if (duracionPrevista.isZero() || duracionPrevista.isNegative()) {
            throw new TiempoInvalidoException("Error: La duración prevista de la reunion debe ser mayor a cero.");
        }

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
    /**
     * Registra la llegada de un invitado, clasificándolo como puntual o con retraso.
     *
     * @param invitado    El asistente a registrar.
     * @param horaLlegada La hora exacta de su llegada.
     * @throws AsistenteNoInvitadoException Si la persona no está en la lista de invitados.
     * @throws AsistenciaDuplicadaException Si el invitado ya fue registrado antes.
     */
    public void registrarAsistencia(Invitable invitado,Instant horaLlegada){
        Instant horaInvitacion=null;
        for (Invitacion invitacion:invitaciones){
            if(invitacion.getInvitado().equals(invitado)){
                horaInvitacion=invitacion.getHora();
                break;
            }
        }
        if(horaInvitacion == null){
            throw new AsistenteNoInvitadoException("Error: No se puede registrar la asistencia de alguien que no fue invitado.");
        }
        for (Asistencia asistenciaRegistrada : asistencias) {
            if (asistenciaRegistrada.getInvitado().equals(invitado)) {
                throw new AsistenciaDuplicadaException("Error: El invitado ya ha registrado su asistencia previamente.");
            }
        }
        if(horaLlegada.isAfter(horaInvitacion)){
            asistencias.add(new Retraso(invitado,horaLlegada));
        }else{
            asistencias.add(new Asistencia(invitado,horaLlegada));
        }
    }
    /**
     * Añade una nota a la reunión.
     *
     * @param nota El contenido de la nota.
     */
    public void nuevaNota(String nota){
        notas.add(new Nota(nota));
    }
    /**
     * Obtiene la lista total de asistencias registradas.
     *
     * @return Lista de asistencias.
     */
    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }
    /**
     * Identifica y obtiene la lista de invitados que no asistieron.
     *
     * @return Lista de ausentes.
     */
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
            if(!asistio){
                ausencias.add(invitado.getInvitado());
            }
        }
        return ausencias;
    }
    /**
     * Filtra y obtiene únicamente las asistencias marcadas como retraso.
     *
     * @return Lista de retrasos.
     */
    public List<Retraso> obtenerRetrasos(){
        List<Retraso>retrasos=new ArrayList<>();
        for(Asistencia asistente:asistencias){
            if(asistente.getClass()==Retraso.class){
                retrasos.add((Retraso) asistente);
            }
        }
        return retrasos;
    }
    /**
     * Obtiene la cantidad total de personas que asistieron.
     *
     * @return Número de asistentes.
     */
    public int obtenerTotalAsistencia(){
        return asistencias.size();
    }
    /**
     * Calcula el porcentaje de asistencia en base a los invitados.
     *
     * @return El porcentaje de asistencia (0 a 100).
     * @throws ReunionVaciaException Si no hay invitados en la reunión.
     */
    public float obtenerPorcentajeAsistencia(){
        if (invitaciones.isEmpty()) {
            throw new ReunionVaciaException("Error: No se puede calcular el porcentaje de asistencia de una reunión sin invitados.");
        }
        return (float) asistencias.size()/invitaciones.size()*100;
    }
    /**
     * Calcula la duración real de la reunión en horas.
     *
     * @return El tiempo transcurrido en horas.
     * @throws ReunionEstadoException Si la reunión no ha sido iniciada y finalizada.
     * @throws TiempoInvalidoException Si la hora final es anterior a la hora de inicio.
     */
    public float calcularTiempoReal(){
        if (this.horaInicio == null || this.horaFinal == null) {
            throw new ReunionEstadoException("Error: La reunion debe estar iniciada y finalizada para calcular el tiempo real");
        }

        if (this.horaFinal.isBefore(this.horaInicio)) {
            throw new TiempoInvalidoException("Error: La hora final no puede ser anterior a la hora de inicio.");
        }

        return Duration.between(horaInicio, horaFinal).toNanos() / 3_600_000_000_000.0f;
    }
    /**
     * Marca el inicio de la reunión registrando la hora actual.
     */
    public void iniciar(){
        this.horaInicio=Instant.now();
    }
    /**
     * Marca el fin de la reunión registrando la hora actual.
     *
     * @throws ReunionEstadoException Si se intenta finalizar sin haber iniciado.
     */
    public void finalizar(){
        if (this.horaInicio == null) {
            throw new ReunionEstadoException("Error: No se puede finalizar una reunion que no ha sido iniciada");
        }
        this.horaFinal = Instant.now();
    }
    /**
     * Genera un archivo de texto con el resumen de la reunión.
     */
    public void generarInforme(){
        new Informe(this).generarInforme();
    }
    /**
     * @return El organizador de la reunión.
     */
    public Empleado getOrganizador(){
        return organizador;
    }
    /**
     * @return La fecha de la reunión.
     */
    public Date getFecha(){
        return fecha;
    }
    /**
     * @return La hora programada.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    /**
     * @return La hora real de inicio (nula si no ha comenzado).
     */
    public Instant getHoraInicio(){
        return horaInicio;
    }
    /**
     * @return La hora real de término (nula si no ha terminado).
     */
    public Instant getHoraFinal(){
        return horaFinal;
    }
    /**
     * @return La duración planificada.
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    /**
     * @return La categoría o tipo de la reunión.
     */
    public tipoReunion getTipo(){
        return tipo;
    }
    /**
     * @return La lista de notas registradas.
     */
    public List<Nota> getNotas(){
        return notas;
    }
    /**
     * @return La lista de invitaciones.
     */
    public List<Invitacion> getInvitaciones(){
        return invitaciones;
    }
    /**
     * Devuelve los datos básicos de la reunión en formato de texto.
     *
     * @return Cadena descriptiva.
     */
    @Override
    public String toString(){
        return "Datos Reunion | Fecha: "+this.getFecha()+" | Hora:"+this.getHoraPrevista()+" | Tipo: "+this.getTipo()+" | Organizador: "+this.getOrganizador().getNombreCompleto()+" ("+this.getOrganizador().getCorreo()+")";
    }
}