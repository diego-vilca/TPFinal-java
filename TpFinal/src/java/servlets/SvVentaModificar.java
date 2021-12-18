
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
        //numVenta
        int numVenta = Integer.parseInt(request.getParameter("numVenta"));
        //tipo de pedido que realiza
        String tipoVenta = request.getParameter("tipoVenta");
        //busco mi venta
        Venta venta = control.buscarVenta(numVenta);
        
        //Obtengo la fecha actual
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        String fechaStr = formatter.format(date);  
        
        //Obtengo la fecha actual en tipo Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
            try {
                fecha = formato.parse(fechaStr);
            } catch (Exception e) {
                //imprimo la excepción
                e.printStackTrace();
            }
        
        //seteo la fecha de la modificacion
        venta.setFechaVenta(fecha);
        
        //seteo el servicio o paquete a la venta
        if (tipoVenta.equals("servicio")) {
            int idServ = Integer.parseInt(request.getParameter("selServicio"));
            venta.setServicio(control.buscarServicio(idServ));
            venta.setPaquete(null);
        }else{
            int idPaq = Integer.parseInt(request.getParameter("selPaquete"));
            venta.setPaquete(control.buscarPaquete(idPaq));
            venta.setServicio(null);
        }
        
        //seteo medio de pago
        venta.setMedioPago(request.getParameter("cboPago"));
        
        //==================================================
        
        control.modificarVenta(venta);
        
        //actualizo mi lista de empleados
        request.getSession().setAttribute("listaVentas", control.traerVentas());
        response.sendRedirect("modificarVentas.jsp");
        
       
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
