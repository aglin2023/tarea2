package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Duration duracionPrevista, Instant horaPrevista, String enlace,TipoReunion t) {
        super(fecha, duracionPrevista, horaPrevista,t);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Enlace: ").append(enlace).append("\n");
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
