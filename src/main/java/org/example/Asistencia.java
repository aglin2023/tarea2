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
        this.listaDeAsistencias = new ArrayList<>();
        this.listaDeAusencias = new ArrayList<>();
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
    public void setHoraDeLlegadaTodos(){
        Instant HoraDeLlegada = Instant.now();
        for(int i = 0; i < getListaDeAsistencias().size(); i++){
            listaHoraDeLlegada.set(i, HoraDeLlegada);
        }
    }

    public ArrayList<Empleado> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    public ArrayList<Empleado> getListaDeAusencias() {
        return listaDeAusencias;
    }

    public ArrayList<Instant> getListaHoraDeLlegada() {
        return listaHoraDeLlegada;
    }

    public ArrayList<Empleado> getListaInvitados() {
        return listaInvitados;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Asistencia; \n");
        if(listaDeAsistencias != null) {
            int horaDeLlegadaEmpleado = 0;
            for(Empleado empleado : listaDeAsistencias) {
                sb.append(empleado.toString());
                sb.append(", ");
                sb.append(listaHoraDeLlegada.get(horaDeLlegadaEmpleado).toString());
                horaDeLlegadaEmpleado++;
            }
        } else {
            sb.append("No hubo asistencias\n");
        }
        if(listaDeAusencias != null) {
            for(Empleado empleado : listaDeAusencias){
                sb.append("Ausente: \n").append(empleado.toString());
            }
        } else {
            sb.append("Todos Asistieron\n");
        }
        return sb.toString();
    }
}
