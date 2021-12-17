
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
import logica.PaqueteTuristico;
import logica.ServicioTuristico;


@WebServlet(name = "SvVerificarCliente", urlPatterns = {"/SvVerificarCliente"})
public class SvVerificarCliente extends HttpServlet {

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
        
        //Dni del cliente a verificar existencia
        String dni = request.getParameter("txtDni");
        Cliente miCliente = new Cliente();
        boolean encontrado = false;
        
        //Traigo todos mis clientes registrados
        List<Cliente> listaClientes = control.traerClientes();
        
        //verifico si el dni corresponde a un cliente registrado
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                miCliente = cliente;
                encontrado = true;
                break;
            }
        }
        
        
        if (encontrado) {
            //Si lo encontre redirijo a la venta
            HttpSession misession = request.getSession();
            misession.setAttribute("cliente", miCliente);
            misession.setAttribute("listaServicios", control.traerServicios());
            misession.setAttribute("listaPaquetes", control.traerPaquetes());
            response.sendRedirect("altaVentas.jsp");
        }else{
            //sino redirijo al jsp de alta de clientes
            response.sendRedirect("altaClientes.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
