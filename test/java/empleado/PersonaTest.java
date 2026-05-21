package empleado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    private static class PersonaPrueba extends Persona {
        public PersonaPrueba(String nombre, String apellidos, String correo) {
            super(nombre, apellidos, correo);
        }
    }

    @Test
    public void testGetNombreCompletoConcatenaCorrectamente() {
        Persona persona = new PersonaPrueba("Juan", "Perez", "juan.perez@udec.cl");

        String nombreCompleto = persona.getNombreCompleto();

        assertEquals("Juan Perez", nombreCompleto,
                "El nombre completo debe tener un espacio entre el nombre y el apellido");
    }

    @Test
    public void testToStringFormatoCorrecto() {

        Persona persona = new PersonaPrueba("Ana", "Gomez", "ana@empresa.com");

        String resultadoToString = persona.toString();

        String resultadoEsperado = "Nombre completo: Ana Gomez\nCorreo: ana@empresa.com";

        assertEquals(resultadoEsperado, resultadoToString,
                "metodo toString no devuelve el resultado esperado");
    }
}