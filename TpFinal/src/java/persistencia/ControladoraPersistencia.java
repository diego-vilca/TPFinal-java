
package persistencia;

import java.util.List;
import logica.Cliente;
import logica.Empleado;
import logica.ServicioTuristico;
import logica.Usuario;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController userJpa = new UsuarioJpaController();
    ServicioTuristicoJpaController servicioJpa = new ServicioTuristicoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    
    //==========================================================================
    //métodos para los empleados
    //Alta
    public void crearEmpleado(Empleado empleado, Usuario user) {
        userJpa.create(user);
        empleadoJpa.create(empleado);
    }
    
    //Lectura

    public List<Empleado> traerEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    } 
    
    
    //==========================================================================
    //métodos para los servicios
    //Alta

    public void crearServicio(ServicioTuristico servicio) {
        servicioJpa.create(servicio);
    }
    
    
    //Lectura
    public List<ServicioTuristico> traerServicios() {
        return servicioJpa.findServicioTuristicoEntities();
    }
    
    //==========================================================================
    //métodos para los clientes
    //Alta

    public void crearCliente(Cliente cliente) {
        clienteJpa.create(cliente);
    }
    
    //Lectura
    public List<Cliente> traerClientes() {
        return clienteJpa.findClienteEntities();
    }

    

    
    
    
    
}
