
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.ServicioTuristico;


@WebServlet(name = "SvServicioEliminar", urlPatterns = {"/SvServicioEliminar"})
public class SvServicioEliminar extends HttpServlet {
    
    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ServicioTuristico> servicios = control.traerServicios();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", servicios);
        response.sendRedirect("eliminarServicios.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        //borro el servicio con el codigo correspondiente
        control.borrarServicio(codigo);
        
        //envio la lista actualizada de empleados
        request.getSession().setAttribute("listaServicios", control.traerServicios());
        
        response.sendRedirect("eliminarServicios.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
