package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**clase que representa una reunion virtual */
public class ReunionVirtual extends Reunion {

    /**variable de tipo String que representa un enlace para ingresa a la reunion */
    private String enlace;

    /**constructor de la clase
     * @param  fecha fecha de la reunion
     * @param  duracionPrevista duracion prevista de la reunion
     * @param  horaPrevista hora prevista de la reunion
     * @param  enlace el enlace que dirige hacia la reunion
     * @param  t el tipo de reunion que será*/
    public ReunionVirtual(Date fecha, Duration duracionPrevista, Instant horaPrevista, String enlace,TipoReunion t) {
        super(fecha, duracionPrevista, horaPrevista,t);
        this.enlace = enlace;
    }

    /**metodo que regresa un string con el enlace de la reunion */
    public String getEnlace() {
        return enlace;
    }

    /**metodo que regresa en un String los datos obtenidos de la reunion */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Enlace: ").append(enlace).append("\n");
        sb.append("Lista de participantes: ").append("\n");
        sb.append(super.getAsistencia().toString());
        if(super.getNotas() != null) {
            int numeroDeNota = 0;
            for(Nota nota : super.getNotas()) {
                sb.append("Nota " + numeroDeNota + ":\n");
                sb.append(nota.toString()).append("\n\n");
            }
        }
        return sb.toString();
    }
}
