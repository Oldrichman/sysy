<%@page import="javafx.scene.layout.Background"%>
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
<title>Menu</title>
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
				<a class="navbar-brand page-scroll" href="kotisivu.jsp"
					style="font-family: 'Stalemate', cursive;">
					<span class="light" style="font-size:35px;"><small>Castello é Fiori&ensp;</small></span><i class="fa fa-cutlery"></i>

				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
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
								<!-- OSTOSKORINAVISSA K.F.-->
						<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href=""><i class="fa fa-shopping-cart fa-lg"></i></a>
						<div class="dropdown-menu" style="padding: 10px; background-color:black; opacity:0.9; border-radius:15px">
						<br>
						
						<h4>OSTOSKORI</h4>
	<table class="table table-condensed">
		<thead class="thead-inverse" >
			
    	<tr class="big" style="font-size:80%;">
     	 <th style="text-align:center">Pizza</th>
      		<th style="text-align:center">Hinta</th>
   		 </tr>
    
    
		</thead>
<thead class="thead-inverse">
			<c:set var="index" value="${0}" />
			<c:if test="${not empty sessionScope.kori }">
			<c:forEach items="${sessionScope.kori}" var="p">
				<tr>
					<form action="LisaaOstoskoriin" method="post" style="color:white;">
							<td style="color:#d9534f; font-size:110%; letter-spacing:3px;"><input type="hidden" value="${p.id}" name="tilausnumero">
									<c:out value="${p.nimi}" />
									<td>
									
									
									<%-- Alkuperäinen hinta --%>
									<%-- <input type="hidden" name="hinta" value="<c:out value='${p.hinta}'/>"/>
									<fmt:formatNumber value="${p.hinta}" type="currency" currencySymbol=""  /> &euro; --%>

									<%-- poisto nappulan hinta--%>
									<input type="hidden" name="hinta" value="<c:out value='${p.hinta}'/>"/>
									<fmt:formatNumber value="${p.hinta}"  type="currency" currencySymbol=""  /> &euro;
									<input type="hidden" value="${index}" name="poisto">
									

									<td>	
									</td>

									<c:set var="index" value="${index + 1}" />

								</form>
				</tr>
			</c:forEach>
			<td>
					<label>Kokonaissumma</label><input type="hidden" name="hinta" value="<c:out value='${sessionScope.kokonaissumma}'/>"/>
									<fmt:formatNumber value="${sessionScope.kokonaissumma}" type="currency" currencySymbol=""  /> &euro;
									</td>
			</c:if>
			</thead>

</table>
<a href="LisaaOstoskoriin">MENE OSTOSKORIIN</a>		
										
						
			 </li>
	<!-- OSTOSKORINAVISSALOPPUU! K.F.-->
							</form>
						</div> </li>
						
			
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
						<h1 class="brand-heading" style="text-transform: none; text-shadow:2px 2px 2px black; letter-spacing:-8px; font-size:130px;">Menu</h1>
						<br><br><br><br>
						<p class="intro-text" style="text-shadow:1px 1px 1px black;">
						
						</p>
						<a href="#about" class="btn btn-circle page-scroll"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- PIZZAT ALUE -->
	<section id="about" class="container content-section text-center" style="box-shadow:  0px 155px 63px -165px rgba(245,245,245,0.9); border-radius:50px">
				<h2 style="font-size:300%;">Pizzamme</h2>	
					<div class="container"> <!-- style="background:rgba(255, 255, 255, 0.20); border-radius:10px"; -->
		<div class="starter-template">
			
			
  <!-- MUOKKAA MUOTOILUA PAREMMAKSI, KÄYTÄ BOKSEJA TMS. -->
			<table class="table table-bordered">
			<thead class="thead-inverse" >
			
    <tr class="big" style="font-size:130%;">
      <th style="text-align:center">PIZZA</th>
      <th style="text-align:center">TÄYTTEET</th>
      <th style="text-align:center">HINTA</th>
    </tr>
    
    </thead>
<thead class="thead-inverse">
			<c:forEach items="${tuotteet}" var="p">
				<tr>
					<form action="menukontrolleri" method="post">
										<td><input type="hidden" value="${p.id}" name="id">
											<a style="color:#d9534f; font-size:150%; letter-spacing:3px; font-weight:900;">
									<c:out value="${p.nimi} " /> </a>
									</td><td>
									<c:out value="${p.taytteet} " /><br>
								<%
									out.println("Oregano: " +"<INPUT type=\"checkbox\" name=\"action\" value=\"\">");
								%>
								<%
									out.println("Valkosipuli: " + "<INPUT type=\"checkbox\" name=\"action\" value=\"\">");
								%></td><td> 
									
									<fmt:formatNumber value="${p.hinta}" type="currency" currencySymbol=""  /> &euro;</td>
					
													<td style="text-align:center">
													
													<button class="btn btn-danger" type="submit" name="lisaa" value="input">Lisää 
													ostoskoriin</button>
								
									<!-- <INPUT type="submit" name="lisaa" value="Lisää ostoskoriin"> -->
								</form>
								</td>
					
					
				</tr>
			</c:forEach>
</thead>


		</table>
		
		<table class="table table-bordered">
			<thead class="thead-inverse" >
			
    <tr class="big" style="font-size:150%;">
      <th style="text-align:center">JUOMA</th>
      <th style="text-align:center">HINTA</th>
      
      </tr>
    
    </thead>
<thead class="thead-inverse">
			<c:forEach items="${juomat}" var="j">
				<tr>
					<form action="menukontrolleri" method="post">
										<td><c:out  value="${j.juoma}"/>
											</td>
						<td><c:out value="" /> <fmt:formatNumber
								value="${j.hinta}" type="currency" currencySymbol=""  /> &euro;</td>
					
					</form>
								<form action = "LisaaOstoskoriin" method ="post">
					
													<td style="text-align:center">
								<br>
								<%
									out.println("Oregano: " +"<INPUT type=\"checkbox\" name=\"action\" value=\"\">");
								%>
								<%
									out.println("Valkosipuli: " + "<INPUT type=\"checkbox\" name=\"action\" value=\"\">");
								
								%>
									<INPUT type="submit" name="tilausnumero" value="Lisää ostoskoriin">
								</td><td> 
									
									<fmt:formatNumber value="${p.hinta}" type="currency" currencySymbol=""  /> &euro;</td>
					
													<td style="text-align:center">
													
								<!-- 				<button class="btn btn-danger" type="submit" name="lisaa" value="input">Lisää 
													ostoskoriin</button>
								
									<!-- <INPUT type="submit" name="lisaa" value="Lisää ostoskoriin"> -->

								</form>
								</td>
				</tr>
			</c:forEach>
</thead>


		</table>
		</div>

	
	<!-- /.container -->
			
			</div>
	</section>
	
	<!-- Download Section -->
	<!-- Tässä ei mitään tällä hetkellä, muotoilua varten -->
    <section id="download" class="content-section text-center">
        <div class="download-section">
            <div class="container">
                  
                </div>
            </div>
        
    </section>

	<!-- KARTTA JA YHTEYSTIEDOT -->
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