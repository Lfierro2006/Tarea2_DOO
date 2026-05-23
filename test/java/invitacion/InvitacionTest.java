package invitacion;

import Persona.PGenerico;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link Invitacion}.
 * Verifica la inicialización de sus atributos, el formato
 * de texto devuelto y el comportamiento dinámico al enviar la invitación.
 */
public class InvitacionTest {

    /**
     * Prueba que verifica la correcta asignación de atributos al crear
     * una instancia de Invitacion. Comprueba que los métodos getter
     * ({@code getInvitado()} y {@code getHora()}) devuelvan los valores exactos
     * proporcionados en el constructor.
     */

    @Test
    public void testAsignacionAtributos() {
        PGenerico invitado = new PGenerico("Luis", "Tapia", "luis@correo.cl");
        Instant hora = Instant.parse("2026-05-22T15:00:00Z");

        Invitacion invitacion = new Invitacion(invitado, hora);

        assertEquals(invitado, invitacion.getInvitado(), "El invitado no coincide con el entregado en el constructor.");
        assertEquals(hora, invitacion.getHora(), "La hora no coincide con la entregada en el constructor.");
    }

    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada contenga los datos del invitado
     * y la hora prevista formateada correctamente.
     */
    @Test
    public void testToStringFormatoCorrecto() {
        PGenerico invitado = new PGenerico("Sofia", "Rojas", "sofia@correo.cl");
        Instant hora = Instant.parse("2026-05-22T16:30:00Z");

        Invitacion invitacion = new Invitacion(invitado, hora);

        String resultadoToString = invitacion.toString();

        String resultadoEsperado = "Invitación a: Nombre completo: Sofia Rojas\nCorreo: sofia@correo.cl | Hora: 2026-05-22T16:30:00Z";

        assertEquals(resultadoEsperado, resultadoToString,
                "Metodo toString de Invitacion no devuelve el resultado esperado");
    }

    /**
     * Prueba de comportamiento que verifica el metodo {@code enviar()}.
     * usa una clase simulada que implementa la interfaz
     * {@code Invitable} para interceptar y confirmar que el metodo
     * {@code invitar()} del objeto destino es ejecutado correctamente.
     */
    @Test
    public void testEnviarEjecutaInvitar() {

        class DummyInvitable implements invitable.Invitable {
            boolean fueInvitado = false;

            @Override
            public void invitar() {
                fueInvitado = true;
            }
        }

        DummyInvitable dummy = new DummyInvitable();
        Invitacion invitacion = new Invitacion(dummy, Instant.now());

        invitacion.enviar();

        assertTrue(dummy.fueInvitado, "Metodo enviar() debe ejecutar el metodo invitar() del objeto Invitable.");
    }
}