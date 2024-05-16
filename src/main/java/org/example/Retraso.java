package org.example;

import java.time.Instant;
import java.util.ArrayList;

/**
 * clase que representa los atrasos a la reunion, es una extension de "Asistencia"
 */
public class Retraso extends Asistencia {

    /**
     * variable de tipo arraylist que representa una lista con los retrasos a la reunion
     */
    private ArrayList<Empleado> listaDeRetrasos;

    /**
     * variable de tipo arraylist que representa una lista con hora de llegada de los retrasos
     */
    private ArrayList<Instant> listaHoraDeLlegada;

    /**
     * variable que representa un instante de hora prevista para la reunion
     */
    private Instant horaPrevista;

    /**
     * variable de tipo arraylist que representa una lista de asistencia
     */
    private ArrayList<Empleado> listaDeAsistencia;

    /**
     *Constructor de la clase
     * @param listaInvitados
     * @param horaPrevista
     * @param listaHoraDeLlegada
     * @param listaDeAsistencia
     */
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
    public ArrayList<Empleado> ObtenerRetrasos() {
        if (listaHoraDeLlegada != null && !listaHoraDeLlegada.isEmpty()) {
            for (int i = 0; i < getListaInvitados().size(); i++) {
                if (listaHoraDeLlegada.get(i) != null && listaHoraDeLlegada.get(i).isAfter(horaPrevista)  ) {
                    listaDeRetrasos.add(getListaInvitados().get(i));
                }
            }
        }
        return listaDeRetrasos;
    }

    /**
     * metodo que regresa la lista de retrasos a la reunion
     * @return lista de retrasos
     */
    public ArrayList<Empleado> getListaDeRetrasos() {
        return listaDeRetrasos;
    }

    /**
     * metodo que regresa una cadena de texto con los datos relacionados a la lista de retrasos de la reunion
     * @return String con la lista de retrasos de la reunion con su hora de llegada
     */
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
