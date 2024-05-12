package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    protected ArrayList<Empleado> listaEmpleados;
    protected Instant horaDeLlegada;
    protected ArrayList<Instant> listaHoraDeLlegada;
    protected Instant horaPrevista;
    private ArrayList<Empleado> listaDeAsistencias;
    private ArrayList<Empleado> listaDeAusencias;


    public Asistencia(ArrayList<Empleado> listaEmpleados, Instant horaPrevista){
        this.listaEmpleados = listaEmpleados;
        this.horaPrevista = horaPrevista;
        this.listaDeAsistencias = new ArrayList<Empleado>();
        this.listaDeAusencias = new ArrayList<Empleado>();
        //Puedo Reemplazar este for con el setter al hacer test!
        for(Empleado empleado : listaEmpleados) {
            listaHoraDeLlegada.add(horaPrevista);
        }
        for(int i = 0; i < listaEmpleados.size(); i++) {
            listaHoraDeLlegada.add(null);
        }
    }

    public ArrayList<Empleado> getObtenerAsistencia(){
        for(int numeroInvitado = 0; numeroInvitado < listaEmpleados.size(); numeroInvitado++) {
            if(listaHoraDeLlegada.get(numeroInvitado).isBefore(horaPrevista)) {
                listaDeAsistencias.add(listaEmpleados.get(numeroInvitado));
            }
        }
        return listaDeAsistencias;
    }
    public ArrayList<Empleado> getObtenerAusencias(){
        for(int numeroInvitado = 0; numeroInvitado < listaEmpleados.size(); numeroInvitado++){
            if(listaHoraDeLlegada.get(numeroInvitado) == null) {
                listaDeAusencias.add(listaEmpleados.get(numeroInvitado));
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
}
