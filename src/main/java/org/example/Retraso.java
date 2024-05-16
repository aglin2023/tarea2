package org.example;

import javax.swing.*;
import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {

    private ArrayList<Empleado> listaDeRetrasos;
    private ArrayList<Instant> listaHoraDeLlegada;
    private Instant horaPrevista;
    private ArrayList<Empleado> listaDeAsistencia;

    public Retraso(ArrayList<Empleado> listaInvitados, Instant horaPrevista, ArrayList<Instant> listaHoraDeLlegada, ArrayList<Empleado> listaDeAsistencia){
        super(listaInvitados, horaPrevista);
        this.listaDeRetrasos = new ArrayList<>();
        this.horaPrevista = horaPrevista;
        this.listaHoraDeLlegada = listaHoraDeLlegada;
        this.listaDeAsistencia = listaDeAsistencia;
    }

    /**
     *  Método para ver que empleado ha llegado tarde
     * @return Lista de empleados que se retrasaron en la reunión
     */
    public ArrayList<Empleado> getObtenerRetrasos() {
        if (listaHoraDeLlegada != null && !listaHoraDeLlegada.isEmpty()) {
            for (int i = 0; i < getListaInvitados().size(); i++) {
                if (listaHoraDeLlegada.get(i) != null && listaHoraDeLlegada.get(i).isAfter(horaPrevista)  ) {
                    listaDeRetrasos.add(getListaInvitados().get(i));
                }
            }
        }
        return listaDeRetrasos;
    }

    public ArrayList<Empleado> getListaDeRetrasos() {
        return listaDeRetrasos;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Retrasos: ");
        if (listaDeRetrasos != null) {
            int horaDeLlegadaEmpleado = 0;
            for(Empleado empleado : listaDeRetrasos) {
                sb.append(empleado.toString()).append("\n");
                sb.append(listaHoraDeLlegada.get(horaDeLlegadaEmpleado));
                sb.append("\n");
                horaDeLlegadaEmpleado++;
            }
        } else {
            sb.append("No hubo retrasos\n");
        }
        return sb.toString();
    }
}
