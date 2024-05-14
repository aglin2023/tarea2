package org.example;

import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant horaDeInvitacion;
    private ArrayList<Invitable> listaInvitados;

    public Invitacion() {
        this.listaInvitados = new ArrayList<Invitable>();
    }

    public ArrayList<Invitable> getListaInvitados() {
        return listaInvitados;
    }
}
