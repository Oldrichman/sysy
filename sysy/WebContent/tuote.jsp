<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="admin.bean.Tuote" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
<style type="text/css">
<%@include file="/bootstrap/css/bootstrap.min.css"%>
</style>

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
					<li class="active"><a href="kotisivu.jsp">Etusivu</a></li>
					<li><a href="">Tuote</a></li>
					<li><a href="adminkirjautuminen.jsp">Kirjaudu</a></li>
					<li><a href="#">Pizzat</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	
	<div class="container">
	
 	
 	<br>
	<br>	
 	<h1>Tuotteet</h1> <br>
 	<br>
 	<table>
	 	<c:forEach items="${tuotteet}" var="t" begin="0" end="5">
	 	
	 	<tr>
	 	<form action="kotisivu">
	 	<td>
	 	
	 	<input type = "hidden" value="${t.id}" name= "id">
   		 <c:out value="${t.id}"/>
   		 </td><td>
   		 <a href="controller?toiminto=tuote&nimi=<c:out value="${t.nimi}"/>"><c:out value="${t.nimi}"/></a></td>
   		<td>
   		 <fmt:formatNumber type="currency" currencySymbol="euroa" value="${t.hinta}" /></td>
   		
   		 <td>
  	<%	 out.println ("<INPUT type=\"submit\" value=\"Muokkaa\">");%> 
  		 </td>
  		 <td>
  	<%	 out.println ("<INPUT type=\"submit\" value=\"Poista\">");%> 
  		 </td> 
  		 
  		 </form>
  		 </tr>
 	</c:forEach>
 	  	</table>	
 	  	
 	  	 <form action="etusivu" method="post">
 <fieldset>
 <h4>Lisää tuote</h4>
 <input type="text" value="nimi" name="nimi"> <br>
 <input type="text" value="hinta" name="hinta"> <br>
 		<INPUT type="submit" value="Lisää tuote">
 		<br>
 		<c:if test="${not empty param.added}">Uuden tuotteen lisääminen onnistui!</c:if>
 		</fieldset>
 		</form>
 		
 
 	</div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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