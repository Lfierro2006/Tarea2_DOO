package Persona;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase {@link PGenerico}.
 * Se encarga de verificar los métodos específicos de un
 * invitado generico o externo a la organización.
 */
public class PGenericoTest {

    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada devuelva la información del invitado generico
     * estructurada correctamente con su nombre completo y su correo electronico.
     */
    @Test
    public void testToStringFormatoCorrecto() {
        PGenerico invitadoExterno = new PGenerico("Laura", "Vidal", "laura.vidal@correo.cl");

        String resultadoToString = invitadoExterno.toString();

        String resultadoEsperado = "Nombre completo: Laura Vidal\nCorreo: laura.vidal@correo.cl";

        assertEquals(resultadoEsperado, resultadoToString,
                "El método toString de PGenerico no devuelve el resultado esperado");
    }
}