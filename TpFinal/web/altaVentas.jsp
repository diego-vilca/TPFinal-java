
<%@page import="logica.PaqueteTuristico"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.ServicioTuristico"%>
<!-- %@page import="logica.ServicioTuristico"% -->
<!-- Se puede sacar @page contentType="text/html" pageEncoding="UTF-8" para evitar problemas con tildes 
si tenemos jsp en la parte de arriba-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<!doctype html>
<html lang="es">
  <head>
  	<title>Ventas</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="assets/tabla/css/style.css">
        
        <script>
            function ocultar(x){
                if (x == 0) {
                    document.getElementById("divServicios").style.display = "block";
                    document.getElementById("divPaquetes").style.display = "none";
                }else{
                    document.getElementById("divServicios").style.display = "none";
                    document.getElementById("divPaquetes").style.display = "block";
                }
                
                return;
            }
        </script>
	</head>
	<body>
        <%
            
            
                HttpSession sesion = request.getSession();
                String usu = (String) sesion.getAttribute("usuario");
                //Obtengo el cliente para la venta
                Cliente cliente = (Cliente) sesion.getAttribute("cliente");
                
                    if(usu == null ){
                        response.sendRedirect("login.jsp");
                    }else{
            
                
            %>
            
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
                            <h4 class="text-center mb-4 titulo">Seleccionar Pedido</h4>
			</div>
			<div class="row">
				<div class="col-md-12">
                                        <div class="table-wrap">
                                            <p style="font-weight: bold;">-Datos del cliente:</p>
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
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
					      
					      <tr>
                                                <% String nomApe = cliente.getNombre() + " " + cliente.getApellido(); %>
					        <th scope="row" class="scope" ><%=nomApe %></th>
                                                <% int id = cliente.getId(); %>
                                                <td scope="row" class="scope" ><%=id %></td>
					        <% String direccion = cliente.getDireccion(); %>
                                                <td><%=direccion %></td>
                                                <% String dni = cliente.getDni(); %>
					        <td><%=dni %></td>
                                                <% String nac = cliente.getNacionalidad(); %>
					        <td><%=nac%></td>
                                                <% Date fechaNac = cliente.getFechaNac(); 
                                                SimpleDateFormat dfCliente = new SimpleDateFormat("dd/MM/yyyy");
                                                %>
					        <td><%=dfCliente.format(fechaNac)%></td>
                                                <% String celular = cliente.getCelular(); %>
                                                <td><%=celular%></td>
                                                <% String email = cliente.getEmail(); %>
                                                <td><%=email%></td>
					        <!--<td><a href="#" class="btn btn-primary">Sign Up</a></td>-->
					      </tr>
                                              
					    </tbody>
					  </table>
                                            
					</div>  
                                            <!-- /////////////////////////////////////////////////////////////// -->    
                                            <br><br>
                                            <div>
                                                <p style="font-weight: bold;">-Seleccione el tipo de venta:</p>
                                                <label class="radio-container m-r45">
                                                    <input type="radio" name="tipo" value="Servicio" onclick="ocultar(0)">
                                                    Servicio
                                                    <span class="checkmark"></span>
                                                </label>
                                                <br>
                                                <label class="radio-container m-r45">
                                                    <input type="radio" name="tipo" value="Paquete" onclick="ocultar(1)">
                                                    Paquete
                                                    <span class="checkmark"></span>
                                                </label>
                                            </div>
                                            <br><br>
                                        <!-- /////////////////////////////////////////////////////////////// -->    
                                        <div class="table-wrap" id="divPaquetes" style="display: none">
                                        
                                        <form action="SvVenta" method="POST">
                                            <span style="font-weight: bold;">-Método de pago</span>
                                            <div class="col-md-4">
                                                <select class="form-control" name="cboPago" required="required">
                                                        <option selected disabled></option>
                                                        <option>Efectivo</option>
                                                        <option>Tarjeta de Débito</option>
                                                        <option>Tarjeta de Crédito</option>
                                                        <option>Monedero Virtual</option>
                                                        <option>Transferencia</option>
                                                </select>
                                                
                                            </div>
                                                
                                        <br><br>    
                                        <p style="font-weight: bold;">-Seleccione el paquete:</p>
                                        
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
                                                                                                                                                
                                                <% int codPaquete = paquete.getCodigoPaquete(); %>
                                                <th cope="row" class="scope"><input type="radio" name="selPaquete" value="<%=codPaquete %>" required="required"/></th>
                                                
					        <td scope="row" class="scope" ><%=codPaquete %></td>
                                                
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
                                            <div class="row justify-content-center">
                                                <input type="hidden" name="tipoVenta" value="paquete"> 
                                                <div class="form-btn">
                                                    <button type="submit" class="btn btn-primary btn-lg">Seleccionar Paquete</button>
                                                </div>
                                            </div>
                                            
                                           </form> 
                                            
					 
                                        </div>
                                            
                                            <!-- /////////////////////////////////////////////////////////////// -->   
                                        <div class="table-wrap" id="divServicios" style="display: none">
                                        <form action="SvVenta" method="POST">     
                                        <span style="font-weight: bold;">-Método de pago</span>
                                            <div class="col-md-4">
                                                <select class="form-control" name="cboPago" required="required">
                                                        <option selected disabled></option>
                                                        <option>Efectivo</option>
                                                        <option>Tarjeta de Débito</option>
                                                        <option>Tarjeta de Crédito</option>
                                                        <option>Monedero Virtual</option>
                                                        <option>Transferencia</option>
                                                </select>
                                                
                                            </div>
                                                
                                        <br><br>    
                                        <p style="font-weight: bold;">-Seleccione el Servicio:</p>
                                        
                                        <table class="table">
					    <thead class="thead-primary">
					      <tr>
                                                    <th></th>
                                                    <th>Servicio</th>
                                                    <th>Id</th>
                                                    <th>Descripción</th>
                                                    <th>Destino</th>
                                                    <th>Costo</th>
                                                    <th>Fecha</th>
					      </tr>
					    </thead>
					    <tbody>
					      <%
                                                List<ServicioTuristico> listaServicios = (List) misession.getAttribute("listaServicios");
                                                for(ServicioTuristico servicio : listaServicios) { %>
					      <tr>
                                                <% int codigo = servicio.getCodigo(); %>
                                                <th cope="row" class="scope"><input type="radio" name="selServicio" value="<%=codigo %>" required="required" /></th>
                                                <% String nombre = servicio.getNombre(); %>
					        <td scope="row" class="scope" ><%=nombre %></td>
                                                
                                                <td scope="row" class="scope" ><%=codigo %></td>
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
                                                <input type="hidden" name="tipoVenta" value="servicio"> 
                                                <div class="form-btn">
                                                    <button type="submit" class="btn btn-primary btn-lg">Seleccionar Servicio</button>
                                                </div>
                                            </div>
                                            </form>
                                            
					</div> 
                                            
                                            
			</div>
                        <div class="d-flex justify-content-between">
                                <div class="justify-content-center">
                                        <a href="index.jsp" class="btn btn-primary btn-lg">Ir a la Página Principal</a>
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