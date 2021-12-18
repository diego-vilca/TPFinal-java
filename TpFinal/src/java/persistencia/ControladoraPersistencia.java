
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController userJpa = new UsuarioJpaController();
    ServicioTuristicoJpaController servicioJpa = new ServicioTuristicoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    PaqueteTuristicoJpaController paqueteJpa = new PaqueteTuristicoJpaController();
    VentaJpaController ventaJpa = new VentaJpaController();
    
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
            System.out.println(ex.getMessage());
        }
    }

    //Buscar empleado
    public Empleado buscarEmpleado(int id) {
        return empleadoJpa.findEmpleado(id);
    }

    //Modificar empleado
    public void modificarEmpleado(Empleado emple) {
        try {
            empleadoJpa.edit(emple);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    
    //Baja
    public void borrarServicio(int codigo) {
        try {
            servicioJpa.destroy(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Buscar
    public ServicioTuristico buscarServicio(int id) {
        return servicioJpa.findServicioTuristico(id);
    }
       
    //Modificar
    public void modificarServicio(ServicioTuristico servicio) {
        try {
            servicioJpa.edit(servicio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
    
    //Baja 
    public void borrarCliente(int id) {
        try {
            clienteJpa.destroy(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Buscar cliente
    public Cliente buscarCliente(int id) {
        return clienteJpa.findCliente(id);
    }
    
    //Modificar cliente
    public void modificarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //==========================================================================
    //métodos para los Usuario
    //Lectura
    public List<Usuario> traerUsuario() {
        return userJpa.findUsuarioEntities();
    }
    
    public void borrarUsuario(int id) {
        try {
            userJpa.destroy(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //==========================================================================
    //Métodos para los paquetes
    
    //Alta
    public void crearPaquete(PaqueteTuristico paquete) {
        paqueteJpa.create(paquete);
    }
    
    //Lectura
    public List<PaqueteTuristico> traerPaquetes() {
        return paqueteJpa.findPaqueteTuristicoEntities();
    }
    
    
    //Baja
    public void borrarPaquete(int codigo) {
        try {
            paqueteJpa.destroy(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Buscar
    public PaqueteTuristico buscarPaquete(int codigo) {
        return paqueteJpa.findPaqueteTuristico(codigo);
    }
    
    //Modificar
    public void modificarPaquete(PaqueteTuristico paquete) {
        try {
            paqueteJpa.edit(paquete);
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
    
    //==========================================================================
    //Métodos para Venta
    
    //Alta
    public void crearVenta(Venta miVenta) {
        ventaJpa.create(miVenta);
    }

    public List<Venta> traerVentas() {
        return ventaJpa.findVentaEntities();
    }

    public void borrarVenta(int codVenta) {
        try {
            ventaJpa.destroy(codVenta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Venta buscarVenta(int codigo) {
        return ventaJpa.findVenta(codigo);
    }

    public void modificarVenta(Venta venta) {
        try {
            ventaJpa.edit(venta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    

    

    
    

    

    

    

    
    

    
    
    
    
    
}
