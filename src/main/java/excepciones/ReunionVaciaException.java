package excepciones;
/**
 * Excepción personalizada que se lanza cuando se intenta realizar una operación
 * matemática o estadística sobre una reunión que no tiene invitados registrados
 * Hereda de {@link RuntimeException}, por lo que es una excepción no comprobada
 * (unchecked) diseñada para proteger la lógica de negocio frente a colecciones vacías.
 */
public class ReunionVaciaException extends RuntimeException {
    /**
     * Construye una nueva excepción de reunión vacía con el mensaje
     * de error especificado.
     * @param mensaje El detalle del error que explica la operación que falló debido a la falta de invitados.
     */
    public ReunionVaciaException(String mensaje) {
        super(mensaje);
    }
}