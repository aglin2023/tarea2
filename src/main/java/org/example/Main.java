package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
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
        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha,duracionPrevista,horaPrevista, "A9" ,TipoReunion.MARKETING);


        departamento1.Invitar(reunionPresencial);
        departamento2.Invitar(reunionPresencial);
        empleado1.Invitar(reunionPresencial);
        departamento1.Invitar(reunionPresencial);
        reunionPresencial.agregarNotas("PROBANDO NOTA 123");
        reunionPresencial.agregarNotas("ESTA ES UNA NOTA 2");
        reunionPresencial.cambiarNotas(2, "ESTA NOTA 2 CAMBIADA");

        Asistencia asistencia = reunionPresencial.getAsistencia();
        Retraso retraso = reunionPresencial.getRetraso();
        asistencia.setHoraDeLlegada(Instant.parse("2024-05-15T20:00:00Z"));
        for(int i = 1; i < reunionPresencial.invitacion.getListaInvitados().size(); i++) {
            asistencia.setHoraDeLlegada(null);
        }
        reunionPresencial.iniciar();
        reunionPresencial.setHoraFin(Instant.parse("2024-05-15T23:38:41.78865953Z"));
        ArrayList asistencias = reunionPresencial.obtenerAsistencias();
        ArrayList retrasos = reunionPresencial.obtenerRetrasos();
        ArrayList ausencias = reunionPresencial.obtenerAusencias();
        System.out.println(reunionPresencial.toString());
//        System.out.println(retraso.toString());
        System.out.println(asistencia.toString());
    }
}
