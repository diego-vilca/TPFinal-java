<!-- Se puede sacar @page contentType="text/html" pageEncoding="UTF-8" para evitar problemas con tildes 
si tenemos jsp en la parte de arriba-->
<%@page import="logica.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<!doctype html>
<html lang="es">
  <head>
  	<title>Eliminar Clientes</title>
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
                            <h4 class="text-center mb-4 titulo">Lista de clientes</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                    <th></th>
                                                    <th>Cliente</th>
                                                    <th>Id</th>
                                                    <th>Dirección</th>
                                                    <th>DNI</th>
                                                    <th>Nacionalidad</th>
                                                    <th>Fecha de Nacimiento</th>
                                                    <th>Celular</th>
                                                    <th>Email</th>
					      </tr>
					    </thead>
					    <tbody>
					      <% HttpSession misession = request.getSession();

                                                List<Cliente> listaClientes = (List) misession.getAttribute("listaClientes");
                                                for(Cliente cliente : listaClientes) { %>
					      
                                            <tr>
                                                   <!-- obtengo id -->
                                                <% int id = cliente.getId(); %>
                                                <th>
                                                    <form action="SvClienteEliminar" method="post">
                                                        <input type="hidden" name="id" value="<%=id%>">
                                                        <button type="submit" class="btn btn-danger">Eliminar</button>
                                                    </form>
                                                    
                                                </th>
                                                <% String nomApe = cliente.getNombre() + " " + cliente.getApellido(); %>
					        <td scope="row" class="scope" ><%=nomApe %></td>
                                                
                                                <td scope="row" class="scope" ><%=id %></td>
					        <% String direccion = cliente.getDireccion(); %>
                                                <td><%=direccion %></td>
                                                <% String dni = cliente.getDni(); %>
					        <td><%=dni %></td>
                                                <% String nac = cliente.getNacionalidad(); %>
					        <td><%=nac%></td>
                                                <% Date fechaNac = cliente.getFechaNac(); 
                                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                %>
					        <td><%=df.format(fechaNac)%></td>
                                                <% String celular = cliente.getCelular(); %>
                                                <td><%=celular%></td>
                                                <% String email = cliente.getEmail(); %>
                                                <td><%=email%></td>
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

