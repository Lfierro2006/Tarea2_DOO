package excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta registrar una magnitud
 * de tiempo ilógica o no permitida por las reglas de negocio
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) diseñada para asegurar la coherencia temporal de los eventos del sistema.
 */
public class TiempoInvalidoException extends RuntimeException {
    /**
     * Construye una nueva excepción de tiempo inválido con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica por qué la magnitud o el rango de tiempo proporcionado es incorrecto.
     */
    public TiempoInvalidoException(String mensaje) {
        super(mensaje);
    }
}