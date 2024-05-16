package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DuracionNegativaTest {

    @Test
    void main() {
        Empleado organizador = new Empleado("nombre", "apellido", "correo", "id");
        Departamento departamento1 = new Departamento("departamento1");
        Empleado empleado1 = new Empleado("nombre1", "apellido1", "correo1", "id1");
        Empleado empleado2 = new Empleado("nombre2", "apellido2", "correo2", "id2");
        Departamento departamento2 = new Departamento("departamento2");
        Empleado empleado3 = new Empleado("nombre3", "apellido3", "correo3", "id3");
        Empleado empleado4 = new Empleado("nombre4", "apellido4", "correo4", "id4");
        departamento1.AgregarEmpleados(empleado1);
        departamento1.AgregarEmpleados(empleado2);
        departamento2.AgregarEmpleados(empleado3);
        departamento2.AgregarEmpleados(empleado4);
//        departamento1.AgregarEmpleados(empleado3);
        Date fecha = new Date(2024, 5, 15);
        Duration duracionPrevista = Duration.ofMinutes(60);
        Instant horaPrevista = Instant.parse("2024-05-15T18:00:00Z");
        ReunionVirtual reunionVirtual = new ReunionVirtual(fecha,duracionPrevista,horaPrevista, "www.hola@gmail.com" ,TipoReunion.MARKETING);


        departamento1.Invitar(reunionVirtual);
        departamento2.Invitar(reunionVirtual);
        empleado1.Invitar(reunionVirtual);
        departamento1.Invitar(reunionVirtual);
        reunionVirtual.agregarNotas("PROBANDO NOTA 123");
        reunionVirtual.agregarNotas("ESTA ES UNA NOTA 2");
        reunionVirtual.cambiarNotas(2, "ESTA NOTA 2 CAMBIADA");

        Asistencia asistencia = reunionVirtual.getAsistencia();
        Retraso retraso = reunionVirtual.getRetraso();
        asistencia.setHoraDeLlegada(Instant.parse("2024-05-15T20:00:00Z"));
        for(int i = 1; i < reunionVirtual.invitacion.getListaInvitados().size(); i++) {
            asistencia.setHoraDeLlegada(null);
        }
        reunionVirtual.iniciar();
        reunionVirtual.setHoraFin(Instant.parse("2024-05-16T15:35:35.393686900Z"));
        ArrayList asistencias = reunionVirtual.obtenerAsistencias();
        ArrayList retrasos = reunionVirtual.obtenerRetrasos();
        ArrayList ausencias = reunionVirtual.obtenerAusencias();
        String t =  reunionVirtual.toString();
        assertEquals("Error duracion negativa\n",t);

    }
}