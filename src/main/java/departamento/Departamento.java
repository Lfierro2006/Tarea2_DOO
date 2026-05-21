package departamento;
import Persona.Empleado;
import invitable.Invitable;

import java.util.ArrayList;

public class Departamento implements Invitable {
    private final String nombre;
    private final ArrayList<Empleado> trabajadores;

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
    public void invitar(){
        for(Empleado empleado : trabajadores){
            empleado.invitar();
        }
    }

    @Override
    public String toString(){
        return "Departamento: "+this.getNombre()+" \nCantidad de empleados: "+this.obtenerCantidadEmpleados()+"\n";
    }
}