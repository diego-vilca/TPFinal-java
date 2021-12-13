
package logica;

import java.sql.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //==========================================================================
    //metodos para Empleado
    // Alta
    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, Date fechaNac, String nacionalidad, String celular, String email, String cargo, double sueldo, String usuario, String contrasenia) {
        
        Empleado empleado = new Empleado();
        Usuario user = new Usuario();
        
        //Creo al empleado
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        empleado.setFechaNac(fechaNac);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
                
        //Creo el usuario
        user.setNombreUsuario(usuario);
        user.setContrasenia(contrasenia);
        
        //Asigno el usuario y contraña al empleado creado
        empleado.setUser(user);
        
        //Envio mis objetos para que puedan ser creados en persistencia
        controlPersis.crearEmpleado(empleado, user);
    }
    
    //traer Empleados
    
    public List<Empleado> traerEmpleados(){
        return controlPersis.traerEmpleados();
    }
    
    //==========================================================================
    //metodos para Servicio
    // Alta
    public void crearServicio(String nombre, String descripcion, String destino, double costo, Date fecha) {
        
        ServicioTuristico servicio = new ServicioTuristico();
        
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setDestino(destino);
        servicio.setCosto(costo);
        servicio.setFecha(fecha);
        
        controlPersis.crearServicio(servicio);
    }
    
    //traer servicios
    
    public List<ServicioTuristico> traerServicios(){
        return controlPersis.traerServicios();
    }
    
    
    
    //==========================================================================
    //metodos para Cliente
    //Alta
    public void crearCliente(String nombre, String apellido, String direccion, String dni, Date fecha, String nacionalidad, String celular, String email) {
        
        Cliente cliente = new Cliente();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFechaNac(fecha);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        
        controlPersis.crearCliente(cliente);
    }
    
    //traer clientes
    
    public List<Cliente> traerClientes(){
        return controlPersis.traerClientes();
    }
    
    
}
