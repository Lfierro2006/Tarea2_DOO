package reunion;

import departamento.Departamento;
import Persona.Empleado;
import invitacion.Invitacion;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link ReunionVirtual}.
 * Se encarga de verificar la asignacion de los atributos exclusivos
 * de una reunión virtual y su representación en texto.
 */
public class ReunionVirtualTest {

    /**
     * Prueba que verifica la inicialización de una reunión virtual.
     * Comprueba que el atributo específico de este tipo de reunión (el enlace)
     * se asigne correctamente a través del constructor y pueda ser recuperado
     * intacto mediante el metodo {@code getLink()}.
     */
    @Test
    public void testAsignacionAtributos() {
        Departamento depto = new Departamento("Desarrollo");
        Empleado organizador = new Empleado("Luis", "Martinez", "lmartinez@udec.cl", "789", depto);
        List<Invitacion> invitaciones = new ArrayList<>();

        String enlace = "https://zoom.us/j/123456789";

        ReunionVirtual reunion = new ReunionVirtual(organizador, enlace, new Date(),
                Instant.now(), Duration.ofHours(1), Reunion.tipoReunion.TECNICA, invitaciones);

        assertEquals(enlace, reunion.getLink(), "El enlace no coincide con el entregado en el constructor.");
    }

    /**
     * Prueba que verifica el formato de salida del método {@code toString()}.
     * Asegura que la cadena generada contenga de forma estructurada toda la
     * información base de la reunión, concatenando al final el dato específico
     * de la URL o enlace donde se llevará a cabo la videollamada.
     */
    @Test
    public void testToStringFormatoCorrecto() {
        Departamento depto = new Departamento("Finanzas");
        Empleado organizador = new Empleado("Sofia", "Castro", "scastro@udec.cl", "012", depto);

        Date fecha = new Date();
        Instant horaPrevista = Instant.parse("2026-05-27T10:00:00Z");
        List<Invitacion> invitaciones = new ArrayList<>();
        String enlace = "https://meet.google.com/abc-defg-hij";

        ReunionVirtual reunion = new ReunionVirtual(organizador, enlace, fecha,
                horaPrevista, Duration.ofMinutes(45), Reunion.tipoReunion.OTRO, invitaciones);

        String resultadoToString = reunion.toString();

        String resultadoEsperado = "Datos Reunion | Fecha: " + fecha + " | Hora:" + horaPrevista +
                " | Tipo: OTRO | Organizador: Sofia Castro (scastro@udec.cl) | Enlace Reunion: " + enlace;

        assertEquals(resultadoEsperado, resultadoToString,
                "Mtodo toString de ReunionVirtual no devuelve el resultado de texto esperado.");
    }
}