package reunion;

import empleado.Empleado;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(String sala, Empleado organizador){
        this.sala=sala;
        super(organizador);
    }
    public String getSala() {
        return ubicacion;
    }

}