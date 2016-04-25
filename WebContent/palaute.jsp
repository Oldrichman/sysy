<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Palautesivu</title>
</head>
<body>

	<h1>Anna palautetta</h1>

	<form action="PalauteKontrolleri" method="get">
		<textarea rows="10" cols="80" name="palaute">


		</textarea>
		<br>
		<br>
		<input type="submit" name="action" value="Lähetä">
	</form>




</body>
</html>