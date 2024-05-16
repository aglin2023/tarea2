package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**clase que representa a una reunion presencial, extiende la clase abstracta "Reunion" */
public class ReunionPresencial extends Reunion{

    /**variable de tipo String que representa la sala */
    private String sala;

    /**constructor de la clase
     * @param fecha fecha de la reunion
     * @param duracionPrevista la duracion prevista de la reunion
     * @param horaPrevista la hora prevista de la reunion
     * @param sala la sala en donde será la reunion
     * @param t el tipo reunion que será*/
    public ReunionPresencial(Date fecha, Duration duracionPrevista, Instant horaPrevista, String sala,TipoReunion t) {
        super(fecha, duracionPrevista, horaPrevista,t);
        this.sala = sala;
    }
    /**metodo que regresa un String que reprsenta la sala */
    public String getSala(){
        return sala;
    }

    /**metodo que regresa en un String los datos obtenidos de la reunion */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Sala: ").append(sala).append("\n");
        sb.append("Lista de participantes: ").append("\n");
        sb.append(super.getAsistencia().toString());
        if(super.getNotas() != null) {
            int numeroDeNota = 0;
            for(Nota nota : super.getNotas()) {
                sb.append("Nota " + numeroDeNota + ":\n");
                sb.append(nota.toString()).append("\n\n");
            }
        }
        return sb.toString();
    }
}
