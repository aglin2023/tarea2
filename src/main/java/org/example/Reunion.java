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
    private ArrayList<Empleado> listaInvitable;
    private ArrayList<Empleado> listaInvitados;
    private Asistencia asistencia;
    private Empleado organizador;
    private Retraso retraso;


    public Reunion(Date fecha, Duration duracionPrevista, Instant horaPrevista){
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
        this.horaPrevista = horaPrevista;
        this.listaInvitable = new ArrayList<Empleado>();
        this.listaInvitados = new ArrayList<Empleado>();
        this.organizador = new Empleado();

    }

    public ArrayList obtenerAsistencias(){
        return asistencia.getObtenerAsistencia();
    }
    public ArrayList obtenerAusencias(){
        return asistencia.getListaDeAusencias();
    }
    public ArrayList obtenerRetrasos(){
        return retraso.getListaDeRetrasos();
    }
    public int obtenerTotalAsistencias(){
        return asistencia.getListaDeAsistencias().size();
    }
    public float obtenerPorcentajeAsistencia(){
        return (float)obtenerTotalAsistencias() * 100 / (float)listaInvitable.size();
    }
    public float calcularTiempoReal(Instant horaInicio, Instant horaFin){
        Duration tiempoReal = Duration.between(horaInicio, horaFin);
        return (float)tiempoReal.toMinutes();
    }
    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFin = Instant.now();
    }
    public ArrayList<Empleado> listaInvitable(ArrayList<Departamento> departamentos){
        for(Departamento departamento : departamentos) {
            ArrayList<Empleado> listaEmpleados = departamento.ListaEmpleados();
            for (Empleado empleado : listaEmpleados) {
                listaInvitable.add(empleado);
            }
        }
        return listaInvitable;
    }

    public ArrayList<Empleado> getListaInvitable() {
        return listaInvitable;
    }
    public void setlistaInvitados(ArrayList<Empleado> listaInvitable){
        listaInvitados.add(organizador.invitar(ListaInvitable));
    }
    public ArrayList<Empleado> getListaInvitados() {
        return listaInvitados;
    }
    public void setAsistencia(){
        this.asistencia = new Asistencia(listaInvitados, horaPrevista);
    }
    public void setRetraso() {
        this.retraso = new Retraso(listaInvitados, horaPrevista);
    }
    public ArrayList<Empleado> getListaInvitados(){
        return listaInvitados;
    }
}
