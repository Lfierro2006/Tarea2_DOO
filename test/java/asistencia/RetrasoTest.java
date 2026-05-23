package asistencia;

import Persona.PGenerico;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

/**
 * clase de pruebas unitarias para la clase {@link Retraso}.
 * verifica que el registro de un retraso
 * genere correctamente su representación en formato de texto.
 */
public class RetrasoTest {

    /**
     * Prueba que verifica la salida del metodo {@code toString()}.
     * Asegura que la cadena de texto tenga la informacion del asistente
     * que llego tarde, y a que hora llego a la reunion
     */

    @Test
    public void testToStringFormatoCorrecto() {

        PGenerico invitado = new PGenerico("Javier", "Vidal", "javier.vidal@correo.cl");

        Instant horaLlegada = Instant.parse("2026-05-21T10:15:30Z");

        Retraso retraso = new Retraso(invitado, horaLlegada);

        String resultadoToString = retraso.toString();

        String resultadoEsperado = "Nombre: Javier Vidal | Correo: javier.vidal@correo.cl asistió pero llegó con retraso a las 2026-05-21T10:15:30Z\n";

        assertEquals(resultadoEsperado, resultadoToString,
                "El metodo toString de Retraso no devuelve el resultado esperado.");
    }
}