<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/favicon.ico">
<title>Pizzeria Castello é Fiori</title>
<!-- Bootstrap core CSS -->

<!-- MUOTOILU CTRL+SHIFT+F RIKKOO NÄMÄ TAGIT, ÄLÄ TEE!! -->
<style type="text/css">
<%@include file="/bootstrap/css/bootstrap.min.css"%>
</style>
    <!-- Custom CSS -->
<style type="text/css">
<%@include file="/bootstrap/css/grayscale.css"%>
</style>
<!-- MUOTOILU CTRL+SHIFT+F RIKKOO NÄMÄ TAGIT, ÄLÄ TEE!! -->

    <!-- Custom Fontit ja alkuperäiset kommenteissa -->
    <link href="bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
   <!--  <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
 -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Stalemate' rel='stylesheet' type='text/css'>
 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top"
					style="font-family: 'Stalemate', cursive;">
					<span class="light" style="font-size:35px;"><small>Castello é Fiori&ensp;</small></span><i class="fa fa-cutlery"></i>

				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">

					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#yhteystiedot">YHTEYSTIEDOT</a></li>
					<li><a href="KayttajaMenu">MENU</a></li>
					
					<li><a href="KayttajaServlet">OMAT TIEDOT</a></li>
						<li><a href="kotisivu.jsp">KIRJAUDU ULOS</a></li>		
							</form>
						</div> </li>

					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Intro Header -->
	<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
					<br><br><br>
						<h1 class="brand-heading" style="text-transform: none; text-shadow:2px 2px 2px black; letter-spacing:-8px; font-size:130px;">Castello é Fiori</h1>
						<br><br><br><br>
						<c:forEach items="${tiedot}" var="p">
				<tr>
					<form action="KayttajaServlet" method="post">
						<p class="intro-text" style="text-shadow:1px 1px 1px black;">
							Tervetuloa <c:out value="${p.etunimi}"></c:out> 
							<c:out value="${p.sukunimi} "></c:out>  <br>
							Alta pääset katsomaan ja muokkaamaan omia tietojasi.
						</p>
								</form> </tr> </c:forEach>						
						<a href="#about" class="btn btn-circle page-scroll"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Käyttäjän tiedot -->
	<section id="about" class="container content-section text-center" style="align-self:center;">
		<div class="row">
			
				<h2>Omat tiedot</h2>
				<p>
					
					 <!-- MUOKKAA MUOTOILUA PAREMMAKSI, KÄYTÄ BOKSEJA TMS. -->
			<table class="table table-bordered">
			<thead class="thead-inverse" >
			
    <tr class="big">
      <th style="text-align:center">Etunimi</th>
      <th style="text-align:center">Sukunimi</th>
      <th style="text-align:center">email</th>
      <th style="text-align:center">osoite</th>
      <th style="text-align:center">postinumero</th>
      <th style="text-align:center">suosikki pizza</th>
    </tr>
    
    </thead>
<thead class="thead-inverse">
			<c:forEach items="${tiedot}" var="p">
				<tr>
					<form action="KayttajaServlet" method="post">
										<td> <c:out value="${p.etunimi}" />
											<td><c:out
													value="${p.sukunimi} " /> </td>
								<td><c:out
								value="${p.email} " /></td>
						<td><input type="text"name="osoite" value="<c:out value="${p.osoite}" />"/>
								<td><input type="text" name= "postinro" value="<c:out value="${p.postinro}" />"/>
								<td><input type="text" name="suosikkipitsa" value=" <c:out value="${p.suosikkiPitsa}" />"/>
								<td>
					<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tallenna tiedot\">");%>
					</form>
					
				</tr>
			</c:forEach>
			

</thead>



		</table>
				
				</p>
			
			</div>
		
	</section>

	

	<!-- Contact Section -->
	<section id="contact" class="container content-section text-center">
		<div class="row">
			
			<div class="col-lg-8 col-lg-offset-2">
				
				<h2>Löydät meidät myös täältä</h2>

				<!-- <p>
					<a href="mailto:palaute@pizzeriafiori.fi">palaute@pizzeriafiori.com</a>
				</p> -->
				<ul class="list-inline banner-social-buttons">

					<li><a href="https://www.facebook.com"><i
							class="fa fa-facebook-square fa-5x"></i></a></li>

					<li><a href="https://www.instagram.com"><i
							class="fa fa-instagram fa-5x"></i> </a></li>

					<li><a href="http://www.twitter.com"><i
							class="fa fa-twitter-square fa-5x"></i> </a></li>
							<br>
							
							<a href="mailto:palaute@pizzeriafiori.fi">palaute@pizzeriafiori.fi</a>

				</ul>
			
			</div>
		</div>
	</section>

	<!-- Map Section -->
	<section id="yhteystiedot">
	<div id="map"></div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p style="font-size:10px"><a href="adminkirjautuminen.jsp">Copyright &copy; Team SexYSexy 2016</a></p>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="bootstrap/js/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjPfpeUdqwdbiejLneoaGAb9epjnJeVig&sensor=false"></script>
      
	<!-- Custom Theme JavaScript -->
	<script src="bootstrap/js/grayscale.js"></script>

</body>
</html>