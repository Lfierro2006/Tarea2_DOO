package asistencia;

import Persona.PGenerico;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Asistencia}.
 * Verifica el funcionamiento del constructor, los métodos getters
 * y la representacion en cadena de texto del objeto
 */

public class AsistenciaTest {

    /**
     * Prueba que verifica la correcta asignación de atributos al instanciar
     * un objeto de la clase Asistencia. Comprueba que los metodos getter
     * devuelvan exactamente los mismos valores pasados al constructor.
     */

    @Test
    public void testAsignacionAtributos() {
        PGenerico invitado = new PGenerico("Juan", "Lopez", "Jlopez@udec.cl");
        Instant horaLlegada = Instant.parse("2026-02-20T09:30:00Z");

        Asistencia asistencia = new Asistencia(invitado, horaLlegada);

        assertEquals(invitado, asistencia.getInvitado(), "invitado no coincide con el entregado en el constructor.");
        assertEquals(horaLlegada, asistencia.getHoraLlegada(), "Hora de llegada no coincide con la entregada en el constructor.");
    }
    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada contenga correctamente la información
     * de la persona invitada y la hora exacta de su llegada
     */
    @Test
    public void testToStringFormatoCorrecto() {
        PGenerico invitado = new PGenerico("Carlos", "Soto", "carlos.soto@udec.cl");
        Instant horaLlegada = Instant.parse("2026-05-21T10:00:00Z");

        Asistencia asistencia = new Asistencia(invitado, horaLlegada);

        String resultadoToString = asistencia.toString();

        String resultadoEsperado = "Nombre completo: Carlos Soto\nCorreo: carlos.soto@udec.cl ha asistido y llegó a las 2026-05-21T10:00:00Z";

        assertEquals(resultadoEsperado, resultadoToString,
                "El metodo toString de Asistencia no devuelve el resultado esperado");
    }
}
