
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

@WebServlet(name = "SvPaqueteEliminar", urlPatterns = {"/SvPaqueteEliminar"})
public class SvPaqueteEliminar extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<PaqueteTuristico> paquetes = control.traerPaquetes();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaPaquetes", paquetes);
        response.sendRedirect("eliminarPaquetes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        //borro el empleado con la id correspondiente
        control.borrarPaquete(codigo);
        
        //actualizo la variable de sesión con los paquetes actualizados
        request.getSession().setAttribute("listaPaquetes", control.traerPaquetes());
        
        response.sendRedirect("eliminarPaquetes.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
