//import empleado.Empleado;
//import reunion.Reunion;
import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.*;

public class Main {
    public static void main(String[] args){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime Hora=LocalTime.now();
        String hora= Hora.format(formatter);
        System.out.println(hora);
    }
}