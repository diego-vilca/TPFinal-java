<%@page import="logica.PaqueteTuristico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<!doctype html>
<html lang="es">
  <head>
  	<title>Ver Servicios</title>
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
                            <h4 class="text-center mb-4 titulo">Modificar paquete</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
                                            <form action="SvPaqueteModificar" method="get">
                                                <% HttpSession misession = request.getSession();
                                                        PaqueteTuristico paquete = (PaqueteTuristico) misession.getAttribute("paquete");%>
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                    <th>Selección</th>
                                                    <th>id</th>
                                                    <th>Servicio</th>
                                                    <th>Descripción</th>
                                                    <th>Destino</th>
                                                    <th>Costo</th>
                                                    <th>Fecha</th>
					      </tr>
					    </thead>
					    <tbody>
					      <% 

                                                List<ServicioTuristico> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                                                String checked= "";
                                                int flag = 0;
                                                
                                                for(ServicioTuristico servicio : listaServicios) { %>
					      <tr>
                                                        

                                                <% int codigo = servicio.getCodigo(); %>
                                                        
                                                            <% for (ServicioTuristico servPaquete : paquete.getListaServicios()) {
                                                                
                                                                      if (servicio.getCodigo() == servPaquete.getCodigo()) { 
                                                                                checked = "checked";
                                                                                flag = 1; %>
                                                                                <th scope="row" class="scope" >
                                                                                    <input type="checkbox" name="servId"  value="<%=codigo %>" checked="<%=checked%>" />
                                                                                </th>
                                                                               <%break;
                                                                      }
                                                                
                                                            }
                                                if (flag == 0) { %>
                                                    <th scope="row" class="scope" >
                                                        <input type="checkbox" name="servId"  value="<%=codigo %>" />
                                                    </th>
                                              <%  }
                                                 flag = 0; %>           
                                                
                                                <td scope="row" class="scope" ><%=codigo%></td> 
                                                <% String nombre = servicio.getNombre(); %>
					        <td scope="row" class="scope" ><%=nombre %></td>
					        <% String descripcion = servicio.getDescripcion(); %>
                                                <td><%=descripcion %></td>
                                                <% String destino = servicio.getDestino(); %>
					        <td><%=destino %></td>
                                                <% double costo = servicio.getCosto(); %>
					        <td>$<%=costo%></td>
                                                <% Date fecha = servicio.getFecha(); 
                                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                %>
					        <td><%=df.format(fecha)%></td>
					        <!--<td><a href="#" class="btn btn-primary">Sign Up</a></td>-->
					      </tr>
                                              <% } %>
					    </tbody>
					  </table>
                                            <div class="row justify-content-center">
                                                <input type="hidden" name="codigo" value="<%=paquete.getCodigoPaquete()%>"> 
                                                <div class="form-btn">
                                                    <button type="submit" class="btn btn-primary btn-lg">Modificar Paquete</button>
                                                </div>
                                            </div>
                                          </form>  
					</div>  
				</div>
			</div>
                    <div class="justify-content-center">
			<a href="index.jsp" class="btn-volver">Ir a la Página Principal</a>
                    </div>  
                                            
		</div>
	</section>
                                           

	<script src="assets/tabla/js/jquery.min.js"></script>
  <script src="assets/tabla/js/bootstrap.min.js"></script>
  <script src="assets/tabla/js/main.js"></script>

	</body>
</html>>