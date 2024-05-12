package org.example;
import java.util.ArrayList;

public class Departamento {

    private ArrayList<Empleado> empleados;
    private String Nombre;

    public Departamento(){
        empleados=new ArrayList<>();
    }
    public void AgregarEmpleados(Empleado empleado){
        empleados.add(empleado);
    }
    public int ObtenerCantidadEmpleados(){
        return empleados.size();
    }
}
