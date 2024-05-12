package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{

    private ArrayList<Empleado> CantEmpleados;
    private String Nombre;

    public Departamento(String nombreDepa){
        this.Nombre= nombreDepa;
        CantEmpleados=new ArrayList<>();
    }
    public void AgregarEmpleados(Empleado empleado){
        CantEmpleados.add(empleado);
    }
    public int ObtenerCantidadEmpleados(){
        return CantEmpleados.size();
    }
    public void ListaEmpleados(){
        for(Empleado empleado: CantEmpleados){
            System.out.println("NOMBRE:"+empleado.getNombre()+" "+empleado.getApellido()+" "
                    +"Correo:"+empleado.getCorreo()+ " "+"ID:"+empleado.getID());
        }
    }
    public String NombreDelDepaEs(){
        return Nombre;
    }
    @Override
    public void Invitar(){

    }
}
