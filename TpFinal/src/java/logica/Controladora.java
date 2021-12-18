
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    //==========================================================================
    //metodos para Empleado
    // Alta
    
    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, String fechaNac, String nacionalidad, String celular, String email, String cargo, double sueldo, String usuario, String contrasenia) {
        
        Empleado empleado = new Empleado();
        Usuario user = new Usuario();
        
        //Creo al empleado
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
        try {
            fecha = formato.parse(fechaNac);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }
        empleado.setFechaNac(fecha);
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
    
    
    //Borrar empleado
    public void borrarEmpleado(int id) {
        controlPersis.borrarEmpleado(id);
    }
    
    
    //Buscar empleado
    public Empleado buscarEmpleado(int id) {
        return controlPersis.buscarEmpleado(id);
    }
    
    //Modificar empleado
    public void modificarEmpleado(Empleado emple) {
        controlPersis.modificarEmpleado(emple);
    }

    
    //==========================================================================
    //metodos para Servicio
    // Alta
    
    public void crearServicio(String nombre, String descripcion, String destino, double costo, String fecha) {
        
        ServicioTuristico servicio = new ServicioTuristico();
        
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setDestino(destino);
        servicio.setCosto(costo);
        
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaF= new Date();
        
        try {
            fechaF = formato.parse(fecha);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }

        
        //asigno la fecha al servicio
        servicio.setFecha(fechaF);
        
        controlPersis.crearServicio(servicio);
    }
    
    //Traer servicios
    public List<ServicioTuristico> traerServicios(){
        return controlPersis.traerServicios();
    }
    
    //Eliminar servicio
    public void borrarServicio(int codigo) {
        controlPersis.borrarServicio(codigo);
    }
    
    //Buscar servicio
    public ServicioTuristico buscarServicio(int id) {
        return  controlPersis.buscarServicio(id);
    }
    
    //Modificar servicio
    public void modificarServicio(ServicioTuristico servicio) {
        controlPersis.modificarServicio(servicio);
    }
    
    //==========================================================================
    //metodos para Cliente
    //Alta
    
    public void crearCliente(String nombre, String apellido, String direccion, String dni, String fechaNac, String nacionalidad, String celular, String email) {
        
        Cliente cliente = new Cliente();
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
          
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
        try {
            fecha = formato.parse(fechaNac);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }
        cliente.setFechaNac(fecha);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        
        controlPersis.crearCliente(cliente);
    }
    
    
    //Muestro clientes
    
    public List<Cliente> traerClientes(){
        return controlPersis.traerClientes();
    }
    
    
    //Borrar cliente
    public void borrarCliente(int id) {
        controlPersis.borrarCliente(id);
    }
    
    //Buscar cliente
    public Cliente buscarCliente(int id) {
        return controlPersis.buscarCliente(id);
    }
    
    //Modificar
    public void modificarCliente(Cliente cliente) {
        controlPersis.modificarCliente(cliente);
    }
    
    //==========================================================================
    //Metodos para Usuario
    
    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuario = controlPersis.traerUsuario();
        
        if (listaUsuario != null) {
            for (Usuario usu : listaUsuario) {
                if (usu.getNombreUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {
                    return true;
                }
            }
            
            
        }
        
        return false;
    }
    
    public void borrarUsuario(int idUser) {
        controlPersis.borrarUsuario(idUser);
    }
    
    //==========================================================================
    //Metodos para Paquetes
    //Alta

    public void crearPaquete(String[] listaIds) {
        //creo un paquete
        PaqueteTuristico paquete = new PaqueteTuristico();
        //costo total del paquete
        double costoAcum = 0;
        double costoFinal = 0;
        
        //Traigo los servicios
        List<ServicioTuristico> listaServicios = traerServicios();
        
        
        for (ServicioTuristico servicio : listaServicios) {
            for (String id : listaIds) {
                //casteo el id a double y comparo
                double servId = Double.parseDouble(id);
                
                if (servicio.getCodigo() == servId) {
                    //agrego el servicio al paquete
                    paquete.agregarServicio(servicio);
                    //acumulo el costo
                    costoAcum += servicio.getCosto();
                }
            }
        }
        
        //calculo el costo final
        costoFinal = costoAcum - (costoAcum * 0.1);
        
        //asigno el costo al paquete
        paquete.setCosto(costoFinal);
        
        
        controlPersis.crearPaquete(paquete);
        
    }

    // Muesta los paquetes
    public List<PaqueteTuristico> traerPaquetes() {
        return controlPersis.traerPaquetes();
    }

    //Borrar paquete
    public void borrarPaquete(int codigo) {
        controlPersis.borrarPaquete(codigo);
    }
    
    //Buscar paquete
    public PaqueteTuristico buscarPaquete(int codigo) {
        return controlPersis.buscarPaquete(codigo);
    }

    //Modificar paquete
    public void modificarPaquete(PaqueteTuristico paquete) {
        controlPersis.modificarPaquete(paquete);
    }
    
    
    //==========================================================================
    //Metodos para la venta

    public void crearVenta(int id, Empleado empleado, Cliente cliente, String medioPago, String tipoVenta) {
        
        Venta miVenta = new Venta();
        ServicioTuristico auxS = new ServicioTuristico();
        PaqueteTuristico auxP = new PaqueteTuristico();
        
        //Obtengo la fecha actual
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        String fechaStr = formatter.format(date);  
        
        //Obtengo la fecha actual en tipo Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
            try {
                fecha = formato.parse(fechaStr);
            } catch (Exception e) {
                //imprimo la excepción
                e.printStackTrace();
            }
        
        //Creo la venta
        if (tipoVenta.equals("servicio")) {
            //obtengo mi servicio
            ServicioTuristico servicio = buscarServicio(id);
            
            miVenta.setServicio(servicio);
            miVenta.setCliente(cliente);
            miVenta.setEmpleado(empleado);
            miVenta.setMedioPago(medioPago);
            miVenta.setFechaVenta(fecha);
            
            //agrego la venta a mi servicio
//            servicio.agregarVenta(miVenta);
            auxS = servicio;
            
        }else{
            //obtengo mi paquete
            PaqueteTuristico paquete = buscarPaquete(id);
            
            miVenta.setPaquete(paquete);
            miVenta.setCliente(cliente);
            miVenta.setEmpleado(empleado);
            miVenta.setMedioPago(medioPago);
            miVenta.setFechaVenta(fecha);
            
            //agrego la venta a mi paquete
//            paquete.agregarVenta(miVenta);
            auxP = paquete;
        }
        
        controlPersis.crearVenta(miVenta);
        
        //Agrego la venta al empleado y al cliente
        empleado.agregarVenta(miVenta);
        cliente.agregarVenta(miVenta);
        auxS.agregarVenta(miVenta);
        auxP.agregarVenta(miVenta);
    }

    //Mostrar ventas
    public List<Venta> traerVentas() {
        return controlPersis.traerVentas();
    }

    public void borrarVenta(int codVenta) {
        controlPersis.borrarVenta(codVenta);
    }

    public Venta buscarVenta(int codigo) {
        return controlPersis.buscarVenta(codigo);
    }

    

    

    

    

    

    

    

    

    
    



    
}
