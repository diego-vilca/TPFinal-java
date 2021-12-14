
package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;


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
        
        List<Empleado> listaEmple = control.traerEmpleados();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaEmpleados", listaEmple);
        response.sendRedirect("traerEmpleados.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //nombre
        String nombre = request.getParameter("txtNombre");
        //apellido
        String apellido = request.getParameter("txtApellido");
        //direccion
        String direccion = request.getParameter("txtDireccion");
        //dni
        String dni = request.getParameter("txtDni");
        //fecha de nacimiento
        String fecha = request.getParameter("txtFechaNac");
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
        
        //llamo a mi controladora de la logica
        control.crearEmpleado(nombre, apellido, direccion, dni, fecha, nacionalidad, celular, email, cargo, sueldo, usuario, contrasenia);
                    
        //Redirecciono al index
        response.sendRedirect("index.jsp");
            
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
