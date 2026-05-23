package informe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Persona.Empleado;
import departamento.Departamento;
import invitacion.Invitacion;
import reunion.Reunion;
import reunion.ReunionPresencial;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas unitarias para verificar la generación de archivos de la clase Informe.
 */
class InformeTest {
    private Reunion reunion;
    private Informe informe;
    private String nombreArchivoEsperado;
    @BeforeEach
    void setUp() {
        Departamento depto = new Departamento("TI");
        Empleado organizador = new Empleado("Javier", "Vidal", "jvidal@empresa.com", "E01", depto);

        Empleado invitado = new Empleado("Pepe", "Gomez", "pgomez@empresa.com", "E02", depto);
        List<Invitacion> invitaciones = new ArrayList<>();
        invitaciones.add(new Invitacion(invitado, Instant.now()));

        reunion = new ReunionPresencial(organizador, "Sala A-6", new Date(), Instant.now(), Duration.ofHours(1), Reunion.tipoReunion.TECNICA, invitaciones);

        reunion.iniciar();
        reunion.finalizar();

        informe = new Informe(reunion);

        nombreArchivoEsperado = "Reunion-" + organizador.getNombreCompleto().replace(" ", "_") + "-" + reunion.getFecha().toString().replace(" ", "_").replace(":", "-") + ".txt";
    }

    /**
     * Prueba que genera un informe y comprueba su existencia
     */
    @Test
    void testGenerarInformeCreaArchivoFisico() {
        informe.generarInforme();

        File archivo = new File(nombreArchivoEsperado);
        assertTrue(archivo.exists(), "El archivo del informe .txt debería haberse creado en el disco.");
    }

    @AfterEach
    void tearDown() {
        File archivo = new File(nombreArchivoEsperado);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}