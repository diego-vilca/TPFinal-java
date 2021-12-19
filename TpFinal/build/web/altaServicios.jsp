
<!-- %@page contentType="text/html" pageEncoding="UTF-8"% -->
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Alta Servicios</title>

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
    <%
                HttpSession sesion = request.getSession();
                String usu = (String) sesion.getAttribute("usuario");
                
                    if(usu == null ){
                        response.sendRedirect("login.jsp");
                    }else{
                    %>
    	<div id="booking" class="section">
            <div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
                                                <div class="titulo">Alta de Servicio</div>
						<form action="SvServicio" method="POST">
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Nombre</span>
                                                                                <select class="form-control" name="cboNombre"">
                                                                                        <option selected disabled>Seleccione un servicio</option>
											<option>Hotel por noche/s</option>
											<option>Alquiler de auto</option>
                                                                                        <option>Pasajes de colectivo</option>
											<option>Pasajes de avi�n</option>
                                                                                        <option>Pasajes de tren</option>
                                                                                        <option>Excursiones</option>
											<option>Entradas a Eventos</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Descripcion</span>
										<input class="form-control" type="text" name="txtDescripcion" placeholder="Ingrese una descripci�n" required>
									</div>
								</div>
							</div>
							<div class="row no-margin">
								<div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Destino</span>
                                                                                <select class="form-control" name="cboDestino"">
                                                                                        <option selected disabled>Seleccione un destino</option>
											<option>Iguaz�</option>
											<option>Bariloche</option>
                                                                                        <option>Carlos Paz</option>
											<option>Mar del Plata</option>
                                                                                        <option>Ushuaia</option>
                                                                                        <option>La Quiaca</option>
											<option>Pinamar</option>
                                                                                        <option>Puerto Madryn</option>
											<option>Tafi del Valle</option>
                                                                                        <option>Pen�nsula Valdez</option>
                                                                                        <option>San Mart�n de los Andes</option>
											<option>San Rafael</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
                                                                <div class="col-sm-6">
									<div class="form-group">
										<span class="form-label">Fecha</span>
										<input class="form-control" type="date"  name="txtFecha" placeholder="Ingrese una fecha" required>
									</div>
								</div>
                                                          </div>
                                                                <div class="row no-margin">
                                                                        <div class="form-group">
                                                                            <span class="form-label">Costo</span>
                                                                            <input class="form-control" type="text" name="txtCosto" placeholder="Ingrese un costo">
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
    <%}%>
</body>

</html>