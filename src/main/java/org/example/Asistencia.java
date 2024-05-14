package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Invitable> listaInvitados;
    private ArrayList<Instant> listaHoraDeLlegada;
    private Instant horaDeLlegada;
    private Instant horaPrevista;
    private ArrayList<Invitable> listaDeAsistencias;
    private ArrayList<Invitable> listaDeAusencias;


    public Asistencia(ArrayList<Invitable> listaInvitados, Instant horaPrevista){
        this.listaInvitados = listaInvitados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<Invitable>();
        this.listaDeAusencias = new ArrayList<Invitable>();
        this.listaHoraDeLlegada = new ArrayList<>();
    }

    public ArrayList<Invitable> getObtenerAsistencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++) {
            if(listaHoraDeLlegada.get(numeroInvitado).isBefore(horaPrevista) || listaHoraDeLlegada.get(numeroInvitado).equals(horaPrevista)){
                listaDeAsistencias.add(listaInvitados.get(numeroInvitado));
            }
        }
        return listaDeAsistencias;
    }
    public ArrayList<Invitable> getObtenerAusencias(){
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
    public void setHoraDeLlegadaTodos(){
        Instant HoraDeLlegada = Instant.now();
        for(int i = 0; i < getListaDeAsistencias().size(); i++){
            listaHoraDeLlegada.set(i, HoraDeLlegada);
        }
    }

    public ArrayList<Invitable> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    public ArrayList<Invitable> getListaDeAusencias() {
        return listaDeAusencias;
    }

    public ArrayList<Instant> getListaHoraDeLlegada() {
        return listaHoraDeLlegada;
    }

    public ArrayList<Invitable> getListaInvitados() {
        return listaInvitados;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }
}
