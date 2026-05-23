package reunion;

import departamento.Departamento;
import Persona.Empleado;
import Persona.PGenerico;
import invitacion.Invitacion;
import org.junit.jupiter.api.Test;
import excepciones.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase principal de pruebas unitarias para la clase abstracta {@link Reunion}.
 * Evalúa el núcleo lógico del sistema, incluyendo la gestión del tiempo,
 * el control de asistencia, cálculos estadísticos y un manejo exhaustivo
 * de excepciones para casos extremos y datos inválidos.
 */

public class ReunionTest {
    /**
     * Subclase concreta y estática utilizada exclusivamente para instanciar
     * y probar la funcionalidad base de la clase abstracta {@link Reunion}.
     */
    private static class ReunionPrueba extends Reunion {
        public ReunionPrueba(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, List<Invitacion> invitaciones) {
            super(organizador, fecha, horaPrevista, duracionPrevista, tipo, invitaciones);
        }
    }
    /**
     * Verifica el ciclo de vida temporal de una reunion
     * Comprueba que los metodos {@code iniciar()} y {@code finalizar()} capturen
     * correctamente las marcas de tiempo correspondientes, y que el calculo del
     * tiempo real devuelva un valor logico (mayor o igual a cero).
     */
    @Test
    public void testIniciarYFinalizarAsignanTiempos() {
        Departamento depto = new Departamento("Gerencia");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());

