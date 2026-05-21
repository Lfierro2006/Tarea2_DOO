package Persona;

import invitable.Invitable;

abstract class Persona implements Invitable{
    private final String apellidos;
    private final String nombre;
    private final String correo;
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
    public String getNombreCompleto(){
        return nombre+" "+apellidos;
    }
    public String getCorreo() {
        return correo;
    }

    @Override
    public void invitar(){
        System.out.println(getNombre()+" "+getApellidos()+" ("+getCorreo()+") ha sido invitado");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona other = (Persona) obj;
        return this.correo.equals(other.correo);
    }

    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombreCompleto()+"\n" + "Correo: "+this.getCorreo();
    }
}