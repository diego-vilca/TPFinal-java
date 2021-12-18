
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
import logica.Controladora;
import logica.Venta;

@WebServlet(name = "SvVentaEliminar", urlPatterns = {"/SvVentaEliminar"})
public class SvVentaEliminar extends HttpServlet {

    Controladora control= new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Venta> listaVentas = control.traerVentas();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaVentas", listaVentas);
        response.sendRedirect("eliminarVentas.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codVenta = Integer.parseInt(request.getParameter("codVenta"));
        
        control.borrarVenta(codVenta);
        
        //envio la lista actualizada de ventas
        request.getSession().setAttribute("listaVentas", control.traerVentas());
        
        response.sendRedirect("eliminarVentas.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
