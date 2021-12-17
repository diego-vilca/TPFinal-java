
package servlets;

import java.awt.SystemColor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;
import logica.Empleado;
import logica.Venta;


@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
    
    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> ventas = control.traerVentas();
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaVentas", ventas);
        response.sendRedirect("traerVentas.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        int id;
        
        
        //empleado que efectua la venta
        Empleado empleado = (Empleado)sesion.getAttribute("empleado");
        //cliente que efectua la compra
        Cliente cliente = (Cliente)sesion.getAttribute("cliente");
        //tipo de pedido que realiza
        String tipoVenta = request.getParameter("tipoVenta");
        //medio de pago
        String medioPago = request.getParameter("cboPago");
        
        if (tipoVenta.equals("servicio")) {
            id = Integer.parseInt(request.getParameter("selServicio"));
        }else{
            id = Integer.parseInt(request.getParameter("selPaquete"));
        }
        
        control.crearVenta(id, empleado, cliente, medioPago, tipoVenta);
        
        //Redirecciono a mostrar ventas
        doGet(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
