package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class DepartamentoTest {

    Date fecha = new Date(2024, 5, 15);
    Duration duracionPrevista = Duration.ofMinutes(60);
    Instant horaPrevista = Instant.parse("2024-05-15T18:00:00Z");
    Departamento departamento1 = new Departamento("departamento1");
    Empleado empleado1 = new Empleado("nombre1", "apellido1", "correo1", "id1");
    Empleado empleado2 = new Empleado("nombre2", "apellido2", "correo2", "id2");
    Departamento departamento2 = new Departamento("departamento2");
    Empleado empleado3 = new Empleado("nombre3", "apellido3", "correo3", "id3");
    Empleado empleado4 = new Empleado("nombre4", "apellido4", "correo4", "id4");

    @Test
    void tamañoListaEmpleados() {
        departamento1.AgregarEmpleados(empleado1);
        departamento1.AgregarEmpleados(empleado2);
        departamento1.AgregarEmpleados(empleado3);
        departamento1.AgregarEmpleados(empleado4);
        departamento1.AgregarEmpleados(empleado1);
        departamento1.AgregarEmpleados(empleado1);
        departamento1.AgregarEmpleados(empleado1);

        assertEquals(4,departamento1.TamañoListaEmpleados());
    }

    @Test
    void invitarDepartamentoyRepetirEmpleado() {
        departamento1.AgregarEmpleados(empleado1);
        departamento1.AgregarEmpleados(empleado2);
        departamento1.AgregarEmpleados(empleado3);
        departamento1.AgregarEmpleados(empleado4);

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha,duracionPrevista,horaPrevista, "A9" ,TipoReunion.MARKETING);
        empleado1.Invitar(reunionPresencial);
        departamento1.Invitar(reunionPresencial);

        assertEquals(4,reunionPresencial.getInvitacion().getListaInvitados().size());
    }
}