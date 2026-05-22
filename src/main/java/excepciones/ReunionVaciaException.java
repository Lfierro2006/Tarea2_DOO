package excepciones;

public class ReunionVaciaException extends RuntimeException {
    public ReunionVaciaException(String mensaje) {
        super(mensaje);
    }
}