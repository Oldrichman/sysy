<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>jeee</h2>
<table class="table table-bordered">
			<thead class="thead-inverse" >
			
    <tr class="big" style="font-size:130%;">
      <th style="text-align:center">Pizza</th>
      <th style="text-align:center">Hinta</th>
      <th style="text-align:center">Kokonaissumma</th>
    </tr>
    
    </thead>
<thead class="thead-inverse">
			<c:set var="index" value="${0}" />
			<c:forEach items="${tilaus}" var="p">
				<tr>
					<form action="LisaaOstoskoriin" method="post">
							<td><input type="hidden" value="${p.id}" name="tilausnumero">
											<a style="color:#d9534f; font-size:150%; letter-spacing:3px; font-weight:900;">
									
									<c:out value="${p.nimi}" />
									<td>
									<c:out value="${p.hinta}" />
									<input type="hidden" value="${index}" name="poisto">
									<button type="submit" value="Poista" name="Poista">Poista</button>
									<td>	
									<c:out value="${sessionScope.kokonaissumma}" /> </a>
									</td>
									
								
									<c:set var="index" value="${index + 1}" />
								</form>
								
					
				</tr>
			</c:forEach>
			</thead>

</body>
</html>