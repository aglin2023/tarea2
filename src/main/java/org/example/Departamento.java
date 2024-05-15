package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{

    private ArrayList<Empleado> ListaEmpleados;
    private String Nombre;

    public Departamento(String nombreDepa) {
        this.Nombre = nombreDepa;
        ListaEmpleados = new ArrayList<>();
    }
    public void AgregarEmpleados(Empleado empleado){
        ListaEmpleados.add(empleado);
    }
    public int TamañoListaEmpleados(){
        return ListaEmpleados.size();
    }
    /**public void ListaEmpleados(){
        for(Empleado empleado: CantEmpleados){
            System.out.println("NOMBRE:"+empleado.getNombre()+" "+empleado.getApellido()+" "
                    +"Correo:"+empleado.getCorreo()+ " "+"ID:"+empleado.getID());
        }
    }
     */
    public ArrayList<Empleado> getListaEmpleados(){
        return  ListaEmpleados;
    }
    public String NombreDelDepaEs(){
        return Nombre;
    }
    @Override
   public void Invitar(ArrayList<Empleado> listaInvitados) {
        listaInvitados.addAll(ListaEmpleados);
        for (Empleado empleado : ListaEmpleados) {
            empleado.Invitar(listaInvitados);
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de empleados:\n");
        if(ListaEmpleados != null) {
            for(Empleado empleado : ListaEmpleados) {
                sb.append(empleado.toString()).append("\n");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
