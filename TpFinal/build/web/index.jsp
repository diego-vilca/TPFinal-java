

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>TP Final - Principal</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

  
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="assets/index/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="assets/index/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="assets/index/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="assets/index/css/superfish.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="assets/index/css/magnific-popup.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="assets/index/css/bootstrap-datepicker.min.css">
	<!-- CS Select -->
	<link rel="stylesheet" href="assets/index/css/cs-select.css">
	<link rel="stylesheet" href="assets/index/css/cs-skin-border.css">
	
	<link rel="stylesheet" href="assets/index/css/style.css">


	<!-- Modernizr JS -->
	<script src="assets/index/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">

		<header id="fh5co-header-section" class="sticky-banner">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
					<h1 id="fh5co-logo"><a href="index.jsp"><i class="icon-airplane"></i>Viaje Ya!</a></h1>
					<!-- START #fh5co-menu-wrap -->
                                        <%
                                            HttpSession misession = request.getSession();
                                            
                                            String usu = (String) misession.getAttribute("usuario");
                                            
                                                if(usu != null){  
                                        %>
                                        
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li class="active"><a href="index.jsp">Principal</a></li>
							<li>
                                                                <a href="#" class="fh5co-sub-ddown">Servicios</a>
								<ul class="fh5co-sub-menu">
                                                                    <form action="SvServicio" method="GET">
									<li><a href="SvServicio" type="submit">Nuestros Servicios</a></li>
                                                                    </form>
									<li><a href="altaServicios.jsp">Alta de Servicios</a></li>
                                                                    <form action="SvServicioEliminar" method="GET">
									<li><a href="SvServicioEliminar">Baja de Servicios</a></li>
                                                                    </form>
                                                                    <form action="SvHaciaServicioModificar" method="GET">
                                                                        <li><a href="SvHaciaServicioModificar">Modificar Servicio</a></li>
                                                                    </form>
								</ul>
							</li>
							<li>
								<a href="#" class="fh5co-sub-ddown">Empleados</a>
								<ul class="fh5co-sub-menu">
                                                                    <form action="SvEmpleado" method="GET">
                                                                        <li><a href="SvEmpleado" type="submit">Nuestros Empleados</a></li>
                                                                    </form>
                                                                    
									<li><a href="altaEmpleados.jsp">Alta de Empleado</a></li>
                                                                        
                                                                    <form action="SvEmpleadoEliminar" method="GET">   
									<li><a href="SvEmpleadoEliminar">Baja de Empleado</a></li>
                                                                    </form>
                                                                    <form action="SvHaciaEmpleadoModificar" method="GET">    
									<li><a href="SvHaciaEmpleadoModificar">Modificar Empleado</a></li>
                                                                    </form>
								</ul>
							</li>
							<li>
								<a href="#" class="fh5co-sub-ddown">Clientes</a>
								<ul class="fh5co-sub-menu">
                                                                    <form action="SvCliente" method="GET">
									<li><a href="SvCliente" type="submit">Nuestros Clientes</a></li>
                                                                    </form>
									<li><a href="altaClientes.jsp">Alta de Cliente</a></li>
                                                                    <form action="SvClienteEliminar" method="GET">
									<li><a href="SvClienteEliminar">Baja de Cliente</a></li>
                                                                    </form>
                                                                    <form action="SvHaciaClienteModificar" method="GET"> 
									<li><a href="SvHaciaClienteModificar">Modificar Cliente</a></li>
                                                                    </form>
								</ul>
							</li>
							<li>
								<a href="#" class="fh5co-sub-ddown">Paquetes</a>
								<ul class="fh5co-sub-menu">
                                                                    <form action="SvPaqueteMostrar" method="GET">
									<li><a href="SvPaqueteMostrar" type="submit">Nuestros Paquetes</a></li>
                                                                    </form>
                                                                    <form action="SvPaquete" method="GET">
									<li><a href="SvPaquete">Alta de Paquetes</a></li>
                                                                    </form>
                                                                    <form action="SvPaqueteEliminar" method="GET">
									<li><a href="SvPaqueteEliminar">Baja de Paquetes</a></li>
                                                                    </form>
                                                                    <form action="SvHaciaPaqueteModificar" method="GET">
									<li><a href="SvHaciaPaqueteModificar">Modificar Paquetes</a></li>
                                                                    </form>
								</ul>
							</li>
							<li>
								<a href="#" class="fh5co-sub-ddown">Ventas</a>
								<ul class="fh5co-sub-menu">
									<li><a href="venta.jsp">Realizar Venta</a></li>
                                                                    <form action="SvVenta" method="GET">
									<li><a href="SvVenta" type="submit">Mostrar Ventas</a></li>
                                                                    </form>
                                                                    <form action="SvVentaEliminar" method="GET">
									<li><a href="SvVentaEliminar" type="submit">Eliminar Ventas</a></li>
                                                                    </form>
                                                                    <form action="SvHaciaVentaModificar" method="GET">
                                                                        <li><a href="SvHaciaVentaModificar" type="submit">Modificar Ventas</a></li>
                                                                    </form>
								</ul>
							</li>
                                                        
							<li>
                                                            <form action="SvUsuario" method="GET">
                                                            <a href="SvUsuario" >log out</a>
                                                            </form>
                                                        </li>
                                                        
						</ul>
					</nav>
                                        
                                        <%  }else{   %>
                                            <nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							
							<li><a href="login.jsp">Login</a></li>
						</ul>
					</nav>
                                        <%  }   %>
				</div>
			</div>
		</header>

		<!-- end:header-top -->
	
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(assets/index/images/cover_bg_0.jpg);">
				<div class="desc">
					<div class="container">
						<div class="row">
							<div class="desc2 animate-box">
								<div class="col-xs-12 col-sm-8  col-md-8 ">
									<p>Viaje Ya! La empresa lider en viajes online</p>
									<h2>Viajá por Argentina, viajá por el mundo</h2>
									<h3>Comprá tu paquete con un 10% de descuento!</h3>
									<span class="price">Pagá menos, disfrutá más.</span>
									<!-- <p><a class="btn btn-primary btn-lg" href="#">Get Started</a></p> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		
                
                <div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>Los mejores Tours</h3>
						<p>Contamos con todo tipos de viajes y servicios para hacer su estadía más cómoda</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="assets/index/images/place-11.jpg"  class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Los Mejores Destinos</h3>
								<span>Disfrutá Solo o Acompañado desde</span>
								<span class="price">$10.000</span>
								<a class="btn btn-primary btn-outline" href="#">Reserve Ahora <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="assets/index/images/place-12.jpg"  class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Los mejores Eventos</h3>
								<span>Recitales Espectaculares desde</span>
								<span class="price">$4.000</span>
								<a class="btn btn-primary btn-outline" href="#">Reserve Ahora <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 fh5co-tours animate-box" data-animate-effect="fadeIn">
						<div href="#"><img src="assets/index/images/place-13.jpg"  class="img-responsive">
							<div class="desc">
								<span></span>
								<h3>Los Servicios Que Necesitas</h3>
								<span>Hoteles y Traslado Desde</span>
								<span class="price">$8.000</span>
								<a class="btn btn-primary btn-outline" href="#">Reserve Ahora <i class="icon-arrow-right22"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center animate-box">
						<p><a class="btn btn-primary btn-outline btn-lg" href="#">Su Nueva Aventura Empieza Hoy<i class="icon-arrow-right22"></i></a></p>
					</div>
				</div>
			</div>
		</div>
                
                
                		
		<div id="fh5co-destination">
			<div class="tour-fluid">
				<div class="row">
					<div class="col-md-12">
						<ul id="fh5co-destination-list" class="animate-box">
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-1.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Bariloche</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-2.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>San Rafael</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-3.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Iguazú</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-4.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Puerto Madryn</h2>
									</div>
								</a>
							</li>

							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-5.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Carlos Paz</h2>
									</div>
								</a>
							</li>
							<li class="one-half text-center">
								<div class="title-bg">
									<div class="case-studies-summary">
										<h2>Destinos Populares</h2>
										<span><a href="#">Dejese llevar y viaje ya!</a></span>
									</div>
								</div>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-6.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Mar del Plata</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-7.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Tafi del Valle</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-8.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>La Quiaca</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-9.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>Purmamarca</h2>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(assets/index/images/place-10.jpg); ">
								<a href="#">
									<div class="case-studies-summary">
										<h2>San Martin de los Andes</h2>
									</div>
								</a>
							</li>
						</ul>		
					</div>
				</div>
			</div>
		</div>

		
		<!-- fh5co-blog-section -->
		<div id="fh5co-testimonial" style="background-image:url(assets/index/images/img_bg_1.jpg);">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2 style="font-weight:bold;">Clientes Satisfechos</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="box-testimony animate-box">
						<blockquote>
							<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
							<p>&ldquo;Las excursiones nos gustaron todas mucho, pero destacaría el Minitrekking en el Perito Moreno, Torres del Paine, y Cataratas de Iguazú.&rdquo;</p>
						</blockquote>
						<p class="author">Clara O’Farrell, Ingeniera </p>
					</div>
					
				</div>
				<div class="col-md-4">
					<div class="box-testimony animate-box">
						<blockquote>
							<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
							<p>&ldquo;Los hoteles muy bien, en general. Buen tamaño de las habitaciones, limpieza, buenos colchones. &rdquo;</p>
						</blockquote>
						<p class="author">Zlatan Ibrahimović, Crack </p>
					</div>
					
					
				</div>
				<div class="col-md-4">
					<div class="box-testimony animate-box">
						<blockquote>
							<span class="quote"><span><i class="icon-quotes-right"></i></span></span>
							<p>&ldquo;Es un destino maravilloso para todos aquellos a los que les guste la naturaleza, porque aquí está en estado puro.
