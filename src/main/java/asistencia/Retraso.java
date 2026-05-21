package asistencia;

public class Retraso {
import invitable.Invitable;

import java.time.Instant;

public class Retraso extends Asistencia {
    public Retraso(Invitable invitado, Instant horaLlegada){
        super(invitado,horaLlegada);
    }
}
