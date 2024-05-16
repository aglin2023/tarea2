package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
/**clase que representa a una reunion presencial, extiende la clase abstracta "Reunion" */
public class ReunionPresencial extends Reunion{

    /**variable de tipo String que representa la sala */
    private String sala;
    private int numeroDeNota = 1;

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
        ArrayList<Empleado> listaParticipantes = super.getAsistencia().getListaInvitados();
        for(int i = 0; i < listaParticipantes.size(); i++){
            if(super.getAsistencia().getListaHoraDeLlegada().get(i)!=null && super.getAsistencia().getListaHoraDeLlegada().get(i).isAfter(super.getAsistencia().getHoraPrevista())){
                sb.append(listaParticipantes.get(i).toString());
                sb.append(super.getAsistencia().getListaHoraDeLlegada().get(i)).append(" Llegó con retraso");
            } else if (super.getAsistencia().getListaHoraDeLlegada().get(i) == null) {
                continue;
            } else {
                sb.append(listaParticipantes.get(i).toString());
                sb.append(super.getAsistencia().getListaHoraDeLlegada().get(i));
            }
            sb.append("\n");
        }
        if(super.getNotas() != null) {
            for(Nota nota : super.getNotas()) {
                sb.append("Nota " + numeroDeNota + ":\n");
                sb.append(nota.toString()).append("\n");
                numeroDeNota++;
            }
        }
        return sb.toString();
    }
}
