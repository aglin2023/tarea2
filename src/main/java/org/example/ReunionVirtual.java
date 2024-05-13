package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Duration duracionPrevista, Instant horaPrevista, String enlace) {
        super(fecha, duracionPrevista, horaPrevista);
        this.enlace = enlace;
    }

}