
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
import logica.Cliente;
import logica.Controladora;


@WebServlet(name = "SvClienteModificar", urlPatterns = {"/SvClienteModificar"})
public class SvClienteModificar extends HttpServlet {
    
    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //id
        int id = Integer.parseInt(request.getParameter("id"));
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");
        String dni = request.getParameter("txtDni");
        String fechaNac = request.getParameter("txtFechaNac");
        String nacionalidad = request.getParameter("cboNac");
        String celular = request.getParameter("txtCelular");
        String email = request.getParameter("txtEmail");
        
        //===============================================
        //busco al empleado correspondiente
        Cliente cliente = control.buscarCliente(id); 
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        cliente.setNacionalidad(nacionalidad);
        
        //Convierto el string fecha a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha= new Date();
        
        try {
            fecha = formato.parse(fechaNac);
        } catch (Exception e) {
            //imprimo la excepción
            e.printStackTrace();
        }
        
        cliente.setFechaNac(fecha);
        
        //===============================================
        
        control.modificarCliente(cliente);
        
        
        //actualizo mi lista de clientes
        request.getSession().setAttribute("listaClientes", control.traerClientes());
        response.sendRedirect("modificarClientes.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //traigo id
        int id = Integer.parseInt(request.getParameter("id"));
        
        //busco al cliente
        Cliente cliente =  control.buscarCliente(id);
        
        HttpSession misession = request.getSession();
        //envio al empleado
        misession.setAttribute("cliente", cliente);
        
        response.sendRedirect("modificarCliente.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
