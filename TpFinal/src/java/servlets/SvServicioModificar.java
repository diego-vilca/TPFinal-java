
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.ServicioTuristico;


@WebServlet(name = "SvServicioModificar", urlPatterns = {"/SvServicioModificar"})
public class SvServicioModificar extends HttpServlet {
    
    Controladora control =  new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //recibo el código de mi servicio
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        String nombre = request.getParameter("cboNombre");
        String descripcion = request.getParameter("txtDescripcion");
        String destino = request.getParameter("cboDestino");
        double costo = Double.parseDouble(request.getParameter("txtCosto"));
        String fecha = request.getParameter("txtFecha");
        
        //===============================================
        //busco al empleado correspondiente
        ServicioTuristico servicio = control.buscarServicio(codigo);
                
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setCosto(costo);
        servicio.setDestino(destino);
        
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate= new Date();
        
        try {
            fechaDate = formato.parse(fecha);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }
        servicio.setFecha(fechaDate);
        
        
        //===============================================
        
        control.modificarServicio(servicio);
        
        //actualizo mi lista de empleados
        request.getSession().setAttribute("listaServicios", control.traerServicios());
        response.sendRedirect("modificarServicios.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //traigo codigo
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        //busco al empleado
        ServicioTuristico servicio =  control.buscarServicio(codigo);
        
        HttpSession misession = request.getSession();
        //envio al empleado
        misession.setAttribute("servicio", servicio);
        
        response.sendRedirect("modificarServicio.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
