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
    protected Invitacion invitacion;
    private TipoReunion tipoReunion; 
    private ArrayList<Nota> notas;


    public Reunion(Date fecha, Duration duracionPrevista, Instant horaPrevista, TipoReunion t) {
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
        this.horaPrevista = horaPrevista;
        this.invitacion = new Invitacion();
        this.asistencia = new Asistencia(invitacion.getListaInvitados(), horaPrevista);
        this.retraso = new Retraso(invitacion.getListaInvitados(), horaPrevista);
	    this.tipoReunion = t;
        this.notas = new ArrayList<>();
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

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void agregarNotas(String apunte){
        Nota nota = new Nota(apunte);
        notas.add(nota);
    }
    public ArrayList<Nota> getNotas(){
        return notas;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de la reunión: ").append(fecha.toString()).append(" Hora de la reunión:").append(horaPrevista.toString()).append("\n");
        sb.append("Hora de inicio: ").append(horaInicio.toString()).append("\n");
        sb.append("Hora de fin: ").append(horaFin.toString()).append("\n");
        sb.append("Duración de la reunión: ").append(calcularTiempoReal(horaInicio, horaFin)).append("\n");
        return sb.toString();
    }

}
