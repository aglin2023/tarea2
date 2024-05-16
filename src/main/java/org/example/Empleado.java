package org.example;

import java.util.ArrayList;
/**clase que representa a un empleado de los departamentos, implementa la interfaz "invitable" */
public class Empleado implements Invitable {

    /**variable de tipo String que guarda una ID del empleado*/
    private String ID;

    /**variable de tipo String que guarda el apellido del empleado*/
    private String Apellido;

    /**variable de tipo String que guarda el nombre del empleado*/
    private String Nombre;

    /**variable de tipo String que guarda el correo del empleado*/
    private String Correo;

    /**Constructor de la clase en el que se ingresan las distintas variables
     * @param nombre nombre del empleado
     * @param apellido apellido del empleado
     * @param correo correo del empleado
     * @param id ID del empleado*/
    public Empleado(String nombre, String apellido, String correo, String id){
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Correo=correo;
        this.ID=id;
    }

    /**metodo de tipo void que permite invitar un empleado a una reunion
     * @param r la reunion a la que se quiere invitar */
    @Override
    public void Invitar(Reunion r) {
        ArrayList<Empleado> listainvitados = r.getInvitacion().getListaInvitados();

        if(listainvitados.contains(this)){
            return;
        }
        listainvitados.add(this);
    }

    /**metodo publico que devuelve un String de los datos del empleado
     * @return datos del empleado que se invitó*/
    public String toString() {
        return "Empleado{" +
                "ID='" + ID + "\'" +
                ", Apellido='" + Apellido + "\'" +
                ", Nombre='" + Nombre + "\'" +
                ", Correo='" + Correo + "\'" +
                "}\n" ;
    }
}