
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Modificar Empleado</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Lato:400,400i,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="assets/form/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="assets/form/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
        

</head>

<body>
    	<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
                                        <div class="booking-form">
                                                <div class="titulo">Modificar Empleado</div>
                                                <form action="SvEmpleadoModificar" method="GET">
                                                    <% HttpSession misession = request.getSession();
                                                        Empleado emple = (Empleado) misession.getAttribute("empleado");%>
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Nombre</span>
                                                                                <input class="form-control" type="text" name="txtNombre" value="<%=emple.getNombre()%>" placeholder="Ingrese un nombre" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Apellido</span>
										<input class="form-control" type="text" name="txtApellido" value="<%=emple.getApellido()%>" placeholder="Ingrese un apellido" required>
									</div>
								</div>
							</div>
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Dirección</span>
										<input class="form-control" type="text" name="txtDireccion" value="<%=emple.getDireccion()%>" placeholder="Ingrese una dirección" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">DNI</span>
										<input class="form-control" type="text" name="txtDni" value="<%=emple.getDni()%>" placeholder="Ingrese un dni" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Fecha de nacimiento</span>
                                                                                <!-- seteo el datepicker -->
                                                                                <% SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
                                                                                    String fecha = df.format(emple.getFechaNac());
                                                                                %>
                                                                                <input class="form-control" type="date"  name="txtFechaNac" id="fechaNac"  value="<%=fecha%>" placeholder="Ingrese una fecha de nacimiento" required>
                                                                                
                                                                               
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Nacionalidad</span>
                                                                                <select class="form-control" name="cboNac" id="nacionalidad">
                                                                                    <option value="" selected disabled>Seleccione un pais</option>
											<option value="Argentina">Argentina</option>
											<option value="Brasil">Brasil</option>
                                                                                        <option value="Bolivia">Bolivia</option>
											<option value="Chile">Chile</option>
                                                                                        <option value="Colombia">Colombia</option>
                                                                                        <option value="Ecuador">Ecuador</option>
											<option value="Paraguay">Paraguay</option>
											<option value="Peru">Peru</option>
                                                                                        <option value="Paraguay">Uruguay</option>
											<option value="Venezuela">Venezuela</option>
										</select>
                                                                                <!-- seteo por defecto el option correspondiente-->
                                                                                <script>
                                                                                         document.ready = document.getElementById("nacionalidad").value = "<%=emple.getNacionalidad()%>";
                                                                                </script>
                                                                                
										<span class="select-arrow"></span>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Celular</span>
										<input class="form-control" type="text" name="txtCelular" value="<%=emple.getCelular()%>" placeholder="Ingrese un teléfono" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Email</span>
										<input class="form-control" type="email" name="txtEmail" value="<%=emple.getEmail()%>" placeholder="Ingrese un email" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
                                                                                <span class="form-label">Cargo</span>
                                                                                <select class="form-control" name="txtCargo" id="cargo" required>
                                                                                    <option value="" selected disabled>Seleccione un cargo</option>
											<option value="empleado">empleado</option>
											<option value="gerente">gerente</option>
										</select>
                                                                                <!-- seteo por defecto el option correspondiente-->
                                                                                <script>
                                                                                         document.ready = document.getElementById("cargo").value = "<%=emple.getCargo()%>";
                                                                                </script>
                                                                                
										<span class="select-arrow"></span>
                                                                                
										
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Sueldo</span>
										<input class="form-control" type="text" name="txtSueldo" value="<%=emple.getSueldo()%>" placeholder="Ingrese un sueldo" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Usuario</span>
										<input class="form-control" type="text" name="txtUsuario" value="<%=emple.getUser().getNombreUsuario()%>" placeholder="Ingrese un usuario" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Contraseña</span>
										<input class="form-control" type="password" name="txtContrasenia" value="<%=emple.getUser().getContrasenia()%>" placeholder="Ingrese una contraseña" required>
									</div>
								</div>
							</div>
                                                        <input type="hidden" name="id" value="<%=emple.getId()%>">  
							<div class="form-btn">
								<button type="submit" class="submit-btn">Enviar</button>
							</div>
						</form>
                                                <div class="form-btn">
                                                            <a href="index.jsp"><button class="submit-btn">Volver</button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>