package Persona;

public class PGenerico extends Persona{
    public PGenerico(String nombre, String apellidos, String correo){
        super(nombre, apellidos, correo);
    }

    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombreCompleto()+ "\n" + "Correo: "+this.getCorreo();
    }
}
