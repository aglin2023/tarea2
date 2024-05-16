package org.example;

import java.time.Instant;
import java.util.ArrayList;

/**
 * clase que representa una invitacion de la reunion para un empleado o departamento
 */
public class Invitacion {

    /**
     * variable de tipo instant que representa la hora de invitacion a la reunion
     */
    private Instant horaDeInvitacion;

    /**
     * variable de tipo arraylist que guarda la lista de invitados
     */
    private ArrayList<Empleado> listaInvitados;

    /**
     * constructor de la clase
     */
    public Invitacion() {
        this.listaInvitados = new ArrayList<Empleado>();
        this.horaDeInvitacion = Instant.now();
    }

    /**
     * metodo que regresa la lista de los invitados a la reunion
     * @return lista de invitados
     */
    public ArrayList<Empleado> getListaInvitados() {
        return listaInvitados;
    }

    /**
     * metodo que regresa una cadena de texto con la hora de invitacion y la lista de invitados
     * @return String con la hora de invitacion y la lista de invitados
     */
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
