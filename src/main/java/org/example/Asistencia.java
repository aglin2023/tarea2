package org.example;

import java.time.Instant;
import java.util.ArrayList;

/**
 * clase que representa la asistencia
 */
public class Asistencia {
    /**
     * variable de tipo arraylist que guarda la lista de invitados*/
    private ArrayList<Empleado> listaInvitados;
    /**
     * variable de tipo arraylist que guarda la lista de hora de llegada a la reunion*/
    private ArrayList<Instant> listaHoraDeLlegada;
    /**
     * variable que representa un instante de hora prevista de la reunion*/
    private Instant horaPrevista;

    /**
     * variable de tipo arraylist que representa la lista de asistencia*/
    private ArrayList<Empleado> listaDeAsistencias;

    /**
     * variable de tipo arraylist que representa la lista de ausencias en la reunion*/
    private ArrayList<Empleado> listaDeAusencias;

    /**
     * variable que representa el indice de la hora en un arreglo*/
    private int indiceHora;

    /**
     * constructor de la clase
     * @param listaInvitados
     * @param horaPrevista
     */
    public Asistencia(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        this.listaInvitados = listaInvitados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<>();
        this.listaDeAusencias = new ArrayList<>();
        this.listaHoraDeLlegada = new ArrayList<>();
        this.indiceHora = 0;
    }

    /**
     * metodo que permite obtener lista de asistentes en la reunion
     * @return la lista de asistencias de la reunion*/
    public ArrayList<Empleado> obtenerAsistencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++) {
            if(listaHoraDeLlegada.get(numeroInvitado) != null){
                listaDeAsistencias.add(listaInvitados.get(numeroInvitado));
            }
        }
        return listaDeAsistencias;
    }

    /**
     * metodo que permite obtener una lista de los ausentes a la reunion
     * @return la lista de los ausentes a la reunion
     */
    public ArrayList<Empleado> obtenerAusencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++){
            if(listaHoraDeLlegada.get(numeroInvitado) == null) {
                listaDeAusencias.add(listaInvitados.get(numeroInvitado));
            }
        }
        return listaDeAusencias;
    }

    /**
     * metodo que permite poner la hora de llegada
     * @param horaDeLlegada la hora de llegada que se ingrese
     */
    public void setHoraDeLlegada(Instant horaDeLlegada) {
        listaHoraDeLlegada.add(horaDeLlegada);
    }

    /**
     * metodo que permite obtener la hora de llegada de todos los empleados
     */
    public void setHoraDeLlegadaTodos(){
        Instant HoraDeLlegada = Instant.now();
        for(int i = 0; i < getListaDeAsistencias().size(); i++){
            listaHoraDeLlegada.set(i, HoraDeLlegada);
        }
    }

    /**
     * metodo que regresa la lista de asistencias
     * @return la lista de asistentes a la reunion
     */
    public ArrayList<Empleado> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    /**
     * metodo que permite obtener la lista de ausentes a la reunion
     * @return lista de los empleados ausentes
     */
    public ArrayList<Empleado> getListaDeAusencias() {
        return listaDeAusencias;
    }

    /**
     *metodo que regresa la lista de la hora de llegada a la reunion
     * @return lista de hora de llegada
     */
    public ArrayList<Instant> getListaHoraDeLlegada() {
        return listaHoraDeLlegada;
    }

    /**
     * metodo que regresa la lista de invitados a la reunion
     * @return la lista de invitados
     */
    public ArrayList<Empleado> getListaInvitados() {
        return listaInvitados;
    }

    /**
     * metodo que regresa la hora prevista para la reunion
     * @return la hora prevista
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * metodo publico que regresa una cadena de texto relacionada a las asitencias de una reunion
     * @return un String con todas las asistencias y ausencias de la reunion
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
         sb.append("\n");
         sb.append("Asistencia: \n");
        if(listaDeAsistencias != null) {
            for(Empleado empleado : listaDeAsistencias) {
                sb.append(empleado.toString()).append(listaHoraDeLlegada.get(indiceHora));
            }
        } else {
            sb.append("No hubo asistencias\n");
        }
        if(listaDeAusencias != null) {
            sb.append("\nAusente:    \n");
            for(Empleado empleado : listaDeAusencias){
                sb.append(empleado.toString());
            }
        } else {
            sb.append("Todos Asistieron\n");
        }
        return sb.toString();
    }
}
