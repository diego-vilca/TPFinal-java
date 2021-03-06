
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Venta;


@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {
    //controladora de la lógica
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        processRequest(request, response);
        //obtengo el listado de clientes
        List<Cliente> listaClientes = control.traerClientes();
        
        //actualizo mi variable de session
        HttpSession misession = request.getSession();
        misession.setAttribute("listaClientes", listaClientes);
        //redirecciono
        response.sendRedirect("traerClientes.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtengo los datos del formulario
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String dni = request.getParameter("txtDni");
        String fecha = request.getParameter("txtFechaNac");
        String nacionalidad = request.getParameter("cboNac");
        String celular = request.getParameter("txtCelular");
        String email = request.getParameter("txtEmail");
        
        //envio los datos a mi lógica para crear a mi cliente
        control.crearCliente(nombre, apellido, direccion, dni, fecha, nacionalidad, celular, email);
        

        //redirijo al listado de clientes
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
