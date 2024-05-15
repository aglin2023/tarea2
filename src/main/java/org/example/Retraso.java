package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Retraso extends Asistencia {

    private ArrayList<Empleado> listaDeRetrasos;

    public Retraso(ArrayList<Empleado> listaInvitados, Instant horaPrevista){
        super(listaInvitados, horaPrevista);
        this.listaDeRetrasos = new ArrayList<>();
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Retrasos: ");
        if (listaDeRetrasos != null) {
            int horaDeLlegadaEmpleado = 0;
            for(Empleado empleado : listaDeRetrasos) {
                sb.append(empleado.toString()).append(", ");
                sb.append(super.getListaHoraDeLlegada().get(horaDeLlegadaEmpleado));
                sb.append("\n");
                horaDeLlegadaEmpleado++;
            }
        } else {
            sb.append("No hubo retrasos\n");
        }
        return sb.toString();
    }
}
