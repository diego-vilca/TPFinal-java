
<!-- %@page contentType="text/html" pageEncoding="UTF-8" -->
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Alta Empleados</title>

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
                                                <div class="titulo">Alta de Empleados</div>
                                                <form action="SvEmpleado" method="POST">
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Nombre</span>
										<input class="form-control" type="text" name="txtNombre" placeholder="Ingrese un nombre" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Apellido</span>
										<input class="form-control" type="text" name="txtApellido" placeholder="Ingrese un apellido" required>
									</div>
								</div>
							</div>
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Dirección</span>
										<input class="form-control" type="text" name="txtDireccion" placeholder="Ingrese una dirección" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">DNI</span>
										<input class="form-control" type="text" name="txtDni" placeholder="Ingrese un dni" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Fecha de nacimiento</span>
										<input class="form-control" type="date"  name="txtFechaNac" placeholder="Ingrese una fecha de nacimiento" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Nacionalidad</span>
                                                                                <select class="form-control" name="cboNac"">
                                                                                        <option></option>
											<option>Argentina</option>
											<option>Brasil</option>
                                                                                        <option>Bolivia</option>
											<option>Chile</option>
                                                                                        <option>Colombia</option>
                                                                                        <option>Ecuador</option>
											<option>Paraguay</option>
											<option>Peru</option>
                                                                                        <option>Uruguay</option>
											<option>Venezuela</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Celular</span>
										<input class="form-control" type="text" name="txtCelular" placeholder="Ingrese un teléfono" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Email</span>
										<input class="form-control" type="email" name="txtEmail" placeholder="Ingrese un email" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Cargo</span>
										<input class="form-control" type="text" name="txtCargo" placeholder="Ingrese un cargo" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Sueldo</span>
										<input class="form-control" type="text" name="txtSueldo" placeholder="Ingrese un sueldo" required>
									</div>
								</div>
							</div>
                                                        <div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Usuario</span>
										<input class="form-control" type="text" name="txtUsuario" placeholder="Ingrese un usuario" required>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Contraseña</span>
										<input class="form-control" type="password" name="txtContrasenia" placeholder="Ingrese una contraseña" required>
									</div>
								</div>
							</div>
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