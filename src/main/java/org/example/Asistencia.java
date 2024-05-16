package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Empleado> listaInvitados;
    private ArrayList<Instant> listaHoraDeLlegada;
    private Instant horaPrevista;
    private ArrayList<Empleado> listaDeAsistencias;
    private ArrayList<Empleado> listaDeAusencias;
    private int indiceHora;

    public Asistencia(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        this.listaInvitados = listaInvitados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<>();
        this.listaDeAusencias = new ArrayList<>();
        this.listaHoraDeLlegada = new ArrayList<>();
        this.indiceHora = 0;
    }

    public ArrayList<Empleado> getObtenerAsistencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaInvitados.size(); numeroInvitado++) {
            if(listaHoraDeLlegada.get(numeroInvitado) != null){
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

    public void setHoraDeLlegada(Instant horaDeLlegada) {
        listaHoraDeLlegada.add(horaDeLlegada);
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
            sb.append("\nAusente: \n");
            for(Empleado empleado : listaDeAusencias){
                sb.append(empleado.toString());
            }
        } else {
            sb.append("Todos Asistieron\n");
        }
        return sb.toString();
    }
}
