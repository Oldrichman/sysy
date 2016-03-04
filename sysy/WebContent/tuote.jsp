<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="admin.bean.Tuote" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tuotehallinta</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>

	<nav>
 	
 	<br>
		
 	<a>Tuotteet</a> <br>
 	<br>
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
 <legend>Lisää Tuote:</legend>
 <input type="text" value="nimi" name="nimi"> <br>
 <input type="text" value="hinta" name="hinta"> <br>
 		<INPUT type="submit" value="Lis&auml;&auml; tuote">
 		<br>
 		<c:if test="${not empty param.added}">Uuden tuotteen lisääminen onnistui!</c:if>
 		</fieldset>
 		</form>
 		
 	</nav>

</body>
</html>