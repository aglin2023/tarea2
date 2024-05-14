package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {

    private final ArrayList<Empleado> listaDeRetrasos;

    public Retraso(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        super(listaInvitados, horaPrevista);
        listaDeRetrasos = new ArrayList<Empleado>();
    }

    /**
     *  Método para ver que empleado ha llegado tarde
     * @return Lista de empleados que se retrasaron en la reunión
     */
    public ArrayList<Empleado> getObtenerRetrasos() {
        for (int i = 0; i < super.getListaInvitados().size(); i++) {
            if (super.getListaHoraDeLlegada().get(i).isAfter(super.getHoraPrevista())) {
                super.getListaDeAsistencias().add(super.getListaInvitados().get(i));
                listaDeRetrasos.add(super.getListaInvitados().get(i));
            }
        }
        return listaDeRetrasos;
    }

    public ArrayList<Empleado> getListaDeRetrasos() {
        return listaDeRetrasos;
    }
}
