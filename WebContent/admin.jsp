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
					
					<!-- <li><a href="AdminMenu">Pizzat</a></li> -->
					<li><a href="kotisivu.jsp">Kotisivu</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>



<!-- Tuotteet/Pizzat  -->
	<div class="container" style="width:auto; margin-top:70px">

			<fmt:formatDate pattern="H:mm" value="${kello}" />


			 <h1>Admin</h1>

			<nav>

				<table class="table table-condensed" frame=void style="text-align:center; ">

				<thead class="thead-inverse" >
				
    <tr class="">
      <th style="text-align:center">Pizza</th>
      <th style="text-align:center">Täytteet</th>
      <th style="text-align:center">Hinta</th>
      <th style="text-align:center">Tila</th>
      <th style="text-align:center">Muokkaus</th>
      <th style="text-align:center">Poisto</th>
    </tr>
    
    
<thead class="thead-inverse">

					<c:forEach items="${tuotteet}" var="p">
						<tr>
					
			<form action="kontrolleri" method="post">
			
			<td> <input type="hidden" value="${p.id}" name="id"> 
			
			<c:out value="${p.nimi} " />
			</input></td>
			<td><c:out value="" /><c:out value="${p.taytteet} "/></td>
			<td><input type ="number" class="form-control-admin" style="padding:-10px;"  name ="hinta" step = "0.01"  value= "${p.hinta}" /></input> &euro;</td>
			<td style="text-align:center"><c:out value="" /> <c:out
					value="${p.poisto} " /></td>
				<td>

								
			<!-- Tehty buttonit adminiin,alkuperäiset koodinpätkät säilytetty, jotta näkee miten homma toimii skripletistä buttoniin -->
			<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota menusta\">");%> --%>
			<button class="btn btn-danger" type="submit" name="action" value="Piilota menusta" style="padding:3px; margin:1px" title="Piilottaa tuotteen menusta">Piilota menusta</button>
			<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo menuun\">");%> --%>
			<button class="btn btn-danger" type="submit" name="action" value="Tuo menuun" style="padding:3px; margin:1px" title="Tuo piilotetun tuotteen takaisin menuun">Tuo menuun</button>
 			<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tallenna muutos\">");%> --%>
 			<button class="btn btn-danger" type="submit" name="action" value="Tallenna muutos" style="padding:3px; margin:1px" title="Tallenna tekemäsi muutos kantaan!">Tallenna muutos</button>
					 </td>			<td>
			<%--  <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Poista\">");%> --%>
			 <button class="btn btn-danger" type="submit" name="action" value="Poista" style="padding:3px; margin:1px" title="Poistaa tuotteen kokonaan tietokannasta">Poista</button>
			 </td>
							</form>
						</tr>
					</c:forEach>

		</thead>
	</table>
	</div>
				<!-- Tuotteet/Pizzat  -->
				
				
				
				
				<!-- Juomat  -->
				

<div class="container" style="width:auto; margin-top:60px;">
  <div class="row">
<div class="col-md-6">				
				
				<br><h4 style="text-align:center;">Juomat</h4>
				<table class="table table-bordered" frame=void style="text-align:center; width:auto; font-size:80%;">
				<thead class="thead-inverse" style="text-align:center;" >
				<th style="text-align:center">Juoma</th>
      <th style="text-align:center">Hinta</th>
      <th style="text-align:center">Tila</th>
       <th style="text-align:center">Muokkaus</th>
				
				<c:forEach items="${Juoma}" var="j" >
				<tr>
					<form action="kontrolleri" method="post">
					<input type="hidden" value="${j.id}" name="id">
					<td style="text-align:center">
										<input type ="text" name ="juoma" class="form-control-admin" value="<c:out  value="${j.juoma}" />"></input>
											</td>
						<td style="text-align:center">
						<input type ="number"  name ="hinta" step = "0.01" class="form-control-admin" value= "${j.hinta}" /></input> &euro;</td>
					
					<td style="text-align:center"><c:out value="${j.poisto}" /> 
								</td>
								
								<td style="text-align:center">
								
<!-- 								Buttonit lisätty ja formit siistimmiksi bootstrapilla adminiin -->
								<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota juoma\">");%> --%>
								<button class="btn btn-danger" type="submit" name="action" value="Piilota juoma" style="padding:3px; margin:1px" title="Piilottaa juoman menusta">Piilota juoma</button>
								<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo juoma\">");%> --%>
								<button class="btn btn-danger" type="submit" name="action" value="Tuo juoma" style="padding:3px; margin:1px" title="Tuo piilotetun juoman takaisin menuun">Tuo juoma</button>
								<%-- <%out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tallenna\">");%> --%>
								<button class="btn btn-danger" type="submit" name="action" value="Tallenna" style="padding:3px; margin:1px" title="Tallenna tekemäsi muutokset tietokantaan!">Tallenna</button>
					</td>
					</form>
					
				</tr>
			</c:forEach>
			</thead>
				</table>
</div>
<!-- Juomat  -->



