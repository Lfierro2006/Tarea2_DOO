package excepciones;

public class DatosIncompletosException extends RuntimeException {
    public DatosIncompletosException(String mensaje) {
        super(mensaje);
    }
}