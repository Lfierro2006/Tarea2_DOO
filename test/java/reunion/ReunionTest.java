package reunion;

import departamento.Departamento;
import empleado.Empleado;
import empleado.PGenerico;
import invitacion.Invitacion;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {

    private static class ReunionPrueba extends Reunion {
        public ReunionPrueba(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, List<Invitacion> invitaciones) {
            super(organizador, fecha, horaPrevista, duracionPrevista, tipo, invitaciones);
        }
    }

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

    @Test
    public void testNuevaNotaAgregaCorrectamente() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Admin", "Jefe", "admin@udec.cl", "111", depto);
        Reunion reunion = new ReunionPrueba(organizador, new Date(), Instant.now(),
                Duration.ofHours(1), Reunion.tipoReunion.TECNICA, new ArrayList<>());

        reunion.nuevaNota("Recordar la reunion dentro de un mes.");
        reunion.nuevaNota("Fijar fecha para la próxima semana.");

        assertEquals(2, reunion.getNotas().size(), "La lista de notas debe contener 2 elementos.");
        assertEquals("Fijar fecha para la proxima semana.", reunion.getNotas().get(1).getNota(), "El contenido de la nota agregada debe coincidir.");
    }
}