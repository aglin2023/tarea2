package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    Date fecha = new Date(2024, 5, 15);
    Duration duracionPrevista = Duration.ofMinutes(60);
    Instant horaPrevista = Instant.parse("2024-05-15T18:00:00Z");

    @Test
    void invitar() {
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha,duracionPrevista,horaPrevista, "A9" ,TipoReunion.MARKETING);
        Empleado empleado1 = new Empleado("nombre1", "apellido1", "correo1", "id1");
        Empleado empleado2 = new Empleado("nombre1", "apellido1", "correo1", "id1");

        empleado1.Invitar(reunionPresencial);
        empleado1.Invitar(reunionPresencial);
        empleado2.Invitar(reunionPresencial);

        assertEquals(2,reunionPresencial.getInvitacion().getListaInvitados().size());
    }
}