package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {

    private final ArrayList<Empleado> listaDeRetrasos;

    public Retraso(ArrayList<Empleado> listaEmpleados, Instant horaPrevista) {
        super(listaEmpleados, horaPrevista);
        listaDeRetrasos = new ArrayList<Empleado>();
    }

    /**
     * Método para ver que empleado ha llegado tarde
     *
     * @return Lista de empleados que se retrasaron en la reunión
     */
    public ArrayList getObtenerRetrasos() {
        for (int i = 0; i < super.listaEmpleados.size(); i++) {
            if (super.listaHoraDeLlegada.get(i).isAfter(super.getHoraDeLlegada())) {
                super.listaDeAsistencias.add(super.listaInvitados.get(i));
                listaDeRetrasos.add(super.listaEmpleados.get(i));
            }
        }
        return listaDeRetrasos;
    }

    public ArrayList<Empleado> getListaDeRetrasos() {
        return listaDeRetrasos;
    }
}
