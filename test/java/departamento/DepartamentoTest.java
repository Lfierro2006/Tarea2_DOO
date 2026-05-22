package departamento;

import Persona.Empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    public void testAddEmpleadoYObtenerCantidad() {
        Departamento depto = new Departamento("Ventas");

        assertEquals(0, depto.obtenerCantidadEmpleados(), "El departamento debe iniciar con 0 empleados.");

        Empleado emp1 = new Empleado("Juan", "Perez", "juan@udec.cl", "111", depto);
        Empleado emp2 = new Empleado("Maria", "Gomez", "maria@udec.cl", "222", depto);

        depto.addEmpleado(emp1);
        depto.addEmpleado(emp2);

        assertEquals(2, depto.obtenerCantidadEmpleados(), "La cantidad de empleados debería ser 2 tras agregar dos trabajadores.");
    }

    @Test
    public void testToStringFormatoCorrecto() {
        Departamento depto = new Departamento("Recursos Humanos");

        Empleado emp = new Empleado("Ana", "Soto", "ana@udec.cl", "333", depto);
        depto.addEmpleado(emp);

        String resultadoToString = depto.toString();
        String resultadoEsperado = "Departamento: Recursos Humanos \nCantidad de empleados: 1\n";

        assertEquals(resultadoEsperado, resultadoToString,
                "metodo toString de Departamento no devuelve el resultado esperado.");
    }
}