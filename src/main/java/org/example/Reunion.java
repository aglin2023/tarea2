package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.ArrayList;

public abstract class Reunion {
    private Date fecha;
    private Duration duracionPrevista;
    private Instant horaPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Asistencia asistencia;
    private Retraso retraso;
    private Invitacion invitacion;
//    private Empleado organizador;


    public Reunion(Date fecha, Duration duracionPrevista, Instant horaPrevista) {
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
        this.horaPrevista = horaPrevista;
        this.invitacion = new Invitacion();
        this.asistencia = new Asistencia(invitacion.getListaInvitados(), horaPrevista);
        this.retraso = new Retraso(invitacion.getListaInvitados(), horaPrevista);
//        this.listaInvitable = new ArrayList<Empleado>();
//        this.listaInvitados = new ArrayList<Empleado>();
//        this.organizador = new Empleado();
    }

    public ArrayList obtenerAsistencias() {
        return asistencia.getObtenerAsistencia();
    }

    public ArrayList obtenerAusencias() {
        return asistencia.getListaDeAusencias();
    }

    public ArrayList obtenerRetrasos() {
        return retraso.getListaDeRetrasos();
    }

    public int obtenerTotalAsistencias() {
        return asistencia.getListaDeAsistencias().size();
    }

    public float obtenerPorcentajeAsistencia() {
        return (float) obtenerTotalAsistencias() * 100 / (float) invitacion.getListaInvitados().size();
    }

    public float calcularTiempoReal(Instant horaInicio, Instant horaFin) {
        Duration tiempoReal = Duration.between(horaInicio, horaFin);
        return (float) tiempoReal.toMinutes();
    }

    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    public void finalizar() {
        this.horaFin = Instant.now();
    }

//    public ArrayList<Empleado> listaInvitable(ArrayList<Departamento> departamentos) {
//        for (Departamento departamento : departamentos) {
//            ArrayList<Empleado> listaEmpleados = departamento.getListaEmpleados();
//            for (Empleado empleado : listaEmpleados) {
//                listaInvitable.add(empleado);
//            }
//        }
//        return listaInvitable;
//    }

//    public ArrayList<Empleado> getListaInvitados() {
//        return listaInvitados;
//    }

//    public void setAsistencia() {
//        this.asistencia = new Asistencia(invitacion.getListaInvitados(), horaPrevista);
//    }
//
//    public void setRetraso() {
//        this.retraso = new Retraso(invitacion.getListaInvitados(), horaPrevista);
//    }
}
