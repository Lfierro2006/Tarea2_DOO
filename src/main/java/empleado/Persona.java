package empleado;

import invitable.Invitable;

abstract class Persona implements Invitable{
    private String apellidos;
    private String nombre;
    private String correo;
    public Persona(String nombre, String apellidos, String correo){
        this.nombre= nombre;
        this.apellidos= apellidos;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombre()+" "+this.getApellidos()+ "\n" + "Correo: "+this.getCorreo();
    }
}

