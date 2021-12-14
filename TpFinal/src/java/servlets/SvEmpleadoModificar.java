
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;
import logica.Usuario;


@WebServlet(name = "SvEmpleadoModificar", urlPatterns = {"/SvEmpleadoModificar"})
public class SvEmpleadoModificar extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //id
        int id = Integer.parseInt(request.getParameter("id"));
        //nombre
        String nombre = request.getParameter("txtNombre");
        //apellido
        String apellido = request.getParameter("txtApellido");
        //direccion
        String direccion = request.getParameter("txtDireccion");
        //dni
        String dni = request.getParameter("txtDni");
        //fecha de nacimiento
        String fechaNac = request.getParameter("txtFechaNac");
        //nacionalidad
        String nacionalidad = request.getParameter("cboNac");
        //celular
        String celular = request.getParameter("txtCelular");
        //email
        String email = request.getParameter("txtEmail");
        //cargo
        String cargo = request.getParameter("txtCargo");
        //sueldo
        double sueldo = Double.parseDouble(request.getParameter("txtSueldo"));
        //usuario
        String usuario = request.getParameter("txtUsuario");
        //contrasenia
        String contrasenia = request.getParameter("txtContrasenia");
        
        //busco al empleado correspondiente
        Empleado emple = control.buscarEmpleado(id);
        //creo un usuario
        Usuario usu = new Usuario();
        
        
        //seteo los cambios a mi empleado
        
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDireccion(direccion);
        emple.setDni(dni);
        
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
        try {
            fecha = formato.parse(fechaNac);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }
        
        emple.setFechaNac(fecha);
        emple.setNacionalidad(nacionalidad);
        emple.setCelular(celular);
        emple.setEmail(email);
        emple.setCargo(cargo);
        emple.setSueldo(sueldo);
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contrasenia);
        emple.setUser(usu);
        
        control.ModificarEmpleado(emple);
        
        //actualizo mi lista de empleados
        request.getSession().setAttribute("listaEmpleados", control.traerEmpleados());
        response.sendRedirect("modificarEmpleados.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //traigo id
        int id = Integer.parseInt(request.getParameter("id"));
        
        //busco al empleado
        Empleado emple =  control.buscarEmpleado(id);
        
        HttpSession misession = request.getSession();
        //envio al empleado
        misession.setAttribute("empleado", emple);
        
        response.sendRedirect("modificarEmpleado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
