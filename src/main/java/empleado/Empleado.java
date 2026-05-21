package empleado;

import departamento.Departamento;

public class Empleado extends Persona {
    private final String id;
    private final Departamento departamento;
    public Empleado(String nombre, String apellidos, String correo, String id,Departamento departamento){
        super(nombre, apellidos, correo);
        this.id=id;
        this.departamento=departamento;
    }
    public Departamento getDepartamento(){return departamento;}
    public String getId(){return id;}

    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombre()+" "+this.getApellidos()+"\n Id:"+this.getId()+"Correo: "+this.getCorreo();
    }
}