        assertNull(reunion.getHoraInicio(), "La hora de inicio debe ser nula antes de iniciar.");
        assertNull(reunion.getHoraFinal(), "La hora final debe ser nula antes de finalizar.");

        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio(), "La hora de inicio debe registrarse al llamar a iniciar().");

        reunion.finalizar();
        assertNotNull(reunion.getHoraFinal(), "La hora final debe registrarse al llamar a finalizar().");
        assertTrue(reunion.calcularTiempoReal() >= 0.0f, "El tiempo real calculado debe ser mayor o igual a 0.");
    }

    /**
     * Verifica la lógica de registro de asistencia y la clasificación automática de retrasos.
     * Comprueba que el sistema evalúe correctamente la hora de llegada frente a la
     * hora prevista de la invitación, separando a los puntuales de los atrasados.
     */
    @Test
    public void testRegistrarAsistenciaClasificaRetrasosCorrectamente() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);

        PGenerico invitado1 = new PGenerico("Juan", "Perez", "juan@udec.cl");
        PGenerico invitado2 = new PGenerico("Maria", "Gomez", "maria@udec.cl");

        Instant horaInvitacion = Instant.parse("2026-05-25T10:00:00Z");
        Invitacion inv1 = new Invitacion(invitado1, horaInvitacion);
        Invitacion inv2 = new Invitacion(invitado2, horaInvitacion);

        List<Invitacion> invitaciones = Arrays.asList(inv1, inv2);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), horaInvitacion,
                Duration.ofHours(1), Reunion.tipoReunion.TECNICA, invitaciones);

        Instant horaLlegadaPuntual = Instant.parse("2026-05-25T09:55:00Z");
        Instant horaLlegadaTarde = Instant.parse("2026-05-25T10:15:00Z");

        reunion.registrarAsistencia(invitado1, horaLlegadaPuntual);
        reunion.registrarAsistencia(invitado2, horaLlegadaTarde);

        assertEquals(2, reunion.obtenerTotalAsistencia(), "Debe haber 2 asistencias registradas en total.");
        assertEquals(1, reunion.obtenerRetrasos().size(), "Solo debe haber 1 retraso clasificado en la lista.");
        assertEquals(invitado2, reunion.obtenerRetrasos().get(0).getInvitado(), "El retraso debe corresponder al invitado que llego tarde.");
    }

    /**
     * Valida los cálculos estadísticos de la reunión.
     * Verifica que el metodo {@code obtenerPorcentajeAsistencia()} devuelva la proporción
     * correcta y que el sistema identifique adecuadamente a los invitados ausentes.
     */
    @Test
    public void testObtenerPorcentajeYAusencias() {
        Departamento depto = new Departamento("Marketing");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);

        PGenerico invitado1 = new PGenerico("Juan", "Perez", "juan@udec.cl");
        PGenerico invitado2 = new PGenerico("Maria", "Gomez", "maria@udec.cl");

        Instant horaInvitacion = Instant.now();
        List<Invitacion> invitaciones = Arrays.asList(new Invitacion(invitado1, horaInvitacion), new Invitacion(invitado2, horaInvitacion));

        Reunion reunion = new ReunionPrueba(organizador, new Date(), horaInvitacion,
                Duration.ofHours(2), Reunion.tipoReunion.MARKETING, invitaciones);

        reunion.registrarAsistencia(invitado1, Instant.now());

        assertEquals(50.0f, reunion.obtenerPorcentajeAsistencia(), "El porcentaje de asistencia debe ser 50.0 (1 de 2 invitados).");
        assertEquals(1, reunion.obtenerAusencias().size(), "Debe haber exactamente 1 ausencia.");
        assertEquals(invitado2, reunion.obtenerAusencias().get(0), "La ausencia debe corresponder al invitado que no registró asistencia.");
    }

    /**
     * Verifica que el metodo {@code nuevaNota()} añada correctamente objetos de
     * tipo Nota a la lista interna de la reunión.
     */
    @Test
    public void testNuevaNotaAgregaCorrectamente() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.TECNICA, new ArrayList<>());

        reunion.nuevaNota("Recordar la reunion dentro de un mes.");
        reunion.nuevaNota("Fijar fecha para la proxima semana.");

        assertEquals(2, reunion.getNotas().size(), "La lista de notas debe contener 2 elementos.");
        assertEquals("Fijar fecha para la proxima semana.", reunion.getNotas().get(1).getNota(), "El contenido de la nota agregada debe coincidir.");
    }

    /**
     * Prueba de seguridad: Verifica que se lance la excepcion {@link ReunionEstadoException}
     * Intentar iniciar una Reunion cuando la anterior no ha finalizado
     */
    @Test
    public void testIniciarReunionDosVeces(){
        Departamento depto = new Departamento("Gerencia");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());

        reunion.iniciar();
        Exception excepcionCapturada = assertThrows(ReunionEstadoException.class, () -> {
            reunion.iniciar();
        });

        assertEquals("Error: La Reunion anterior debe haber finalizado antes de iniciar otra nueva", excepcionCapturada.getMessage());
    }
}


    /**
     * Prueba de seguridad: Verifica que se lance la excepcion {@link ReunionEstadoException}
     * al intentar finalizar una reunión que no ha sido iniciada previamente.
     */
    @Test
    public void testFinalizarSinIniciarLanzaExcepcion() {
        Departamento depto = new Departamento("Gerencia");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());

        Exception excepcionCapturada = assertThrows(ReunionEstadoException.class, () -> {
            reunion.finalizar();
        });

        assertEquals("Error: No se puede finalizar una reunion que no ha sido iniciada", excepcionCapturada.getMessage());
    }

    /**
    * Prueba de seguridad: Verifica que se lance la excepcion {@link ReunionEstadoException}
    * al intentar finalizar una reunión por segunda vez a pesar de haber ya finalizado
    */
    @Test
    public void testFinDosVeces(){
        Departamento depto = new Departamento("Gerencia");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());
        reunion.iniciar();
        reunion.finalizar();
        Exception excepcionCapturada = assertThrows(ReunionEstadoException.class, () -> {
            reunion.finalizar();
        });

        assertEquals("Error: La ultima reunion ya fue finalizada y no hay otra en progreso", excepcionCapturada.getMessage());
    }


    /**
     * Prueba de seguridad: Verifica que se lance la excepción {@link ReunionEstadoException}
     * si se intenta calcular el tiempo real de ejecucion antes de que la reunión termine.
     */
    @Test
    public void testCalcularTiempoRealSinFinalizarLanzaExcepcion() {
        Departamento depto = new Departamento("Gerencia");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());

        reunion.iniciar();

        Exception excepcionCapturada = assertThrows(ReunionEstadoException.class, () -> {
            reunion.calcularTiempoReal();
        });

        assertEquals("Error: La reunion debe estar iniciada y finalizada para calcular el tiempo real", excepcionCapturada.getMessage());
    }

    /**
     * Prueba de seguridad: Verifica que se lance la excepción {@link AsistenteNoInvitadoException}
     * al intentar registrar la asistencia de una persona que no figura en la lista de invitaciones.
     */
    @Test
    public void testRegistrarAsistenteNoInvitadoLanzaExcepcion() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);

        PGenerico invitadoOficial = new PGenerico("Juan", "Pérez", "juan@udec.cl");
        Invitacion inv = new Invitacion(invitadoOficial, Instant.now());
        List<Invitacion> invitaciones = Arrays.asList(inv);

        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.TECNICA, invitaciones);

        PGenerico intruso = new PGenerico("Pedro", "Maldonado", "pedro@udec.cl");

        Exception excepcionCapturada = assertThrows(AsistenteNoInvitadoException.class, () -> {
            reunion.registrarAsistencia(intruso, Instant.now());
        });

        assertEquals("Error: No se puede registrar la asistencia de alguien que no fue invitado.", excepcionCapturada.getMessage());
    }

    /**
     * Prueba de seguridad: Verifica que se lance la excepción {@link AsistenciaDuplicadaException}
     * para prevenir que un mismo invitado registre su asistencia más de una vez.
     */

    @Test
    public void testAsistenciaDuplicadaLanzaExcepcion() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);

        PGenerico invitado = new PGenerico("Ana", "Gómez", "ana@udec.cl");
        Invitacion inv = new Invitacion(invitado, Instant.now());
        List<Invitacion> invitaciones = Arrays.asList(inv);

        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.TECNICA, invitaciones);

        reunion.registrarAsistencia(invitado, Instant.now());

        Exception excepcionCapturada = assertThrows(AsistenciaDuplicadaException.class, () -> {
            reunion.registrarAsistencia(invitado, Instant.now());
        });

        assertEquals("Error: El invitado ya ha registrado su asistencia previamente.", excepcionCapturada.getMessage());
    }

    /**
     * Prueba de seguridad (Matemática): Verifica que se lance la excepción {@link ReunionVaciaException}
     * para evitar una división por cero al calcular porcentajes en reuniones sin convocados.
     */

    @Test
    public void testObtenerPorcentajeSinInvitadosLanzaExcepcion() {
        Departamento depto = new Departamento("Marketing");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);

        List<Invitacion> invitacionesVacias = new ArrayList<>();

        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.MARKETING, invitacionesVacias);

        Exception excepcionCapturada = assertThrows(ReunionVaciaException.class, () -> {
            reunion.obtenerPorcentajeAsistencia();
        });

        assertEquals("Error: No se puede calcular el porcentaje de asistencia de una reunión sin invitados.", excepcionCapturada.getMessage());
    }
    /**
     * Prueba de seguridad (Lógica de negocio): Verifica que se lance la excepción
     * {@link TiempoInvalidoException} al intentar agendar una reunión con duración igual o menor a cero.
     */
    @Test
    public void testCrearReunionConDuracionInvalidaLanzaExcepcion() {
        Departamento depto = new Departamento("Ventas");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        List<Invitacion> invitaciones = new ArrayList<>();

        Duration duracionImposible = Duration.ofMinutes(-30);

        Exception excepcionCapturada = assertThrows(TiempoInvalidoException.class, () -> {
            new ReunionPrueba(organizador, new Date(), Instant.now(),
                    duracionImposible, Reunion.tipoReunion.OTRO, invitaciones);
        });

        assertEquals("Error: La duración prevista de la reunion debe ser mayor a cero.", excepcionCapturada.getMessage());
    }
    /**
     * Prueba de seguridad (Integridad de datos): Verifica que se lance la excepción
     * {@link DatosIncompletosException} cuando el constructor recibe parámetros nulos
     * que son vitales para la existencia de la reunión.
     */
    @Test
    public void testCrearReunionConDatosFaltantesLanzaExcepcion() {

        Exception excepcionCapturada = assertThrows(DatosIncompletosException.class, () -> {
            new ReunionPrueba(null, new Date(), Instant.now(),
                    Duration.ofHours(1), Reunion.tipoReunion.OTRO, new ArrayList<>());
        });

        assertEquals("Error: Faltan datos obligatorios para agendar la reunión (se detectó un valor nulo).", excepcionCapturada.getMessage());
    }