
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController userJpa = new UsuarioJpaController();
    ServicioTuristicoJpaController servicioJpa = new ServicioTuristicoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    PaqueteTuristicoJpaController paqueteJpa = new PaqueteTuristicoJpaController();
    
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
    
    //Eliminar
    public void borrarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Buscar empleado
    public Empleado buscarEmpleado(int id) {
        return empleadoJpa.findEmpleado(id);
    }

    //Modificar empleado
    public void ModificarEmpleado(Empleado emple) {
        try {
            empleadoJpa.edit(emple);
        } catch (Exception e) {
            e.getMessage();
        }
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
    
    
    //==========================================================================
    //métodos para los Usuario
    public List<Usuario> traerUsuario() {
        return userJpa.findUsuarioEntities();
    }
    
    //==========================================================================
    //Métodos para los paquetes
    
    public void crearPaquete(PaqueteTuristico paquete) {
        paqueteJpa.create(paquete);
    }

    public List<PaqueteTuristico> traerPaquetes() {
        return paqueteJpa.findPaqueteTuristicoEntities();
    }

    

    
    

    
    
    
    
    
}
