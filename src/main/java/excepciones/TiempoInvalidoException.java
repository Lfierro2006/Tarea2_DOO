package excepciones;

public class TiempoInvalidoException extends RuntimeException {
    public TiempoInvalidoException(String mensaje) {
        super(mensaje);
    }
}