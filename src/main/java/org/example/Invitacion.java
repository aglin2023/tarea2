package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant horaDeInvitacion;
    private ArrayList<Empleado> listaInvitados;

    public Invitacion() {
        this.listaInvitados = new ArrayList<Empleado>();
        this.horaDeInvitacion = Instant.now();
    }

    public ArrayList<Empleado> getListaInvitados() {
        return listaInvitados;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hora de invitación: " + horaDeInvitacion.toString()).append("\n");
        sb.append("Lista de invitados: ");
        if(listaInvitados != null) {
            for(Empleado empleado : listaInvitados) {
                sb.append(empleado.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
