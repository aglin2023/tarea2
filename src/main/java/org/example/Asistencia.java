package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    protected ArrayList<Empleado> listaInvitados;
    protected ArrayList<Instant> listaHoraDeLlegada;
    protected Instant horaDeLlegada;
    private Instant horaPrevista;
    protected ArrayList<Empleado> listaDeAsistencias;
    private ArrayList<Empleado> listaDeAusencias;


    public Asistencia(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        this.listaInvitados = listaInvitados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<Empleado>();
        this.listaDeAusencias = new ArrayList<Empleado>();
    }

    public ArrayList<Empleado> getObtenerAsistencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++) {
            if(listaHoraDeLlegada.get(numeroInvitado).isBefore(horaPrevista) || listaHoraDeLlegada.get(numeroInvitado).equals(horaPrevista)){
                listaDeAsistencias.add(listaInvitados.get(numeroInvitado));
            }
        }
        return listaDeAsistencias;
    }
    public ArrayList<Empleado> getObtenerAusencias(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++){
            if(listaHoraDeLlegada.get(numeroInvitado) == null) {
                listaDeAusencias.add(listaInvitados.get(numeroInvitado));
            }
        }
        return listaDeAusencias;
    }

    /**
     * setHoraDeLLegada tiene la función de registrar la hora de llegada de un empleado
     * @param horaDeLlegada Instante de tiempo cuando se presenta
     * @param numeroInvitado Número de invitado del empleado
     */
    public void setHoraDeLlegada(Instant horaDeLlegada, int numeroInvitado) {
        this.horaDeLlegada = horaDeLlegada;
        listaHoraDeLlegada.set(numeroInvitado, horaDeLlegada);
    }

    public ArrayList<Empleado> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    public ArrayList<Empleado> getListaDeAusencias() {
        return listaDeAusencias;
    }

    public Instant getHoraDeLlegada() {
        return horaDeLlegada;
    }
}
