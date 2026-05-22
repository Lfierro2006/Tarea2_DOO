package excepciones;

public class AsistenteNoInvitadoException extends RuntimeException {
    public AsistenteNoInvitadoException(String mensaje) {
        super(mensaje);
    }
}