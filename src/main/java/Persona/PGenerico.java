package Persona;
/**
 * Representa un invitado genérico o externo a la organización.
 */
public class PGenerico extends Persona{
    /**
     * Crea un nuevo invitado genérico.
     *
     * @param nombre    El nombre del invitado.
     * @param apellidos Los apellidos del invitado.
     * @param correo    El correo electrónico del invitado.
     */
    public PGenerico(String nombre, String apellidos, String correo){
        super(nombre, apellidos, correo);
    }
    /**
     * Devuelve los datos del invitado en formato de texto.
     *
     * @return Cadena con el nombre completo y el correo.
     */
    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombreCompleto()+ "\n" + "Correo: "+this.getCorreo();
    }
}
