package reunion;

import Persona.Empleado;
import departamento.Departamento;
import invitacion.Invitacion;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link ReunionPresencial}.
 * Se encarga de verificar la asignación de los atributos exclusivos
 * de una reunión presencial y su representación en texto.
 */

public class ReunionPresencialTest {

    /**
     * Prueba que verifica la inicialización de una reunión presencial.
     * Comprueba que el atributo específico de este tipo de reunión (la sala)
     * se asigne correctamente a través del constructor y pueda ser recuperado
     * mediante el metodo {@code getSala()}.
     */
    @Test
    public void testAsignacionAtributos() {
        Departamento depto = new Departamento("Operaciones");
        Empleado organizador = new Empleado("Carlos", "Perez", "cperez@udec.cl", "123", depto);
        List<Invitacion> invitaciones = new ArrayList<>();

        String sala = "Sala 302 - Edificio Central";

        ReunionPresencial reunion = new ReunionPresencial(organizador, sala, new Date(),
                Instant.now(), Duration.ofHours(2), Reunion.tipoReunion.OTRO, invitaciones);

        assertEquals(sala, reunion.getSala(), "La sala no coincide con la entregada en el constructor.");
    }

    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada contenga de forma estructurada toda la
     * información base de la reunión, concatenando al final el dato específico
     * de la sala donde se realizará.
     */
    @Test
    public void testToStringFormatoCorrecto() {
        Departamento depto = new Departamento("Ventas");
        Empleado organizador = new Empleado("Ana", "Rojas", "arojas@udec.cl", "456", depto);

        Date fecha = new Date();
        Instant horaPrevista = Instant.parse("2026-05-26T15:00:00Z");
        List<Invitacion> invitaciones = new ArrayList<>();
        String sala = "Sala de Conferencias";

        ReunionPresencial reunion = new ReunionPresencial(organizador, sala, fecha,
                horaPrevista, Duration.ofMinutes(90), Reunion.tipoReunion.MARKETING, invitaciones);

        String resultadoToString = reunion.toString();

        String resultadoEsperado = "Datos Reunion | Fecha: " + fecha + " | Hora:" + horaPrevista +
                " | Tipo: MARKETING | Organizador: Ana Rojas (arojas@udec.cl)| Sala: " + sala;

        assertEquals(resultadoEsperado, resultadoToString,
                "Metodo toString de ReunionPresencial no devuelve el formato de texto correcto.");
    }
}