package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Empleado> listaInvitados;
    private ArrayList<Instant> listaHoraDeLlegada;
    private Instant horaDeLlegada;
    private Instant horaPrevista;
    private ArrayList<Empleado> listaDeAsistencias;
    private ArrayList<Empleado> listaDeAusencias;


    public Asistencia(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        this.listaInvitados = listaInvitados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<Empleado>();
        this.listaDeAusencias = new ArrayList<Empleado>();
        this.listaHoraDeLlegada = new ArrayList<>();
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

    public ArrayList<Empleado> getListaInvitados(){
        return listaInvitados;
    }

    public ArrayList<Instant> getListaHoraDeLlegada() {
        return listaHoraDeLlegada;
    }

    public Instant getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }
}
