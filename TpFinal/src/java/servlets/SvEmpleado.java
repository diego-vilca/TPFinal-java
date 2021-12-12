
package servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
    //controladora de la lógica
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String dni = request.getParameter("txtDni");
        Date fecha = Date.valueOf(request.getParameter("txtFechaNac"));
        String nacionalidad = request.getParameter("cboNac");
        String celular = request.getParameter("txtCelular");
        String email = request.getParameter("txtEmail");
        String cargo = request.getParameter("txtCargo");
        double sueldo = Double.parseDouble(request.getParameter("txtSueldo"));
        String usuario = request.getParameter("txtUsuario");
        String contrasenia = request.getParameter("txtContrasenia");
        
        control.crearEmpleado(nombre, apellido, direccion, dni, fecha, nacionalidad, celular, email, cargo, sueldo, usuario, contrasenia);
                    
        //Redirecciono al index
        response.sendRedirect("index.jsp");
            
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
