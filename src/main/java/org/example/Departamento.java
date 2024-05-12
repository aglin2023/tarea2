package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{

    private ArrayList<Empleado> empleados;
    private String Nombre;

    public Departamento(String nombreDepa){
        this.Nombre= nombreDepa;
        empleados=new ArrayList<>();
    }
    public void AgregarEmpleados(Empleado empleado){
        empleados.add(empleado);
    }
    public int ObtenerCantidadEmpleados(){
        return empleados.size();
    }
    public String NombreDelDepaEs(){
        return Nombre;
    }
    @Override
    public void Invitar(){

    }
}
