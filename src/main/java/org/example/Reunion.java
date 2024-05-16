package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.ArrayList;

/**
 * clase de tipo abstracto que representa una reunion
 */
public abstract class Reunion {

    /**
     * variable de tipo date que representa la fecha de la reunion
     */
    private Date fecha;

    /**
     * variable de tipo duration que representa la duracion prevista de la reunion
     */
    private Duration duracionPrevista;

    /**
     * variable de tipo instante que representa la hora prevista de la reunion
     */
    private Instant horaPrevista;

    /**
     * variable de tipo instante que representa la hora de inicio de la reunion
     */
    private Instant horaInicio;

    /**
     * variable de tipo instant que representa la hora de finalizacion de la reunion
     */
    private Instant horaFin;

    /**
     * variable que guarda la asistencia a la reunion
     */
    private Asistencia asistencia;

    /**
     * variable que guarda el retraso a la reunion
     */
    private Retraso retraso;

    /**
     * variable que representa una invitacion a la reunion
     */
    protected Invitacion invitacion;

    /**
     * variable que representa el tipo de reunion
     */
    private TipoReunion tipoReunion;

    /**
     * variable de tipo arraylist que guarda las notas de la reunion
     */
    private ArrayList<Nota> notas;

    /**
     *construnctor de la clase
     * @param fecha fecha de la reunion
     * @param duracionPrevista duracion prevista de la reunion
     * @param horaPrevista hora prevista de la reunion
     * @param t tipo de reunion
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

    /**
     * metodo que regresa una lista con las asistencias en la reunion
     * @return las asistencias de las reunion
     */
    public ArrayList obtenerAsistencias() {
        return asistencia.obtenerAsistencia();
    }

    /**
     * metodo que regresa una lista con las ausencias de la reunion
     * @return las ausencias de la reunion
     */
    public ArrayList obtenerAusencias() {
        return asistencia.obtenerAusencia();
    }

    /**
     * metodo que regresa una lista con los retrasos de la reunion
     * @return retrasos de la reunion
     */
    public ArrayList obtenerRetrasos() {
        return retraso.ObtenerRetrasos();
    }

    /**
     * metodo que regresa una lista con el tamaño de la asistencia total de la reunion
     * @return tamaño total de asistentes a la reunion
     */
    public int obtenerTotalAsistencias() {
        return asistencia.getListaDeAsistencias().size();
    }

    /**
     * metodo que regresa el porcentaje de asistencia de la reunion
     * @return porcentaje de asistencia
     */
    public float obtenerPorcentajeAsistencia() {
        return (float) obtenerTotalAsistencias() * 100 / (float) invitacion.getListaInvitados().size();
    }

    /**
     * metodo que regresa el tiempo que duró la reunion en minutos
     * @return duracion de la reunion en minutos
     */
    public float calcularTiempoReal() {
        Duration tiempoReal = Duration.between(horaInicio, horaFin);
        return (float) tiempoReal.toMinutes();
    }

    /**
     * metodo que otorga la hora de inicio de la reunion
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    /**
     * metodo que otorga la hora de finalizacion de la reunion
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }

    /**
     * metodo que regresa la asistencia en la reunion
     * @return la asistencia en la reunion
     */
    public Asistencia getAsistencia() {
        return asistencia;
    }

    /**
     * metodo que regresa los retrasos de la reunion
     * @return los retrasos de la reunion
     */
    public Retraso getRetraso(){
        return retraso;
    }

    /**
     * metodo que permite agregar mas notas en una reunion
     * @param apunte texto que se desee agregar a la nota
     */
    public void agregarNotas(String apunte){
        Nota nota = new Nota(apunte);
        notas.add(nota);
    }

    /**
     * metodo que regresa una lista con las notas
     * @return lista con notas
     */
    public ArrayList<Nota> getNotas(){
        return notas;
    }

    /**
     * metodo que permite cambiar el contenido de una nota
     * @param numeroDeNota numero de la nota a cambiar
     * @param s texto nuevo en la nota
     */
    public void cambiarNotas(int numeroDeNota, String s){
        notas.get(numeroDeNota-1).CambiarNota(s);
    }

    /**
     * metodo para otorgar una hora de finalizacion de la reunion
     * @param horaFin
     */
    public void setHoraFin(Instant horaFin){
        this.horaFin = horaFin;
    }

    /**
     * metodo que regresa una cadena de texto con los datos relacionados a la reunion
     * @return String con la fecha de reunion, hora de inicio y de fin y la duracion de la reunion
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de la reunión: ").append(fecha.toString()).append(" Hora de la reunión:").append(horaPrevista.toString()).append("\n");
        sb.append("Hora de inicio: ").append(horaInicio.toString()).append("\n");
        sb.append("Hora de fin: ").append(horaFin.toString()).append("\n");
        sb.append("Duración de la reunión: ").append(calcularTiempoReal()).append("\n");
        return sb.toString();
    }

    /**
     * metodo que permite obtener una invitacion a la reunio
     * @return una invitacion a la reunion
     */
    public Invitacion getInvitacion() {
        return invitacion;
    }
}
