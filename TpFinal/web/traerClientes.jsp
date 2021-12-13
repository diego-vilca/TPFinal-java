
<!-- Se puede sacar @page contentType="text/html" pageEncoding="UTF-8" para evitar problemas con tildes 
si tenemos jsp en la parte de arriba-->
<%@page import="logica.Cliente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Table V05</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="tabla/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="tabla/css/util.css">
	<link rel="stylesheet" type="text/css" href="tabla/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="titulo">Listado de clientes</h2>
					</div>
				</div>
				<div class="table100 ver1">					
					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row100 head">
                                                                                <th class="cell100 column2">Clientes</th>
										<th class="cell100 column2">Dirección</th>
										<th class="cell100 column2">DNI</th>
										<th class="cell100 column2">Nacionalidad</th>
										<th class="cell100 column2">Fecha de Nacimiento</th>
										<th class="cell100 column2">Celular</th>
										<th class="cell100 column2">Email</th>
								</thead>
								<tbody>
                                                                        <% Controladora control = new Controladora();

                                                                        List<Cliente> listaClientes = control.traerClientes(); 
									for(Cliente emp : listaClientes) { %>
										<tr class="row100 body">
                                                                                        <% String nomApe = emp.getNombre() + " " + emp.getApellido(); %>
                                                                                        <td class="cell100 column2"><%=nomApe %></td>
											<% String direccion = emp.getDireccion(); %>
											<td class="cell100 column2"><%=direccion %></td>
											<% String dni = emp.getDni(); %>
											<td class="cell100 column2"><%=dni %></td>
											<% String nac = emp.getNacionalidad(); %>
											<td class="cell100 column2"><%=nac%></td>
											<% Date fechaNac = emp.getFechaNac(); 
                                                                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                                                        %>
											<td class="cell100 column2"><%=df.format(fechaNac)%></td>
											<% String celular = emp.getCelular(); %>
											<td class="cell100 column2"><%=celular%></td>
											<% String email = emp.getEmail(); %>
											<td class="cell100 column2"><%=email%></td>

										</tr>
									<% } %>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
						<a href="index.jsp" class="btn-volver">Volver a la Página Principal</a>
					
				</div>
			</div>
		</div>
	</div>


<!--===============================================================================================-->	
	<script src="tabla/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
        <script src="tabla/vendor/bootstrap/js/popper.js"></script>
	<script src="tabla/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="tabla/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="tabla/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})

			$(this).on('ps-x-reach-start', function(){
				$(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
			});

			$(this).on('ps-scroll-x', function(){
				$(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
			});

		});

		
		
		
	</script>
<!--===============================================================================================-->
	<script src="tabla/js/main.js"></script>

</body>
</html>
