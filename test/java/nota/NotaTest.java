package nota;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    public void testAsignacionAtributos() {
        String textoNota = "Recordar enviar el correo al cliente";
        Nota nota = new Nota(textoNota);

        assertEquals(textoNota, nota.getNota(), "El contenido de la nota no coincide con el entregado en el constructor.");
        assertNotNull(nota.getHora(), "La hora de la nota se debio generar automaticamente y no debe ser nula.");
    }

    @Test
    public void testToStringFormatoCorrecto() {
        String textoNota = "Hola hola";
        Nota nota = new Nota(textoNota);

        String resultadoToString = nota.toString();

        String resultadoEsperado = "[" + nota.getHora() + "] " + textoNota;

        assertEquals(resultadoEsperado, resultadoToString,
                "El método toString de Nota no devuelve el formato de texto correcto.");
    }
}