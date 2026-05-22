package empleado;

import Persona.Empleado;
import departamento.Departamento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmpleadoTest {

    @Test
    public void testToStringFormatoCorrecto() {

        Departamento departamento = new Departamento("Informatica");
        Empleado empleado = new Empleado("Carlos", "Soto", "csoto@udec.cl", "20154321", departamento);

        String resultadoToString = empleado.toString();

        String resultadoEsperado = "Nombre completo: Carlos Soto\n Id:20154321\n Correo: csoto@udec.cl";

        assertEquals(resultadoEsperado, resultadoToString,
                "El metodo toString de Empleado no devuelve el resultado esperado");
    }

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