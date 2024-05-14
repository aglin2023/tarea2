package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {

    private final ArrayList<Invitable> listaDeRetrasos;

    public Retraso(ArrayList<Invitable> listaInvitados, Instant horaPrevista){
        super(listaInvitados, horaPrevista);
        listaDeRetrasos = new ArrayList<Invitable>();
    }

    /**
     *  Método para ver que empleado ha llegado tarde
     * @return Lista de empleados que se retrasaron en la reunión
     */
    public ArrayList<Invitable> getObtenerRetrasos() {
        for (int i = 0; i < super.getListaInvitados().size(); i++) {
            if (super.getListaHoraDeLlegada().get(i).isAfter(super.getHoraPrevista())) {
                super.getListaDeAsistencias().add(super.getListaInvitados().get(i));
                listaDeRetrasos.add(super.getListaInvitados().get(i));
            }
        }
        return listaDeRetrasos;
    }

    public ArrayList<Invitable> getListaDeRetrasos() {
        return listaDeRetrasos;
    }
}
