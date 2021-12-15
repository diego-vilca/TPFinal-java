
<%@page import="logica.PaqueteTuristico"%>
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
  	<title>Modificar paquetes</title>
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
                            <h4 class="text-center mb-4 titulo">Lista de Paquetes</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
                                            
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                    <th></th>
                                                    <th>Código de paquete</th>
                                                    <th>Paquete</th>
                                                    <th>Costo del paquete</th>
					      </tr>
					    </thead>
					    <tbody>
					      <% HttpSession misession = request.getSession();

                                                List<PaqueteTuristico> listaPaquetes = (List) misession.getAttribute("listaPaquetes");
                                                for(PaqueteTuristico paquete : listaPaquetes) { %>
					      <tr>
                                                                                                
                                                
					        <% List<ServicioTuristico> listaServ = paquete.getListaServicios(); %>
                                                
                                                <% int codigo = paquete.getCodigoPaquete(); %>
                                                <th>
                                                    <form action="SvPaqueteModificar" method="post">
                                                        <input type="hidden" name="codigo" value="<%=codigo%>">
                                                        <button type="submit" class="btn btn-warning">Modificar</button>
                                                    </form>
                                                    
                                                </th>
					        <td scope="row" class="scope" ><%=codigo %></td>
                                                
                                                <td>
                                                    <select class="form-control" name="cboNombre"">
                                                        <% for (ServicioTuristico servicio : listaServ) {%>
                                                            
                                                            <% String nombreServ = servicio.getNombre(); %>
                                                                <option><%=nombreServ %></option>    
                                                            
                                                        <% } %>
                                                            
                                                    </select>
                                                </td>
                                                
                                                <% double costo = paquete.getCosto(); %>
					        <td>$<%=costo%></td>
                                                
					        <!--<td><a href="#" class="btn btn-primary">Sign Up</a></td>-->
					      </tr>
                                              <% } %>
					    </tbody>
					  </table>
                                           
                                            
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
</html>