package Persona;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Clase de pruebas unitarias para la clase abstracta {@link Persona}.
 * Dado que Persona es abstracta y no puede ser instanciada directamente,
 * se utiliza una clase interna concreta temporal ({@code PersonaPrueba})
 * para evaluar el comportamiento de sus métodos heredados.
 */

public class PersonaTest {

    /**
     * Subclase concreta y estática utilizada exclusivamente para probar
     * la funcionalidad de la clase abstracta {@link Persona}.
     */
    private static class PersonaPrueba extends Persona {
        public PersonaPrueba(String nombre, String apellidos, String correo) {
            super(nombre, apellidos, correo);
        }
    }

    /**
     * Prueba que verifica el funcionamiento del metodo {@code getNombreCompleto()}.
     * Comprueba que la función concatene el nombre y los apellidos
     * de la persona, insertando un espacio en blanco entre ambos.
     */
    @Test
    public void testGetNombreCompletoConcatenaCorrectamente() {
        Persona persona = new PersonaPrueba("Juan", "Perez", "juan.perez@udec.cl");

        String nombreCompleto = persona.getNombreCompleto();

        assertEquals("Juan Perez", nombreCompleto,
                "El nombre completo debe tener un espacio entre el nombre y el apellido");
    }

    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada devuelva la información de la persona
     * estructurada con su nombre completo y su correo electrónico.
     */
    @Test
    public void testToStringFormatoCorrecto() {

        Persona persona = new PersonaPrueba("Ana", "Gomez", "ana@empresa.com");

        String resultadoToString = persona.toString();

        String resultadoEsperado = "Nombre completo: Ana Gomez\nCorreo: ana@empresa.com";

        assertEquals(resultadoEsperado, resultadoToString,
                "metodo toString no devuelve el resultado esperado");
    }
}