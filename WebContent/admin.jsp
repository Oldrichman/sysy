<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tuotehallinta</title>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body>

	<nav>



		<fmt:formatDate pattern="H:mm" value="${kello}" />


		<br> <br> <b>Listalla olevat tuotteet</b> <br> <br>
		<br>


		<table border=1 frame=void rules=rows>

			<c:forEach items="${tuotteet}" var="p">
				<tr>
					<form action="kontrolleri" method="post">
						<td><c:out value="${p.id}" /> <input type="hidden"
							value="${p.id}" name="id"> <a
							href="kontrolleri?toiminto=tuotteet&nimi=<c:out value="${p.nimi}" />"><c:out
									value="${p.nimi} " /> </a></td>
						<td><c:out value="Täytteet: " /> <c:out
								value="${p.taytteet} " /></td>


						<td><c:out value=" Hinta: " /> <fmt:formatNumber
								type="currency" currencySymbol="e" value="${p.hinta}" /></td>

						<td>
							<%
								out.println("<INPUT type=\"submit\" value=\"Muokkaa\">");
							%> <%
 	out.println("<INPUT type=\"submit\" value=\"Poista\">");
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
						</a>
						<td>
							<%-- <%
								out.println("<INPUT type=\"submit\" value=\"Muokkaa\">");
							%> --%><% 
 								out.println("<INPUT type=\"submit\" value=\"Poista\">");
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
				Id: <br> <input type="text" name="id"><br> Nimi:<br>
				<input type="text" name="nimi"><br> Hinta:<br> <input
					type="text" name="hinta"><br> Täytteet (erottele
				pilkulla):<br> <input type="text" name="taytteet"><br>
				<br> <input type="submit" value="Lisää"><br> <br>
				<c:if test="${not empty param.added}">Uuden pizzan lisääminen onnistui!</c:if>
			</fieldset>

		</form>
		
		<form action="kontrolleri" method="post">
			<fieldset>
				<legend>Lisää raaka-aine:</legend>
				Nimi:<br>
				<input type="text" name="nimi">
				<br> <input type="submit" value="Lisää"><br> <br>
				<c:if test="${not empty param.added}">Uuden raaka-aineen lisääminen onnistui!</c:if>
			</fieldset>

		</form>

	</nav>

</body>
</html>
