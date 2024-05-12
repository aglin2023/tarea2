package org.example;

public class Empleado implements Invitable {
    private String ID;
    private String Apellido;
    private String Nombre;
    private String Correo;

    public Empleado(String nombre, String apellido, String correo, String id){
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Correo=correo;
        this.ID=id;
    }

    public String getNombre(){
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public String getCorreo(){
        return Correo;
    }
    public String getID(){
        return ID;
    }

    @Override
    public void Invitar(){

    }
}


