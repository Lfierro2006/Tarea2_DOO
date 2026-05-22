package excepciones;

public class AsistenciaDuplicadaException extends RuntimeException {
    public AsistenciaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}