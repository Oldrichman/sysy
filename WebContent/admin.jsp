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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/favicon.ico">
<title>Tuotehallinta</title>
<!-- Bootstrap core CSS -->
<style type="text/css"><%@include file="/bootstrap/css/bootstrap.min.css"%></style>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="bootstrap/docs/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet" type="text/css">

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

	<div class="container" style="width:300px; margin-top:50px">

		<div class="starter-template">
		
		






			<fmt:formatDate pattern="H:mm" value="${kello}" />


			 <h1>Admin</h1>

			<nav>
				<table border=1 frame=void rules=rows>

					<c:forEach items="${tuotteet}" var="p">
						<tr>
<form action="kontrolleri" method="post">
<td> <input type="hidden"
value="${p.id}" name="id"> <a
href="kontrolleri?toiminto=tuotteet&nimi=<c:out value="${p.nimi}" />"><c:out
value="${p.nimi} " /> </a></td>
<td><c:out value="Täytteet: " /> <c:out
value="${p.taytteet} " /></td>
<td><c:out value=" Hinta: " /> <fmt:formatNumber
type="currency" currencySymbol="e" value="${p.hinta}" /></td>
<td><c:out value="Piilotettu: " /> <c:out
value="${p.poisto} " /></td>
<td>
								<td>
									<%
out.println("<INPUT type=\"submit\" name=\"action\" value=\"Poista\">");
								%> <%
 out.println("<INPUT type=\"submit\" name=\"action\" value=\"Piilota menusta\">");
 %>
 <%
 out.println("<INPUT type=\"submit\" name=\"action\" value=\"Tuo menuun\">");
 %>
 
								</td>

							</form>
						</tr>
					</c:forEach>



				</table>

				<br> <br> <b>Täytteet</b> <br> <br> <br>


				<table border=1 frame=void rules=rows>

					<c:forEach items="${RaakaAineet}" var="r">
						<tr>
							<form action="kontrolleri" method="post">
								<td><c:out value="${r.nimi}" /> <input type="hidden"
									value="${r.nimi}" name="nimi"> <a
									href="kontrolleri?toiminto=RA&nimi=<c:out value="${r.nimi}" />">
									<input type="hidden"
									value="${r.nimi}" name="pois"> <a
									href="kontrolleri?toiminto=RA&nimi=<c:out value="${r.nimi}" />">
								</a>
								<td> 
								<td><c:out value="Piilotettu: " /> <c:out
											value="${r.poisto} " /></td>
								<td>
									 <%
								out.println("<INPUT type=\"submit\" name=\"action\"  value=\"Poista\">");
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



				</table>
				<br> <br> <br>

				<form action="kontrolleri" method="post">
				
					<fieldset>
						<legend>Lisää pizza:</legend>
						 Nimi:<br>
						<input type="text" name="nimi"><br> Hinta:<br> <input
							type="text" name="hinta"><br>
							 Täytteet:
							 <c:forEach items="${RaakaAineet}" var="r"><br>
							  <input type="checkbox" name="taytteet" value="${r.nimi}">
						 <c:out value="${r.nimi}" />
						 
						</c:forEach>
						<br><br>
					
						<input type="submit" value="Lisää"><br>
						<c:if test="${not empty param.added}">Uuden pizzan lisääminen onnistui!</c:if>
					</fieldset>

				</form>

				<form action="kontrolleri" method="post">
					<fieldset>
						<legend>Lisää raaka-aine:</legend>
						Nimi:<br> <input type="text" name="lisaa"> <br> <input
							type="submit" value="Lisää"><br> <br>
						<c:if test="${not empty param.added}">Uuden raaka-aineen lisääminen onnistui!</c:if>
					</fieldset>

				</form>
			</nav>
		</div>

	</div>
	</div>
	<!-- /.container -->

	
	<script>window.jQuery|| document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
