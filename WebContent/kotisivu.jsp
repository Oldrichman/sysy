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

<!-- START OF HEADER -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/favicon.ico">

<title>Pizzeria Fiore</title>

<!-- Bootstrap core CSS -->
<style type="text/css">
<%@include file="/bootstrap/css/bootstrap.min.css"%>
</style>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="bootstrap/docs/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet" type="text/css">

</head>
<!-- END OF HEADER -->

<!-- START OF BODY -->
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
					<li class="active"><a href="kotisivu.jsp">Etusivu</a></li>
					<li><a href="tuote.jsp">Tuote</a></li>
					<li><a href="adminkirjautuminen.jsp">Kirjaudu</a></li>
					<li><a href="#">Pizzat</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<br>
			<br>
			<br>
			<h1>Pizzeria Fiore</h1>
			<p class="lead">
				Testibootstrap.
			</p>
			<table border=1 frame=void rules=rows>

			<c:forEach items="${tuotteet}" var="p">
				<tr>
					<form action="menukontrolleri" method="post">
						<td><c:out value="${p.id}" /> <input type="hidden"
							value="${p.id}" name="id"> <a
							href="kontrolleri?toiminto=tuotteet&nimi=<c:out value="${p.nimi}" />"><c:out
									value="${p.nimi} " /> </a></td>
						<td><c:out value="Täytteet: " /> <c:out
								value="${p.taytteet} " /></td>


						<td><c:out value=" Hinta: " /> <fmt:formatNumber
								type="currency" currencySymbol="e" value="${p.hinta}" /></td>

						

					</form>
				</tr>
			</c:forEach>



		</table>
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
<!-- END OF BODY -->
</html>