
package logica;

import java.sql.Date;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
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
    
}
