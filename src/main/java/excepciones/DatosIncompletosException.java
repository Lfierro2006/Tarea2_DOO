package excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta instanciar o
 * procesar un objeto careciendo de la información obligatoria mínima
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) diseñada para proteger la integridad de los datos del sistema.
 */
public class DatosIncompletosException extends RuntimeException {
    /**
     * Construye una nueva excepción de datos incompletos con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica qué dato vital falta o fue detectado como nulo.
     */
    public DatosIncompletosException(String mensaje) {
        super(mensaje);
    }
}