Se lo recomiendo a todo el mundo, es un destino que nadie debería perdérselo.&rdquo;</p>
						</blockquote>
						<p class="author">Chino Darín, Actor</p>
					</div>
					
				</div>
			</div>
		</div>
	</div>
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row row-bottom-padded-md">
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Sobre Viaje Ya!</h3>
							<p>Como agencia ofrecemos al mercado diversas propuestas personalizadas con la calidad, seriedad y respaldo característicos de las empresas del grupo líder en el mercado del turismo.</p>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Rutas de Viaje</h3>
							<ul>
								<li><a href="#">Vuelos desde Cordoba</a></li>
								<li><a href="#">Vuelos desde BsAs</a></li>
								<li><a href="#">Vuelos desde Santa Cruz</a></li>
								<li><a href="#">Vuelos desde Misiones</a></li>
								<li><a href="#">Vuelos desde Salta</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Hoteles Top</h3>
							<ul>
								<li><a href="#">Cordoba Hotel</a></li>
								<li><a href="#">Bariloche Hotel</a></li>
								<li><a href="#">Salta Hotel</a></li>
								<li><a href="#">BsAs Hotel</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Intereses</h3>
							<ul>
								<li><a href="#">Playas</a></li>
								<li><a href="#">Viajes Familiares</a></li>
								<li><a href="#">Presupuestos</a></li>
								<li><a href="#">Comida &amp; Bebida</a></li>
								<li><a href="#">Luna de Miel</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Mejores Lugares</h3>
							<ul>
								<li><a href="#">Mar del Plata</a></li>
								<li><a href="#">Sierras de Córdoba</a></li>
								<li><a href="#">Iguazú</a></li>
								<li><a href="#">Tafi del Valle</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Accesible</h3>
							<ul>
								<li><a href="#">Comida &amp; Bebida</a></li>
								<li><a href="#">Tarifas</a></li>
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2021. All Rights Reserved. <br>Hecho con <i class="icon-heart3"></i> by <a href="https://github.com/diego-vilca/TPFinal-java" target="_blank">Diego Vilca</a> </p>
						</div>
					</div>
				</div>
			</div>
		</footer>

	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->


	<script src="assets/index/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="assets/index/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="assets/index/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="assets/index/js/jquery.waypoints.min.js"></script>
	<script src="assets/index/js/sticky.js"></script>

	<!-- Stellar -->
	<script src="assets/index/js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="assets/index/js/hoverIntent.js"></script>
	<script src="assets/index/js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="assets/index/js/jquery.magnific-popup.min.js"></script>
	<script src="assets/index/js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="assets/index/js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="assets/index/js/classie.js"></script>
	<script src="assets/index/js/selectFx.js"></script>
	
	<!-- Main JS -->
	<script src="assets/index/js/main.js"></script>

	</body>
</html>

