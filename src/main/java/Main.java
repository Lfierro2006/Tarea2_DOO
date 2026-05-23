import Persona.Empleado;
import Persona.PGenerico;
import departamento.Departamento;
import invitacion.Invitacion;
import reunion.Reunion;
import reunion.ReunionVirtual;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Crear departamentos
        Departamento deptoTI = new Departamento("Tecnología");
        Departamento deptoMarketing = new Departamento("Marketing");
        Departamento deptoFinanzas = new Departamento("Finanzas");

        // 2. Crear empleados
        Empleado organizador = new Empleado("Ana", "Rojas", "arojas@empresa.cl", "E01", deptoTI);
        Empleado emp1 = new Empleado("Juan", "Lopez", "jlopez@empresa.cl", "E02", deptoTI);
        Empleado emp2 = new Empleado("Maria", "Gomez", "mgomez@empresa.cl", "E03", deptoTI);
        Empleado emp3 = new Empleado("Carlos", "Perez", "cperez@empresa.cl", "E04", deptoMarketing);
        Empleado emp4 = new Empleado("Sofia", "Castro", "scastro@empresa.cl", "E05", deptoMarketing);
        Empleado emp5 = new Empleado("Luis", "Martinez", "lmartinez@empresa.cl", "E06", deptoFinanzas);
        Empleado emp6 = new Empleado("Valentina", "Soto", "vsoto@empresa.cl", "E07", deptoFinanzas);

        // 3. Agregar empleados a departamentos
        deptoTI.addEmpleado(organizador);
        deptoTI.addEmpleado(emp1);
        deptoTI.addEmpleado(emp2);
        deptoMarketing.addEmpleado(emp3);
        deptoMarketing.addEmpleado(emp4);
        deptoFinanzas.addEmpleado(emp5);
        deptoFinanzas.addEmpleado(emp6);

        // 4. Crear invitados externos
        PGenerico externo1 = new PGenerico("Pedro", "Nunez", "pedro@gmail.com");
        PGenerico externo2 = new PGenerico("Laura", "Vidal", "laura@outlook.com");

        // 5. Crear invitaciones
        Instant horaCitacion = Instant.now().plusSeconds(30);
        List<Invitacion> invitaciones = new ArrayList<>();
        invitaciones.add(new Invitacion(emp1, horaCitacion));
        invitaciones.add(new Invitacion(emp2, horaCitacion));
        invitaciones.add(new Invitacion(emp3, horaCitacion));
        invitaciones.add(new Invitacion(emp4, horaCitacion));
        invitaciones.add(new Invitacion(emp5, horaCitacion));
        invitaciones.add(new Invitacion(emp6, horaCitacion));
        invitaciones.add(new Invitacion(externo1, horaCitacion));
        invitaciones.add(new Invitacion(externo2, horaCitacion));

        // 6. Crear reunion virtual
        ReunionVirtual reunion = new ReunionVirtual(
                organizador,
                "https://zoom.us/j/987654321",
                new Date(),
                horaCitacion,
                Duration.ofHours(2),
                Reunion.tipoReunion.MARKETING,
                invitaciones
        );

        // 7. Iniciar reunion
        reunion.iniciar();
        System.out.println("Reunion iniciada: " + reunion);

        // 8. Registrar asistencias
        // puntuales
        reunion.registrarAsistencia(emp1, Instant.now());
        reunion.registrarAsistencia(emp3, Instant.now());
        reunion.registrarAsistencia(emp5, Instant.now());
        reunion.registrarAsistencia(externo1, Instant.now());

        // con retraso
        reunion.registrarAsistencia(emp2, Instant.now().plusSeconds(60));
        reunion.registrarAsistencia(emp4, Instant.now().plusSeconds(120));

        // emp6 y externo2 no asisten (ausentes)

        // 9. Agregar notas
        reunion.nuevaNota("Se presentó el plan de marketing para Q3.");
        reunion.nuevaNota("Finanzas aprobó el presupuesto preliminar.");
        reunion.nuevaNota("TI confirmó el desarrollo del nuevo módulo.");
        reunion.nuevaNota("Próxima reunión en 15 días.");

        // 10. Finalizar reunion
        reunion.finalizar();
        System.out.println("Reunion finalizada.");

        // 11. Mostrar estadisticas
        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Total invitados: " + reunion.getInvitaciones().size());
        System.out.println("Total asistentes: " + reunion.obtenerTotalAsistencia());
        System.out.println("Porcentaje asistencia: " + reunion.obtenerPorcentajeAsistencia() + "%");
        System.out.println("Retrasos: " + reunion.obtenerRetrasos().size());
        System.out.println("Ausentes: " + reunion.obtenerAusencias().size());
        System.out.println("Tiempo real: " + reunion.calcularTiempoReal() + " horas");

        // 12. Generar informe
        reunion.generarInforme();
        System.out.println("\nInforme generado exitosamente.");
    }
}