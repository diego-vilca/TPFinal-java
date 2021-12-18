
<%@page import="logica.Venta"%>
<%@page import="logica.PaqueteTuristico"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.ServicioTuristico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            // oculta/muestra servicio o paquete, segun el radio button
            function ocultar(x){
                if (x == 0) {
                    document.getElementById("divPaquetes").style.display = "none";
                    document.getElementById("divServicios").style.display = "block";
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
                HttpSession misession = request.getSession();
                Venta venta = (Venta) misession.getAttribute("venta");
                
                Cliente cliente = venta.getCliente();
                
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
                                            <!-- Seleccionar tipo de venta -->
                                            <br><br>
                                            <div>
                                                <p style="font-weight: bold;">-Seleccione el tipo de venta:</p>
                                                    <%
                                                        if (venta.getPaquete() == null) {
                                                            %><input type="radio" name="tipo" value="Servicio" onclick="ocultar(0)" id="radioServ" checked="checked"><%
                                                                  
                                                        }else{
                                                            %><input type="radio" name="tipo" value="Servicio" onclick="ocultar(0)"><%
                                                        }
                                            
                                                    %>
                                                    
                                                    Servicio
                                                <br>
                                                    <%
                                                        if (venta.getServicio() == null) {
                                                            %><input type="radio" name="tipo" value="Paquete" onclick="ocultar(1)" id="radioPaq" checked="checked"><%
                                                             
                                                                
                                                        }else{
                                                            %><input type="radio" name="tipo" value="Paquete" onclick="ocultar(1)"><%
                                                        }
                                            
                                                    %>
                                                    Paquete
                                            </div>
                                            
                                                                                        
                                            <br><br>
                                         
                                            

<!-- /////////////////////////////////////////////////////////////// -->    
                                        <!-- Formulario para la gestion del paquete -->
                                        <div class="table-wrap" id="divPaquetes" style="display: none">
                                        
                                        <form action="SvVentaModificar" method="GET" id="formP">
                                            <span style="font-weight: bold;">-Método de pago</span>
                                            <div class="col-md-4">
                                                
                                                <select class="form-control" name="cboPago" id="mPagoP">
                                                        <option selected disabled>Seleccione un método de pago</option>
                                                        <option value="Efectivo">Efectivo</option>
                                                        <option value="Tarjeta de Débito">Tarjeta de Débito</option>
                                                        <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                                                        <option value="Monedero Virtual">Monedero Virtual</option>
                                                        <option value="Transferencia">Transferencia</option>
                                                </select>
                                                
                                                <% String medioPagoP = venta.getMedioPago();%>
                                                <!-- seteo por defecto el option correspondiente-->
                                                <script>
                                                         document.ready = document.getElementById("mPagoP").value = "<%=medioPagoP%>";
                                                </script>
                                                
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
					      <% 

                                                List<PaqueteTuristico> listaPaquetes = (List) misession.getAttribute("listaPaquetes");
                                                int flagP = 0;
                                                
                                                for(PaqueteTuristico paquete : listaPaquetes) { %>
					      <tr>
                                                                                                
                                                
                                                                                                                                                
                                                <% int codPaquete = paquete.getCodigoPaquete(); %>
                                                
                                                
                                                <th cope="row" class="scope">
                                                    <%//Selecciono el paquete que se le asigno en el alta de la venta
                                                        
                                                        
                                                    if (venta.getPaquete() != null && codPaquete == venta.getPaquete().getCodigoPaquete() && flagP == 0 ) {
                                                        %><input type="radio" name="selPaquete" value="<%=codPaquete %>" checked="checked" /><% 
                                                            flagP = 1;
                                                    }else{
                                                        %><input type="radio" name="selPaquete" value="<%=codPaquete %>" /><%  
                                                    }
                                                    %>
                                                </th>
                                                
                                                
					        <td scope="row" class="scope" ><%=codPaquete %></td>
                                                
                                                <td>
                                                    <select class="form-control" name="cboNombre"">
                                                        <% for (ServicioTuristico servicio : paquete.getListaServicios()) {%>
                                                            
                                                            <% String nombreServ = servicio.getNombre(); %>
                                                            
                                                            <option id="nomServ" ><%=nombreServ %></option>    
                                                            
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
                                                <input type="hidden" name="numVenta" value="<%=venta.getNumVenta()%>">  
                                                <input type="hidden" name="tipoVenta" value="paquete"> 
                                                <div class="form-btn">
                                                    <button type="submit" class="btn btn-primary btn-lg">Seleccionar Paquete</button>
                                                </div>
                                            </div>
                                            
                                           </form> 
                                            
					 
                                        </div>
                                            
                                            
                                        
<!-- /////////////////////////////////////////////////////////////// -->   
                                            <!-- Formulario para la gestion del servicio -->
                                        <div class="table-wrap" id="divServicios" style="display: none">
                                        <form action="SvVentaModificar" method="GET" id="formS">     
                                        <span style="font-weight: bold;">-Método de pago</span>
                                            <div class="col-md-4">
                                                <select class="form-control" id="mPagoS" name="cboPago"">
                                                        <option selected disabled>Seleccione un método de pago</option>
                                                        <option>Efectivo</option>
                                                        <option>Tarjeta de Débito</option>
                                                        <option>Tarjeta de Crédito</option>
                                                        <option>Monedero Virtual</option>
                                                        <option>Transferencia</option>
                                                </select>
                                                
                                                <% String medioPagoS = venta.getMedioPago();%>
                                                <!-- seteo por defecto el option correspondiente-->
                                                <script>
                                                         document.ready = document.getElementById("mPagoS").value = "<%=medioPagoS%>";
                                                </script>
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
                                                int flagS = 0;
                                                                                                
                                                for(ServicioTuristico servicio : listaServicios) { %>
					      <tr>
                                                <% int codigo = servicio.getCodigo(); %>
                                                
                                                
                                                <th cope="row" class="scope">
                                                    
                                                    
                                                    <%//Selecciono el servicio que se le asigno en el alta de la venta
                                                        
                                                        
                                                    if (venta.getServicio() != null && codigo == venta.getServicio().getCodigo() && flagS == 0 ) {
                                                        %><input type="radio" name="selServicio" value="<%=codigo %>" checked="checked" /><% 
                                                            flagS = 1;
                                                    }else{
                                                        %><input type="radio" name="selServicio" value="<%=codigo %>" /><%  
                                                    }
                                                    %>
                                                    
                                                </th>
                                                
                                                
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
                                                <input type="hidden" name="numVenta" value="<%=venta.getNumVenta()%>">  
                                                <input type="hidden" name="tipoVenta" value="servicio"> 
                                                <div class="form-btn">
                                                    <button type="submit" class="btn btn-primary btn-lg">Seleccionar Servicio</button>
                                                </div>
                                            </div>
                                            </form>
                                            
					</div> 

                                       
                                            
                                            
			</div>
                    <div class="justify-content-center">
			<a href="index.jsp" class="btn-volver">Ir a la Página Principal</a>
                    </div>  
                                            
		</div>
	</section>
                                           
        <script>
            //muestra/oculta los divs correspondientes al radio button checkeado al cargar la página.
            //la función que hacia esto no funcionaba con el valor del radio por defecto al cargar la web
            
            if(document.getElementById('radioServ') !== null && document.getElementById('radioServ').checked) {
                    document.getElementById("divServicios").style.display = "block";
//                    document.getElementById("divPaquetes").style.display = "none";
             }
             
            if(document.getElementById('radioPaq') !== null &&  document.getElementById('radioPaq').checked) {
//                document.getElementById("divServicios").style.display = "none";
                document.getElementById("divPaquetes").style.display = "block";
            }
        </script>
<script src="assets/tabla/js/jquery.min.js"></script>
<script src="assets/tabla/js/bootstrap.min.js"></script>
<script src="assets/tabla/js/main.js"></script>

	</body>
</html>