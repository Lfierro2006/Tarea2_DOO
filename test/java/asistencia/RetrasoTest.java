package asistencia;

import Persona.PGenerico;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class RetrasoTest {

    @Test
    public void testToStringFormatoCorrecto() {

        PGenerico invitado = new PGenerico("Javier", "Vidal", "javier.vidal@correo.cl");

        Instant horaLlegada = Instant.parse("2026-05-21T10:15:30Z");

        Retraso retraso = new Retraso(invitado, horaLlegada);

        String resultadoToString = retraso.toString();

        String resultadoEsperado = "Nombre completo: Javier Vidal\nCorreo: javier.vidal@correo.cl asistió pero llegó con retraso a las 2026-05-21T10:15:30Z";

        assertEquals(resultadoEsperado, resultadoToString,
                "El metodo toString de Retraso no devuelve el resultado esperado.");
    }
}