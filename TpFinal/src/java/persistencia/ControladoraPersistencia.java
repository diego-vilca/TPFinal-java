
package persistencia;

import logica.Empleado;
import logica.Usuario;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController userJpa = new UsuarioJpaController();
    ServicioTuristicoJpaController servicioJpa = new ServicioTuristicoJpaController();
    
    //==========================================================================
    //métodos para los empleados
    
    public void crearEmpleado(Empleado empleado, Usuario user) {
        userJpa.create(user);
        empleadoJpa.create(empleado);
    }
    
    
    
    
    //==========================================================================
    //métodos para los servicios
    
    
    
}
