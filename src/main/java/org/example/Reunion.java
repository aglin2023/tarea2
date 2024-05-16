package org.example;

import org.example.Exception.ReunionException;

import java.io.File;
import java.io.FileWriter;
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

    /**
     *
     * @param fecha
     * @param duracionPrevista
     * @param horaPrevista
     * @param t
     */
    public Reunion(Date fecha, Duration duracionPrevista, Instant horaPrevista, TipoReunion t) {
        this.fecha = fecha;
        this.duracionPrevista = duracionPrevista;
        this.horaPrevista = horaPrevista;
        this.invitacion = new Invitacion();
        this.asistencia = new Asistencia(invitacion.getListaInvitados(), horaPrevista);
        this.retraso = new Retraso(invitacion.getListaInvitados(), horaPrevista, asistencia.getListaHoraDeLlegada(), asistencia.getListaDeAsistencias());
	    this.tipoReunion = t;
        this.notas = new ArrayList<>();
    }

    public ArrayList obtenerAsistencias() {
        return asistencia.obtenerAsistencia();
    }

    public ArrayList obtenerAusencias() {
        return asistencia.obtenerAusencia();
    }

    public ArrayList obtenerRetrasos() {
        return retraso.ObtenerRetrasos();
    }

    public int obtenerTotalAsistencias() {
        return asistencia.getListaDeAsistencias().size();
    }

    public float obtenerPorcentajeAsistencia() throws Exception {
        if(invitacion.getListaInvitados().size() != 0)
            return (float) obtenerTotalAsistencias() * 100 / (float) invitacion.getListaInvitados().size();
        else
            throw new ReunionException("División por cero invitados");
    }

    public float calcularTiempoReal() {
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
    public Retraso getRetraso(){
        return retraso;
    }

    public void agregarNotas(String apunte){
        Nota nota = new Nota(apunte);
        notas.add(nota);
    }
    public ArrayList<Nota> getNotas(){
        return notas;
    }

    public void cambiarNotas(int numeroDeNota, String s){
        notas.get(numeroDeNota-1).CambiarNota(s);
    }

    public void setHoraFin(Instant horaFin){
        this.horaFin = horaFin;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de la reunión: ").append(fecha.toString()).append(" Hora de la reunión:").append(horaPrevista.toString()).append("\n");
        sb.append("Hora de inicio: ").append(horaInicio.toString()).append("\n");
        sb.append("Hora de fin: ").append(horaFin.toString()).append("\n");
        sb.append("Duración de la reunión: ").append(calcularTiempoReal()).append("\n");
        return sb.toString();
    }

    public void toString(String path) {
        try{
            FileWriter fw = new FileWriter(path);
            for (int i = 0; i < this.toString().length(); i++)
                fw.write(this.toString().charAt(i));
            fw.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public Invitacion getInvitacion() {
        return invitacion;
    }
}
