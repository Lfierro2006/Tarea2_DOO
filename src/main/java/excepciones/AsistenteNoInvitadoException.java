package excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta registrar la asistencia
 * de una persona que no figura en la lista oficial de invitaciones de la reunión.
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) diseñada para prevenir el registro de asistentes no autorizados.
 */
public class AsistenteNoInvitadoException extends RuntimeException {
    /**
     * Construye una nueva excepción de asistente no invitado con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica por qué se lanzó la excepción.
     */
    public AsistenteNoInvitadoException(String mensaje) {
        super(mensaje);
    }
}