
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
  	<title>Ver Paquetes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/tabla/css/style.css">
        

	</head>
	<body>
            <%
            
            
                HttpSession sesion = request.getSession();
                String usu = (String) sesion.getAttribute("usuario");
                
                    if(usu == null ){
                        response.sendRedirect("login.jsp");
                    }else{
            
                
            %>
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
                                                
                                                <% int id = paquete.getCodigoPaquete(); %>
					        <th scope="row" class="scope" ><%=id %></th>
                                                
                                                <td>
                                                    <select class="form-control" name="cboNombre" onchange="verDescripcion();">
                                                        <% for (ServicioTuristico servicio : listaServ) {%>
                                                            
                                                            <% String nombreServ = servicio.getNombre(); %>
                                                            <% String descripcion = servicio.getDescripcion(); %>
                                                            
                                                            <option id="nomServ" value="<%=descripcion%>"><%=nombreServ %></option>    
                                                            
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
                    <div class="d-flex justify-content-between">
                            <div class="justify-content-center">
                                    <a href="index.jsp" class="btn btn-primary btn-lg">Ir a la Página Principal</a>
                            </div>  
                            <div class="justify-content-center">
                                <form action="SvPaquete" method="GET">
                                    <a href="SvPaquete" class="btn btn-primary btn-lg">Agregar Paquete</a>
                                </form>
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
        
        <%}%>
	</body>
</html>