package informe;

import reunion.Reunion;
import reunion.ReunionPresencial;
import reunion.ReunionVirtual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Informe {
    private Reunion reunion;
    private String nombreInforme;
    public Informe(Reunion reunion){
        this.reunion=reunion;
        this.nombreInforme="Reunion-"+reunion.getOrganizador().getNombreCompleto().replace(" ","_")+"-"+reunion.getFecha()+".txt";
    }
    public void generarInforme(){
        try {
            PrintWriter informe=new PrintWriter(nombreInforme);
            informe.println("========================================INFORME REUNION========================================");
            informe.println("Se organizó una reunion del tipo "+reunion.getTipo()+" el dia "+reunion.getFecha()+"a las"+reunion.getHoraPrevista());
            informe.println("-Organizada por: \n"+reunion.getOrganizador());
            informe.println("-Se inició a las "+reunion.getHoraInicio()+" y termino a las "+reunion.getHoraFinal()+" durando "+reunion.calcularTiempoReal());
            if(reunion.getClass()== ReunionPresencial.class){
                informe.println("-Se hizo en la sala\n "+((ReunionPresencial)reunion).getSala());
            }else{
                informe.println("-Se hizo en el enlace "+((ReunionVirtual)reunion).getLink());
            }
            informe.println("-Se invitó a:\n "+reunion.getInvitaciones());
            informe.println("-Asistieron "+reunion.obtenerTotalAsistencia()+"("+reunion.obtenerPorcentajeAsistencia()+")"+":\n "+reunion.obtenerAsistencias());
            informe.println("-Falataron:\n "+reunion.obtenerAusencias());
            informe.println("-Notas hechas en la reunion:\n "+reunion.getNotas());
            informe.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString(){
        return "El informe se llama: "+this.nombreInforme;
    }
}
