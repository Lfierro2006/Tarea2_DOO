package empleado;

import departamento.Departamento;

public class Empleado {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }

    public String getNombre() {return nombre;}
    public String getApellidos(){return apellidos;}
    public String getId(){return id;}
    public String getCorreo(){return correo;}

    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombre()+" "+this.getApellidos()+"\n Id:"+this.getId()+"Correo: "+this.getCorreo();
    }
}
