
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;


@WebServlet(name = "SvClienteEliminar", urlPatterns = {"/SvClienteEliminar"})
public class SvClienteEliminar extends HttpServlet {
    
    Controladora control = new Controladora();

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        List<Cliente> listaCliente = control.traerClientes();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaClientes", listaCliente);
        response.sendRedirect("eliminarClientes.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        //borro el empleado con la id correspondiente
        control.borrarCliente(id);
        
        //envio la lista actualizada de empleados
        request.getSession().setAttribute("listaClientes", control.traerClientes());
        
        response.sendRedirect("eliminarClientes.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
