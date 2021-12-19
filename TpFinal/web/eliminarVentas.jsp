
<%@page import="logica.Empleado"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.Venta"%>
<%@page import="logica.ServicioTuristico"%>
<!-- Se puede sacar @page contentType="text/html" pageEncoding="UTF-8" para evitar problemas con tildes 
si tenemos jsp en la parte de arriba-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<!doctype html>
<html lang="es">
  <head>
  	<title>Eliminar Venta</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/tabla/css/style.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
                            <h4 class="text-center mb-4 titulo">Listado de Ventas</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                    <th></th>
                                                    <th>N° de Venta</th>
                                                    <th>Fecha</th>
                                                    <th>Medio de Pago</th>
                                                    <th>Cliente</th>
                                                    <th>Empleado</th>
                                                    <th>Servicio</th>
                                                    <th>Paquete</th>
                                                    <th>Costo</th>
					      </tr>
					    </thead>
					    <tbody>
					      <% HttpSession misession = request.getSession();

                                                List<Venta> listaVentas = (List) misession.getAttribute("listaVentas");
                                                for(Venta venta : listaVentas) { %>
					      <tr>
                                                <% int numVenta = venta.getNumVenta(); %>
                                                <th>
                                                    <form action="SvVentaEliminar" method="post">
                                                        <input type="hidden" name="codVenta" value="<%=numVenta%>">
                                                        <button type="submit" class="btn btn-danger">Eliminar</button>
                                                    </form>
                                                    
                                                </th>
                                                
					        <td scope="row" class="scope" ><%=numVenta %></td>
                                                <% Date fecha = venta.getFechaVenta(); 
                                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                %>
					        <td><%=df.format(fecha)%></td>
                                                <% String mPago = venta.getMedioPago(); %>
                                                <td scope="row" class="scope" ><%=mPago %></td>
					        <% Cliente cliente = venta.getCliente(); %>
                                                <% String nomCliente = cliente.getNombre()+ " " + cliente.getApellido();%>
                                                <td><%=nomCliente%></td>
                                                <% Empleado empleado = venta.getEmpleado();%>
                                                <% String nomEmple = empleado.getNombre()+ " " + empleado.getApellido();%>
                                                <td><%=nomEmple%></td>
                                                <% 
                                                    String servicio;
                                                    
                                                    try {
                                                        servicio = venta.getServicio().getNombre();
                                                    } catch (Exception e) {
                                                        servicio = "-";
                                                    }
                                                            
                                                        
                                                %>
					        <td><%=servicio %></td>
                                                
                                                <td>
                                                    <%
                                                        
                                                      try {
                                                          
                                                          //Si no hay paquete, no muestro el select
                                                            if (venta.getPaquete().getListaServicios() == null) {
                                                    %>          <script>
                                                                    let e = document.getElementById('sPaquete');
                                                                    e.style.visibility = 'hidden';
                                                                </script><%
                                                            }
                                                    %>
                                                            
                                                      
                                                           <select class="form-control" name="cboNombre" id="sPaquete" >
                                                    
                                                        <% for (ServicioTuristico serv : venta.getPaquete().getListaServicios()) {%>
                                                            
                                                            <% String nombreServ = serv.getNombre(); %>
                                                            
                                                            <option id="nomServ" ><%=nombreServ %></option>    
                                                            
                                                        <% } %>
                                                            
                                                           </select>   
                                                          <%} catch (Exception e) {
                                                                
                                                                %><span>-</span><%
                                                          }
  
                                                    %>
                                                    
                                                </td>
                                                
                                                <td>
                                                    <%
                                                        try {
                                                                %><span><%=venta.getServicio().getCosto()%></span><%
                                                                    
                                                            } catch (Exception e) {
                                                                %><span><%=venta.getPaquete().getCosto()%></span><%
                                                            }
                                                    %>
                                                </td>
                                                
					        <!--<td><a href="#" class="btn btn-primary">Sign Up</a></td>-->
					      </tr>
                                              <% } %>
					    </tbody>
					  </table>
                                            
					</div>  
				</div>
			</div>
                    <div class="d-flex justify-content-between">
                            <div class="justify-content-center">
                                    <a href="index.jsp" class="btn btn-primary btn-lg">Ir a la Página Principal</a>
                            </div>  
                            
                            <div class="justify-content-center">
                                    <a href="venta.jsp" class="btn btn-primary btn-lg">Realizar Venta</a>
                            </div>  
                    </div>    
                                            
		</div>
	</section>
                                           

	<script src="assets/tabla/js/jquery.min.js"></script>
  <script src="assets/tabla/js/bootstrap.min.js"></script>
  <script src="assets/tabla/js/main.js"></script>

	</body>
</html>
