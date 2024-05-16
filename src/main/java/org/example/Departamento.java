package org.example;
import java.util.ArrayList;
/**clase que representa a los distintos departamentos, implementa la interfaz "Invitable" */
public class Departamento implements Invitable{
    /**variable que representa una lista con los empleados */
    private ArrayList<Empleado> ListaEmpleados;

    /**variable que almacena el nombre del departamento*/
    private String Nombre;

    /**constructor de la clase en el que se pone el nombre del departamento e inicia una lista de empleados
     * @param nombreDepa nombre del departamento */
    public Departamento(String nombreDepa) {
        this.Nombre = nombreDepa;
        ListaEmpleados = new ArrayList<>();
    }
    /**metodo publico de tipo void que permite agregar empleados a la lista de empleados
     * @param empleado representa que se quiere añadir empleados a la lista*/
    public void AgregarEmpleados(Empleado empleado){
        if(ListaEmpleados.contains(empleado))
            return;
        ListaEmpleados.add(empleado);
    }

    /**
     * metodo que regresa un entero del tamaño de la lista de empleados
     * @return retorna el tamaño del array ListaEmpleados
     */
    public int TamañoListaEmpleados(){
        return ListaEmpleados.size();
    }

    /**
     * metodo que regresa una lista con los empleados
     * @return Retorna Lista de Empleados
     */
    public ArrayList<Empleado> getListaEmpleados(){
        return  ListaEmpleados;
    }

    /**
     * metodo que regresa el nombre del departamento
     * @return retorna el nombre del departamento.
     */
    public String NombreDelDepaEs(){
        return Nombre;
    }
    @Override
    /**metodo tipo void que permite invitar a una lista de invitados a una reunion
     * @param r la reunion a la que se quiere invitar */
    public void Invitar(Reunion r) {
        ArrayList<Empleado> listaInvitados = r.getInvitacion().getListaInvitados();
        for (Empleado empleado : ListaEmpleados) {
            empleado.Invitar(r);
        }
    }

    /**metodo que regresa en un String una lista con todos los empleados y sus datos
     * @return datos de la lista de empleados del departamento */
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
