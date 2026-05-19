package reunion;

import empleado.Empleado;

public class ReunionVirtual extends Reunion {
    private String link;
    public ReunionVirtual(String link, Empleado organizador){
        this.link=link;
        super(organizador);
    }
}
