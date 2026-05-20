package departamento;
import empleado.Empleado;

import java.util.ArrayList;

public class Departamento {
    private final String nombre;
    private ArrayList<Empleado> trabajadores;

    public Departamento(String nombre){
        this.nombre=nombre;
        trabajadores=new ArrayList<>();
    }
    public int obtenerCantidadEmpleados(){
        return trabajadores.size();
    }

    public String getNombre(){
        return nombre;
    }

    public void addEmpleado(Empleado empleado){
        trabajadores.add(empleado);
    }
    public ArrayList<Empleado> getEmpleados(){return trabajadores;}

    @Override
    public String toString(){
        return "Departamento: "+this.getNombre()+" "+this.obtenerCantidadEmpleados();
    }
}