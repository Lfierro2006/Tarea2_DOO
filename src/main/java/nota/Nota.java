package nota;

import java.time.Instant;
/**
 * Representa un apunte o nota tomada durante una reunión.
 */
public class Nota{
    private final String nota;
    private final Instant hora;
    /**
     * Crea una nueva nota y registra la hora actual automáticamente.
     *
     * @param nota El contenido de la nota.
     */
    public Nota(String nota){
        this.nota=nota;
        this.hora=Instant.now();
    }
    /**
     * Obtiene el contenido de la nota.
     *
     * @return El texto de la nota.
     */
    public String getNota(){
        return nota;
    }
    /**
     * Obtiene la hora en la que se registró la nota.
     *
     * @return La marca de tiempo de creación.
     */
    public Instant getHora(){
        return hora;
    }
    /**
     * Devuelve el contenido de la nota formateado con su hora de creación.
     *
     * @return Cadena con la hora y el texto de la nota.
     */
    @Override
    public String toString(){
        return "["+this.getHora()+"] "+ this.getNota();
    }
}