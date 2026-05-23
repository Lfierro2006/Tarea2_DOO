package nota;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    /**
     * Clase de pruebas unitarias para la clase {@link Nota}.
     * Verifica la asignación del contenido de texto, la generación
     * automática de la marca de tiempo y el formato de salida de la nota.
     */

public class NotaTest {

        /**
         * Prueba que verifica la creación y asignación de atributos de una nota.
         * Comprueba que el texto proporcionado al constructor se almacene correctamente
         * y que el sistema genere de manera automática una hora de registro válida
         * (comprobando que no sea nula mediante {@code assertNotNull()}).
         */
    @Test
    public void testAsignacionAtributos() {
        String textoNota = "Recordar enviar el correo al cliente";
        Nota nota = new Nota(textoNota);

        assertEquals(textoNota, nota.getNota(), "El contenido de la nota no coincide con el entregado en el constructor.");
        assertNotNull(nota.getHora(), "La hora de la nota se debio generar automaticamente y no debe ser nula.");
    }

        /**
         * Prueba que verifica el formato de salida del metodo {@code toString()}.
         * Asegura que la cadena generada cumpla con la estructura visual esperada,
         * la cual debe incluir la marca de tiempo entre corchetes seguida del texto
         * exacto de la nota.
         */
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