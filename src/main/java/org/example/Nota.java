package org.example;

import java.time.Instant;

public class Nota {

    private String contenido;
    private Instant ultimoCambio;

    public Nota(String s){
	    contenido = s;
	    ultimoCambio = Instant.now();
    }

    public String toString(){
	return contenido + " -- " + ultimoCambio;
    }

    // Cambia la nota
    public void CambiarNota(String n){
	    contenido = n;
	    ultimoCambio = Instant.now();
    }
}
