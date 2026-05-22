package Persona;

import invitable.Invitable;
/**
 * Representa una persona genérica que puede ser invitada a una reunión.
 */
public abstract class Persona implements Invitable{
    private final String apellidos;
    private final String nombre;
    private final String correo;
    /**
     * Crea una nueva persona.
     *
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param correo    El correo electrónico de la persona.
     */
    public Persona(String nombre, String apellidos, String correo){
        this.nombre= nombre;
        this.apellidos= apellidos;
        this.correo = correo;
    }
    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Obtiene el nombre y los apellidos concatenados con un espacio.
     *
     * @return El nombre completo.
     */
    public String getNombreCompleto(){
        return nombre+" "+apellidos;
    }
    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Imprime por consola un mensaje indicando que la persona ha sido invitada.
     */
    @Override
    public void invitar(){
        System.out.println(getNombre()+" "+getApellidos()+" ("+getCorreo()+") ha sido invitado");
    }
    /**
     * Compara esta persona con otro objeto basándose en la igualdad de sus correos electrónicos.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si son la misma persona o comparten el mismo correo, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona other = (Persona) obj;
        return this.correo.equals(other.correo);
    }
    /**
     * Devuelve los datos de la persona en formato de texto.
     *
     * @return Cadena con el nombre completo y el correo.
     */
    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombreCompleto()+"\n" + "Correo: "+this.getCorreo();
    }
}