<%-- <div class="col-xs-4">

				<br><h4 style="text-align:auto; margin-left:15px;">Täytteet</h4> 
				<table class="table table-condensed" style="width:auto; text-align:center; border:none; border-style:none;">
				<thead>
				<th style="text-align:center; border:none;">Raaka-aineet</th>
				</thead>
				<tbody>
				
					<c:forEach items="${RaakaAineet}" var="r" begin="0" end="20">
						<tr>
							<form action="kontrolleri" method="post">
								<td style="text-align:center"><c:out value="${r.nimi}" /> <input type="hidden"
									value="${r.nimi}" name="Rnimi "> 
									
								</td>
								 
								
								</td>
								
								<td style="text-align:center">
								
								
								</td>
							</form>
						</tr>
					</c:forEach>
					</tbody>



				</table>
				<br> <br> <br>
				
					</nav>
		</div>
</div>
</div> --%>
<div class="container">
  <div class="row">
    <div class="col-md-5" style="padding:20px; margin-left:-170px">

				<form action="kontrolleri" method="post">
					<fieldset>
						<h4>Lisää pizza:</h4>
						 Nimi:<br>
						<input type="text" style="cursor:text;" name="nimi" class="form-control-admin"><br> Hinta:<br> 
						<input type ="number"  name ="hinta" step = "0.01" class="form-control-admin" value= "${p.hinta}" /></input><br>
					
						<input type="hidden" style="cursor:text;" name="poisto" value="Ei julkaistu"><br>
							 Täytteet:
							 <!-- tee tähän joku gridi checkbokseille -->
							 
							 <table class="table" style="border:solid 1px;">
							 <th>
							 <c:forEach items="${RaakaAineet}" var="r" begin="0" end="5"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" /> <br>
						 </c:forEach>
						 </th>
						 
						 <th>
						  <c:forEach items="${RaakaAineet}" var="r" begin="6" end="11"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" /> <br>
						</c:forEach>
						</th>
						
						<th>
						 <c:forEach items="${RaakaAineet}" var="r" begin="12" end="17"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" /> <br>
						</c:forEach>
						</th>
						
						<th>
						 <c:forEach items="${RaakaAineet}" var="r" begin="18" end="23"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" /> <br>
						</c:forEach>
						</th>
						
						<th>
						 <c:forEach items="${RaakaAineet}" var="r" begin="23" end="28"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" /> <br>
						</c:forEach>
						</th>
						
						</table>
						
					
					<button class="btn btn-danger" type="submit" name="action" value="Lisää" style="padding:10px; margin:1px" title="Muista valita kaikki raaka-aineet, nimeä ja hinnoittele Pizza!">Lisää pizza</button>
						<!-- <input  type="submit" value="Lisää"> -->
						<c:if test="${not empty param.added}">Uuden pizzan lisääminen onnistui!</c:if>
					</fieldset>

				</form>

</div>

 <div class="col-md-2" style="margin-left:-20px;">
 
				<form action="kontrolleri" method="post">
					<fieldset>
						<br><h4>Lisää raaka-aine:</h4>
						Nimi:<br> <input type="text" style="cursor:text;" class="form-control-admin" name="lisaaRA"> <br><br>
						<button class="btn btn-danger" type="submit" name="action" value="Lisää" style="padding:6px; margin:1px" title="Lisää uuden raaka-aineen tietokantaan">Lisää raaka-aine</button> 
						<!-- <input type="submit" value="Lisää"><br> <br> -->
						<c:if test="${not empty param.added}">Uuden raaka-aineen lisääminen onnistui!</c:if>
					</fieldset>
					</form>
					
					
					
					<form action="kontrolleri" method="post">
					<fieldset>
						<br><h4>Lisää juoma:</h4>
						Nimi ja koko:<br> <input type="text" class="form-control-admin" style="cursor:text;" name="LJU"> <br> 
						Hinta:<br> <input type="number" class="form-control-admin" step = "0.01"  style="cursor:text;" name="HJU"><br>
						<input type="hidden" style="cursor:text;" name="poisto" value="Ei julkaistu"><br>
						<button class="btn btn-danger" type="submit" name="action" value="Lisää" style="padding:6px; margin:1px" title="Lisää uuden juoman tietokantaan">Lisää juoma</button> 
						<!-- <input type="submit" value="Lisää"><br> -->
						<c:if test="${not empty param.added}">Uuden juoman lisääminen onnistui!</c:if>
					</fieldset>
					</form>
					
			</div>
			
			<div class="col-xs-1" style="margin-left:-10px;">
				<br>
				<h4 style="text-align:auto; margin-left:5px;">Täytteet</h4> 
				<table class="table table-condensed" style="width:auto; text-align:center; border:none; border-style:none;">
				<thead>
				<th style="text-align:center; border:none;">Raaka-aineet</th>
				</thead>
				<tbody>
				
					<c:forEach items="${RaakaAineet}" var="r">
						<tr>
							<form action="kontrolleri" method="post">
								<td style="text-align:center"><c:out value="${r.nimi}" /> <input type="hidden"
									value="${r.nimi}" name="Rnimi "> 
									
								</td>
								 
								
								</td>
								
								<td style="text-align:center">
								
								
								</td>
							</form>
						</tr>
					</c:forEach>
					</tbody>



				</table>
				<br> <br> <br>
				
					</nav>
		</div>
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
