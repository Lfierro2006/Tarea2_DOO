package excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta realizar una operación
 * incompatible con el estado actual de la reunión
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) diseñada para mantener la coherencia lógica en el ciclo de vida de la reunión.
 */
public class ReunionEstadoException extends RuntimeException {
    /**
     * Construye una nueva excepción de estado de reunión con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica la incongruencia detectada en el estado actual.
     */
    public ReunionEstadoException(String mensaje) {
        super(mensaje);
    }
}