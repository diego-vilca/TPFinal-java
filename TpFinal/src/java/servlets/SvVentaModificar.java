
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.PaqueteTuristico;
import logica.Venta;


@WebServlet(name = "SvVentaModificar", urlPatterns = {"/SvVentaModificar"})
public class SvVentaModificar extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //traigo codigo
        int codigo = Integer.parseInt(request.getParameter("codVenta"));
        
        //busco el paquete
        Venta venta =  control.buscarVenta(codigo);
        HttpSession misession = request.getSession();
        
        System.out.println(venta.getMedioPago());
        
        //envio el paquete
        misession.setAttribute("venta", venta);
        misession.setAttribute("listaPaquetes", control.traerPaquetes());
        misession.setAttribute("listaServicios", control.traerServicios());
        
        response.sendRedirect("modificarVenta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
