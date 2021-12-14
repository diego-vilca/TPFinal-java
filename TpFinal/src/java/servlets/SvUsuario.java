
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    
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
        
        String usuario = request.getParameter("user");
        String contrasenia = request.getParameter("pass");
        
        Controladora control = new Controladora();
        boolean autorizado = control.verificarUsuario(usuario,contrasenia);
        
        if(autorizado == true){
            //obtengo la session y le asigno usuario y contraseña para validar
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contra", contrasenia);
            
            response.sendRedirect("index.jsp");
            
        }else {
            response.sendRedirect("login.jsp");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
