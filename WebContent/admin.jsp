<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<title>Tuotehallinta</title>
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
<body>



	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Pizzeria</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="kontrolleri">Tuotehallinta</a></li>
					
					<li><a href="AdminMenu">Pizzat</a></li>
					<li><a href="kotisivu.jsp">Kotisivu</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container" style="width:auto; margin-top:70px">

		


			<fmt:formatDate pattern="H:mm" value="${kello}" />


			 <h1>Admin</h1>

			<nav>
				<table class="table table-bordered" frame=void style="text-align:center;">
				<thead class="thead-inverse" >
				
    <tr class="">
      <th style="text-align:center">Pizza</th>
      <th style="text-align:center">Täytteet</th>
      <th style="text-align:center">Hinta</th>
      <th style="text-align:center">Piilotettu</th>
      <th style="text-align:center">Muokkaus</th>
    </tr>
    
    
<thead class="thead-inverse">

					<c:forEach items="${tuotteet}" var="p">
						<tr>
					
			<form action="kontrolleri" method="post">
			
			<td> <input type="hidden" value="${p.id}" name="id"> 
			
			<input type ="text" width = 200px name ="nimi" value="${p.nimi} " />
			</input></td>
			<td><c:out value="" /><input type ="text" width = 200px name ="pitsa" value="${p.taytteet} " /></input></td>
			<td><input type ="number"  name ="hinta" step = "0.01"  value= "${p.hinta}" /></input> &euro;</td>
			<td style="text-align:center"><c:out value="" /> <c:out
					value="${p.poisto} " /></td>
				<td>

								
			<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Poista\">");%>
			<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota menusta\">");%>
			<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo menuun\">");%>
 			<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tallenna muutos\">");%>
								</td>

							</form>
						</tr>
					</c:forEach>

</thead>

				</table>
				
				<table class="table table-bordered" frame=void style="text-align:center;">
				<thead class="thead-inverse" style="text-align:center;" >
				<th style="text-align:center">Juoma</th>
      <th style="text-align:center">Hinta</th>
      <th style="text-align:center">Piilotettu</th>
       <th style="text-align:center">Muokkaus</th>
				
				<c:forEach items="${Juoma}" var="j" >
				<tr>
					<form action="kontrolleri" method="post">
					<input type="hidden" value="${j.id}" name="id">
					<td style="text-align:center">
										<input type ="text" name ="juoma" value="<c:out  value="${j.juoma}" />"></input>
											</td>
						<td style="text-align:center">
<input type ="number"  name ="hinta" step = "0.01"  value= "${j.hinta}" /></input> &euro;</td>
					
					<td style="text-align:center"><c:out value="${j.poisto}" /> 
								</td>
								
								<td style="text-align:center">
					 <%
									out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota juoma\">");
								%>
								<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo juoma\">");%>
								<%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tallenna\">");%>
					</td>
					</form>
					
				</tr>
			</c:forEach>
			</thead>
				</table>
</div>

<div class="container">
  <div class="row">
<div class="col-md-6">

				<br><h4>Täytteet</h4> 
				<table class="table table-condensed" style="width:auto; text-align:center;">
				<thead>
				<th style="text-align:center">Raaka-aineet</th>
				<th style="text-align:center">Piilotettu</th>
				<th style="text-align:center">Muokkaus</th>
				</thead>
				<tbody>
					<c:forEach items="${RaakaAineet}" var="r">
						<tr>
							<form action="kontrolleri" method="post">
								<td style="text-align:center"><c:out value="${r.nimi}" /> <input type="hidden"
									value="${r.nimi}" name="nimi "> <a
									href="kontrolleri?toiminto=RA&nimi=<c:out value="${r.nimi}" />">
									<input type="hidden"
									value="${r.nimi}" name="pois"> <a
									href="kontrolleri?toiminto=RA&nimi=<c:out value="${r.nimi}" />">
										</a>
								</td>
								 
								<td style="text-align:center"><c:out value="" /> <c:out
											value="${r.poisto} " />
								</td>
								
								<td style="text-align:center">
								 <%out.println("<INPUT type=\"submit\" name=\"action\"  value=\"Poista\">");
								%>  <%
									out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota\">");
								%>
								<%
									out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo täyte\">");
								%>
								</td>
							</form>
						</tr>
					</c:forEach>
					</tbody>



				</table>
				<br> <br> <br>
				
					</nav>
		</div>


    <div class="col-md-4">

				<form action="kontrolleri" method="post">
					<fieldset>
						<br><h4>Lisää pizza:</h4>
						 Nimi:<br>
						<input type="text" style="cursor:text;" name="nimi"><br> Hinta:<br> 
						<input type ="number"  name ="hinta" step = "0.01"  value= "${p.hinta}" /></input><br>
							 Täytteet:
							 <c:forEach items="${RaakaAineet}" var="r"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" />
						 
						</c:forEach>
						<br><br>
					
						<input  type="submit" value="Lisää"><br>
						<c:if test="${not empty param.added}">Uuden pizzan lisääminen onnistui!</c:if>
					</fieldset>

				</form>

</div>

 <div class="col-md-2">
 
				<form action="kontrolleri" method="post">
					<fieldset>
						<br><h4>Lisää raaka-aine:</h4>
						Nimi:<br> <input type="text" style="cursor:text;" name="lisaaRA"> <br> <input
							type="submit" value="Lisää"><br> <br>
						<c:if test="${not empty param.added}">Uuden raaka-aineen lisääminen onnistui!</c:if>
					</fieldset>
					</form>
					
					
					
					<form action="kontrolleri" method="post">
					<fieldset>
						<br><h4>Lisää juoma:</h4>
						Nimi ja koko:<br> <input type="text" style="cursor:text;" name="LJU"> <br> 
						Hinta:<br> <input type="text"pattern ="[0-9 ]+([\. ][0-9 ]+)?" title="- EROTA PISTEELLÄ!"  style="cursor:text;" name="HJU"><br> <br>
						<input type="submit" value="Lisää"><br>
						<c:if test="${not empty param.added}">Uuden juoman lisääminen onnistui!</c:if>
					</fieldset>
					</form>
					
			</div>
			
		

	</div>
	</div>
	</div>
	<!-- /.container -->

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
