package empleado;

import departamento.Departamento;

public class Empleado extends Persona {
    private String id;


    public Empleado(String nombre, String apellidos, String correo, String id){
        super(nombre, apellidos, correo);
        this.id=id;

    }

    public String getId(){return id;}


    @Override
    public String toString(){
        return "Nombre completo: "+this.getNombre()+" "+this.getApellidos()+"\n Id:"+this.getId()+"Correo: "+this.getCorreo();
    }
}
