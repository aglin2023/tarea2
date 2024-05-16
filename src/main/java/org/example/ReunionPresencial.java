package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;
    private int numeroDeNota = 1;

    public ReunionPresencial(Date fecha, Duration duracionPrevista, Instant horaPrevista, String sala,TipoReunion t) {
        super(fecha, duracionPrevista, horaPrevista,t);
        this.sala = sala;
    }
    public String getSala(){
        return sala;
    }

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
