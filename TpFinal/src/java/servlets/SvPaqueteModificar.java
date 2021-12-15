
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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


@WebServlet(name = "SvPaqueteModificar", urlPatterns = {"/SvPaqueteModificar"})
public class SvPaqueteModificar extends HttpServlet {

    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //codigo
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        //Obtengo los values de mis checkbox que serian los ids de los servicios del paquete
        String[] listaIds= request.getParameterValues("servId");
        
//        test    
//        for (int i = 0; i < listaIds.length; i++) {
//            System.out.println(listaIds[i]);
//        }

        //traigo mi paquete
        PaqueteTuristico paquete = control.buscarPaquete(codigo);
        //nueva lista para los servicios actualizados, para evitar primary keys duplicadas
        paquete.setListaServicios(new ArrayList<ServicioTuristico>()); 
        
        
        //variables auxiliares para el calculo del costo total del paquete
        double costoAcum = 0;
        double costoFinal = 0;
        
        //Traigo los servicios existentes
        List<ServicioTuristico> listaServicios = control.traerServicios();
        
        //comparo las ids con los servicios de los checkbox y si coinciden, agrego al paquete
        for (ServicioTuristico servicio : listaServicios) {
            for (String id : listaIds) {
                //casteo el id a double y comparo
                int servId = Integer.parseInt(id);
                
                if (servicio.getCodigo() == servId) {
                    //agrego el servicio al paquete
                    paquete.agregarServicio(servicio);
                    //acumulo el costo
                    costoAcum += servicio.getCosto();
                }
            }
        }
        
        //calculo el costo final
        costoFinal = costoAcum - (costoAcum * 0.1);
        
        //asigno el costo al paquete
        paquete.setCosto(costoFinal);
        
        
        //===============================================
        
        control.modificarPaquete(paquete);
        
        //actualizo mi lista de empleados
        request.getSession().setAttribute("listaPaquetes", control.traerPaquetes());
        response.sendRedirect("modificarPaquetes.jsp");
                
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //traigo codigo
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        //busco el paquete
        PaqueteTuristico paquete =  control.buscarPaquete(codigo);
        
        HttpSession misession = request.getSession();
        
        //Envio la lista de servicios
        List<ServicioTuristico> servicios = control.traerServicios();
        misession.setAttribute("listaServicios", servicios);
        //envio el paquete
        misession.setAttribute("paquete", paquete);
        
        response.sendRedirect("modificarPaquete.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
