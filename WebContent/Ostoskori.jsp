<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<thead class="thead-inverse">
<h2>jeee</h2>
			<c:forEach items="${tilaus}" var="p">
				<tr>
					<form action="lisaaOstoskoriin" method="post">
							<td><input type="hidden" value="${p.tilausnumero}" name="tilausnumero">
											<a style="color:#d9534f; font-size:150%; letter-spacing:3px; font-weight:900;">
									<c:out value="${p.id} " />		
									<c:out value="${p.kokonaissumma} " /> </a>
									</td><td>

	
								</form>
								</td>
					
					
				</tr>
			</c:forEach>
</thead>

</body>
</html>