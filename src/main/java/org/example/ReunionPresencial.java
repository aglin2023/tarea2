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
}
