package Persona;

import departamento.Departamento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Clase de pruebas unitarias para la clase {@link Empleado}.
 * Verifica la  asignación de atributos específicos del empleado,
 * su relación con el objeto {@link Departamento} y el formato de salida de texto.
 */
public class EmpleadoTest {
    /**
     * Prueba que verifica el formato de salida del metodo {@code toString()}.
     * Asegura que la cadena generada contenga de forma estructurada
     * el nombre completo del empleado, su identificador único (ID) y su correo corporativo.
     */
    @Test
    public void testToStringFormatoCorrecto() {

        Departamento departamento = new Departamento("Informatica");
        Empleado empleado = new Empleado("Carlos", "Soto", "csoto@udec.cl", "20154321", departamento);

        String resultadoToString = empleado.toString();

        String resultadoEsperado = "Nombre: Carlos Soto | Id:20154321 | Correo: csoto@udec.cl";

        assertEquals(resultadoEsperado, resultadoToString,
                "El metodo toString de Empleado no devuelve el resultado esperado");
    }

    /**
     * Prueba que verifica la asociación entre un Empleado y su Departamento.
     * Comprueba que al inyectar un objeto {@code Departamento} a través del constructor,
     * este se guarde correctamente y pueda ser recuperado mediante el metodo getter respectivo.
     */
    @Test
    public void testAsignacionDeDepartamento() {

        Departamento departamento = new Departamento("Recursos Humanos");
        Empleado empleado = new Empleado("Ana", "Gomez", "ana@empresa.cl", "98765", departamento);

        Departamento deptoAsignado = empleado.getDepartamento();

        // Assert (Comprobar)
        assertEquals(departamento, deptoAsignado,
                "El departamento asignado al empleado no coincide con el entregado en el constructor");
    }
}