package org.example;

import java.time.Instant;

/**clase que representa una nota */
public class Nota {

    /**variable que representa el contenido de la nota */
    private String contenido;

    /**variable que representa el momento en que se realizó el ultimo cambio*/
    private Instant ultimoCambio;

    /**constructor de la clase
     *@param s texto inicial que contiene la nota */
    public Nota(String s){
	    contenido = s;
	    ultimoCambio = Instant.now();
    }
    /**metodo que devuelve el contenido de la nota
     * @return regresa una representacion de cadena del contenido inicial y el contenido del ultimo cambio */
    public String toString(){
	return contenido + " -- " + ultimoCambio;
    }

    /**metodo de tipo void que cambia el contenido de la nota
     * @param n el nuevo contenido de la nota */
    public void CambiarNota(String n){
	contenido = n;
	ultimoCambio = Instant.now();
    }
}
