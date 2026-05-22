package departamento;
import Persona.Empleado;
import invitable.Invitable;

import java.util.ArrayList;
/**
 * Representa un departamento de la organización.
 */
public class Departamento implements Invitable {
    private final String nombre;
    private final ArrayList<Empleado> trabajadores;
    /**
     * Crea un departamento con su nombre.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre){
        this.nombre=nombre;
        trabajadores=new ArrayList<>();
    }
    /**
     * Obtiene el número total de empleados en el departamento.
     *
     * @return Cantidad de trabajadores.
     */
    public int obtenerCantidadEmpleados(){
        return trabajadores.size();
    }
    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado El trabajador a añadir.
     */
    public void addEmpleado(Empleado empleado){
        trabajadores.add(empleado);
    }
    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return Lista de trabajadores.
     */
    public ArrayList<Empleado> getEmpleados(){return trabajadores;}
    /**
     * Invita a todos los empleados del departamento.
     */
    @Override
    public void invitar(){
        for(Empleado empleado : trabajadores){
            empleado.invitar();
        }
    }
    /**
     * Devuelve el nombre del departamento y la cantidad de empleados.
     *
     * @return Cadena descriptiva del departamento.
     */
    @Override
    public String toString(){
        return "Departamento: "+this.getNombre()+" \nCantidad de empleados: "+this.obtenerCantidadEmpleados()+"\n";
    }
}