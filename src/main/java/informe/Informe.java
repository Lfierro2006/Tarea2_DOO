package informe;

import reunion.Reunion;
import reunion.ReunionPresencial;
import reunion.ReunionVirtual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Genera un archivo de texto con el reporte detallado de una reunión.
 */
public class Informe {
    private Reunion reunion;
    private String nombreInforme;
    /**
     * Crea un informe y genera automáticamente el nombre del archivo.
     *
     * @param reunion La reunión que se va a documentar.
     */
    public Informe(Reunion reunion){
        this.reunion=reunion;
        this.nombreInforme="Reunion-"+reunion.getOrganizador().getNombreCompleto().replace(" ","_")+"-"+reunion.getFecha().toString().replace(" ","_").replace(":","-")+".txt";
    }
    /**
     * Escribe y guarda todos los datos de la reunión en un archivo de texto (.txt).
     * Incluye información como asistencia, horarios, notas y tipo de reunión.
     */
    public void generarInforme(){
        try {
            PrintWriter informe=new PrintWriter(nombreInforme);
            informe.println("========================================INFORME REUNION========================================");
            informe.println("Se organizó una reunion del tipo "+reunion.getTipo()+" el dia "+reunion.getFecha()+" a las "+reunion.getHoraPrevista());
            informe.println("-Organizada por: "+reunion.getOrganizador());
            informe.println("-Se inició a las "+reunion.getHoraInicio()+" y termino a las "+reunion.getHoraFinal()+" durando "+reunion.calcularTiempoReal()+" horas");
            if(reunion.getClass()== ReunionPresencial.class){
                informe.println("-Se hizo en la sala "+((ReunionPresencial)reunion).getSala());
            }else{
                informe.println("-Se hizo en el enlace "+((ReunionVirtual)reunion).getLink());
            }
            informe.println("-Se invitó a:\n "+reunion.getInvitaciones());
            informe.println("-Asistieron "+reunion.obtenerTotalAsistencia()+"("+reunion.obtenerPorcentajeAsistencia()+"%)"+":\n "+reunion.obtenerAsistencias());
            informe.println("-Faltaron:\n "+reunion.obtenerAusencias());
            informe.println("-Notas hechas en la reunion:\n "+reunion.getNotas());
            informe.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Devuelve un mensaje con el nombre del archivo del informe.
     *
     * @return Cadena descriptiva con el nombre del archivo.
     */
    @Override
    public String toString(){
        return "El informe se llama: "+this.nombreInforme;
    }
}
