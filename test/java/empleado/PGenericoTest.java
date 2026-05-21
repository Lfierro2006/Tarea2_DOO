package empleado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PGenericoTest {

    @Test
    public void testToStringFormatoCorrecto() {
        PGenerico invitadoExterno = new PGenerico("Laura", "Vidal", "laura.vidal@correo.cl");

        String resultadoToString = invitadoExterno.toString();

        String resultadoEsperado = "Nombre completo: Laura Vidal\nCorreo: laura.vidal@correo.cl";

        assertEquals(resultadoEsperado, resultadoToString,
                "El método toString de PGenerico no devuelve el resultado esperado");
    }
}