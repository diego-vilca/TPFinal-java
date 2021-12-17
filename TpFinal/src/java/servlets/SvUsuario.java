
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;


@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            //log out
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", null);
            misession.setAttribute("contra", null);
            
            response.sendRedirect("index.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("user");
        String contrasenia = request.getParameter("pass");
        
        Controladora control = new Controladora();
        boolean autorizado = control.verificarUsuario(usuario,contrasenia);
        
        //log in
        if(autorizado == true){
            //obtengo la session y le asigno usuario y contraseña para validar
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contra", contrasenia);
            
            List<Empleado> listaEmple = control.traerEmpleados();
            
            for (Empleado empleado : listaEmple) {
                if (empleado.getUser().getNombreUsuario().equals(usuario)) {
                    misession.setAttribute("empleado", empleado);
                    break;
                }
            }
            
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
