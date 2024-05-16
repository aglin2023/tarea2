package org.example;

import org.example.Exception.ReunionException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Date fecha;
    private Duration duracionPrevista;
    private Instant horaPrevista;

    @BeforeEach
    void Setup(){
        fecha = new Date(2024, 5, 15);
        duracionPrevista = Duration.ofMinutes(60);
        horaPrevista = Instant.parse("2024-05-15T18:00:00Z");
    }

    @Test
    void obtenerPorcentajeAsistenciaSINASISTENCIAS() throws Exception {
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha,duracionPrevista,horaPrevista, "A9" ,TipoReunion.MARKETING);
        Empleado empleado1 = new Empleado("nombre1", "apellido1", "correo1", "id1");
        empleado1.Invitar(reunionPresencial);

        assertEquals(0,reunionPresencial.obtenerPorcentajeAsistencia());
    }
    @Test
    void obtenerPorcentajeConCeroInvitaciones() throws Exception{
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha,duracionPrevista,horaPrevista, "A9" ,TipoReunion.MARKETING);
        Exception exception = assertThrows(ReunionException.class,() -> reunionPresencial.obtenerPorcentajeAsistencia());

        String expectedMessage = "División por cero invitados";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }
    @Test
    void obtenerPorcentajeAsistenciaCONASISTENCIAS() throws Exception {
        Departamento departamento1 = new Departamento("departamento1");
        Empleado empleado1 = new Empleado("nombre1", "apellido1", "correo1", "id1");
        departamento1.AgregarEmpleados(empleado1);
//        departamento1.AgregarEmpleados(empleado3);
        Date fecha = new Date(2024, 5, 15);
        Duration duracionPrevista = Duration.ofMinutes(60);
        Instant horaPrevista = Instant.parse("2024-05-15T18:00:00Z");
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, duracionPrevista, horaPrevista, "A9", TipoReunion.MARKETING);

        empleado1.Invitar(reunionPresencial);

        Asistencia asistencia = reunionPresencial.getAsistencia();
        Retraso retraso = reunionPresencial.getRetraso();
        asistencia.setHoraDeLlegada(Instant.parse("2024-05-15T20:00:00Z"));
        for (int i = 1; i < reunionPresencial.invitacion.getListaInvitados().size(); i++) {
            asistencia.setHoraDeLlegada(null);
        }
        reunionPresencial.iniciar();
        reunionPresencial.setHoraFin(Instant.parse("2024-05-15T23:38:41.78865953Z"));

        ArrayList asistencias = reunionPresencial.obtenerAsistencias();
        ArrayList retrasos = reunionPresencial.obtenerRetrasos();
        ArrayList ausencias = reunionPresencial.obtenerAusencias();
        assertEquals(100,reunionPresencial.obtenerPorcentajeAsistencia());
    }

}