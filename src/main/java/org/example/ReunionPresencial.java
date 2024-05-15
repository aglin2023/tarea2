package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;

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
