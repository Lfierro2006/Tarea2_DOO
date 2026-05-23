package Persona;

import departamento.Departamento;
/**
 * Representa un empleado dentro de la organización.
 */
public class Empleado extends Persona {
    private final String id;
    private final Departamento departamento;
    /**
     * Crea un nuevo empleado.
     *
     * @param nombre       El nombre del empleado.
     * @param apellidos    Los apellidos del empleado.
     * @param correo       El correo electrónico.
     * @param id           El identificador único del empleado.
     * @param departamento El departamento al que pertenece.
     */
    public Empleado(String nombre, String apellidos, String correo, String id,Departamento departamento){
        super(nombre, apellidos, correo);
        this.id=id;
        this.departamento=departamento;
    }
    /**
     * Obtiene el departamento al que pertenece el empleado.
     *
     * @return El departamento.
     */
    public Departamento getDepartamento(){return departamento;}
    /**
     * Obtiene el identificador único del empleado.
     *
     * @return El ID del empleado.
     */
    public String getId(){return id;}
    /**
     * Devuelve los datos del empleado en formato de texto.
     *
     * @return Cadena con el nombre completo, ID y correo.
     */
    @Override
    public String toString(){
        return "Nombre: "+this.getNombreCompleto()+" | Id:"+this.getId()+" | Correo: "+this.getCorreo();
    }
}
