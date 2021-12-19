<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Modificar Empleados</title>
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
                            <h4 class="text-center mb-4 titulo">Lista de Empleados</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
						<table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                  
                                                    <th></th>
                                                    <th>Empleado</th>
                                                    <th>Id</th>
                                                    <th>Dirección</th>
                                                    <th>DNI</th>
                                                    <th>Nacionalidad</th>
                                                    <th>Fecha de Nacimiento</th>
                                                    <th>Celular</th>
                                                    <th>Email</th>
                                                    <th>Cargo</th>
                                                    <th>Sueldo</th>
					      </tr>
					    </thead>
					    <tbody>
					      <% HttpSession misession = request.getSession();

                                                List<Empleado> listaEmpleados = (List) misession.getAttribute("listaEmpleados");
                                                for(Empleado emp : listaEmpleados) { %>
					      <tr>
                                                  <!-- obtengo id -->
                                                <% int id = emp.getId(); %>
                                                <th>
                                                    <form action="SvEmpleadoModificar" method="post">
                                                        <input type="hidden" name="id" value="<%=id%>">
                                                        <button type="submit" class="btn btn-warning">Modificar</button>
                                                    </form>
                                                    
                                                </th>
                                                
                                                <!-- nombre y apellido -->
                                                <% String nomApe = emp.getNombre() + " " + emp.getApellido(); %>
					        <td scope="row" class="scope" ><%=nomApe %></td>
                                                <!-- id -->
                                                <td scope="row" class="scope" ><%=id %></td>
                                                <!-- direccón -->
					        <% String direccion = emp.getDireccion(); %>
                                                <td><%=direccion %></td>
                                                <!-- dni -->
                                                <% String dni = emp.getDni(); %>
					        <td><%=dni %></td>
                                                <!-- nacionalidad -->
                                                <% String nac = emp.getNacionalidad(); %>
					        <td><%=nac%></td>
                                                <!-- fecha de nacimiento -->
                                                <% Date fechaNac = emp.getFechaNac(); 
                                                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                %>
					        <td><%=df.format(fechaNac)%></td>
                                                <!-- celular -->
                                                <% String celular = emp.getCelular(); %>
                                                <td><%=celular%></td>
                                                <!-- email -->
                                                <% String email = emp.getEmail(); %>
                                                <td><%=email%></td>
                                                <!-- cargo -->
                                                <% String cargo = emp.getCargo(); %>
                                                <td><%=cargo%></td>
                                                <!-- sueldo -->
                                                <% double sueldo = emp.getSueldo(); %>
                                                <td>$<%=sueldo%></td>
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
    <%}%>
    </body>
</html>


