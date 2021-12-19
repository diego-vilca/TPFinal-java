
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
import logica.PaqueteTuristico;
import logica.ServicioTuristico;


@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
    //controladora de la lógica
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        //Envio la lista de servicios a que se visualice en alta paquete
        List<ServicioTuristico> listaServicios = control.traerServicios();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("altaPaquetes.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Obtengo los values de mis checkbox que serian los ids de los servicios del paquete
        String[] listaIds= request.getParameterValues("servId");
        
        
        control.crearPaquete(listaIds);
        
        //Redirecciono a mostrar paquetes
        List<PaqueteTuristico> listaPaquete = control.traerPaquetes();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaPaquetes", listaPaquete);
        response.sendRedirect("traerPaquetes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
