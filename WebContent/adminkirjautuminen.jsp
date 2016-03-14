<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Admin</title>

<!-- Bootstrap core CSS -->
<style type="text/css">
<%@include file="/bootstrap/css/bootstrap.min.css"%>
</style>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/bootstrap/css/signin.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>Admin kirjautuminen</title>
</head>
<body>

	<div class="container" style="width:300px; margin-top:100px; text-align:center; ">

<!-- Tähän syötetään parametrit kirjautumista varten, jotka otetaan kirjautumisservletistä -->
		<form class="form-signin" method="post" action="SYÖTÄSERVLETINNIMITÄHÄN">
		
			<h3 class="form-signin-heading" style="text-align:center">Admin</h3>
			<label for="inputEmail" class="sr-only">Tunnus</label> <input
				type="text" id="username" class="form-control"
				placeholder="Tunnus" required autofocus> <label
				for="inputPassword" class="sr-only">Salasana</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Salasana" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Muista minut
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" style="background-color:black" type="submit">Kirjaudu sisään</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<!-- Latest compiled JavaScript -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>