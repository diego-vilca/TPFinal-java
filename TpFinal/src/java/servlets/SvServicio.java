
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
import logica.ServicioTuristico;


@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {

    //controladora de la lógica
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<ServicioTuristico> listaServicios = control.traerServicios();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("traerServicios.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         //recibo los datos
        String nombre = request.getParameter("cboNombre");
        String descripcion = request.getParameter("txtDescripcion");
        String destino = request.getParameter("cboDestino");
        double costo = Double.parseDouble(request.getParameter("txtCosto"));
        String fecha = request.getParameter("txtFecha");
        
        //paso los datos a mi lógica
        control.crearServicio(nombre, descripcion, destino, costo, fecha);
        
        //Redirecciono a mostrar servicios
        doGet(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
