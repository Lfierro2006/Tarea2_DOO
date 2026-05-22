package excepciones;
/**
 * Excepción personalizada que se lanza cuando un invitado intenta registrar
 * su asistencia a una reunión en la que ya había sido registrado previamente.
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) que detiene la ejecución si no es capturada.
 */
public class AsistenciaDuplicadaException extends RuntimeException {
    /**
     * Construye una nueva excepción de asistencia duplicada con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica por qué se lanzó la excepción.
     */
    public AsistenciaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}