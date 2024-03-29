<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>Palautesivu</title>
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
	
	<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="kotisivu.jsp"
					style="font-family: 'Stalemate', cursive;">
					<span class="light" style="font-size:35px;"><small>Castello é Fiori&ensp;</small></span><i class="fa fa-cutlery"></i>

				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">

					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="hidden"><a href="#page-top"></a></li>
					<li><a class="page-scroll" href="#yhteystiedot">YHTEYSTIEDOT</a></li>
					<li><a href="MenuKontrolleri">MENU</a></li>
					<!-- <li><a href="rekisteroidy.jsp">REKISTERÖIDY</a></li> -->
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">KIRJAUDU</a>
						<div class="dropdown-menu" style="padding: 3px; background-color:transparent;">
							
							<!-- Tähän syötetään parametrit kirjautumista varten, jotka otetaan kirjautumisservletistä
							Samat kuin adminsivuilla, pitää vain käyttää omaa servlettiä?
							<form class="form-signin" method="post" action="kontrolleri"> MH -->
							
							<form action="KirjauduKayttaja" method="post">
							<br>
								<label for="inputEmail" class="sr-only" >Tunnus</label> <input style="margin-top: 8px"
									type="text" name="email" class="form-control"
									placeholder="Tunnus" required autofocus> 
									
									<label
									for="inputPassword" class="sr-only">Salasana</label> <input  style="margin-top: 8px"
									type="password" name="salasana" class="form-control"
									placeholder="Salasana" required>
								<button  class="btn btn-md"
									style="background-color:transparent; margin-top: 4px; font-size: 12px;"  type="submit" value="Login" >Kirjaudu
									sisään</button>
									
							</form>
							<a href="rekisteroidy.jsp" class="btn btn-md"
									style="background-color:transparent; margin-top: 4px; font-size: 12px;" data-toggle="tooltip" title="Saat tunnukset rekisteröitymällä">Rekisteröidy
									</a>
						</div> </li>
	

					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Intro Header -->
	<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
					<br><br><br>
						<h1 class="brand-heading" style="text-transform: none; text-shadow:2px 2px 2px black; letter-spacing:-8px; font-size:130px;">Anna palautetta</h1>
						<br><br><br><br>
						<div class="form-group">
						<form action="PalauteKontrolleri" method="get">
  <label for="comment" style="text-shadow:default;">Lähetä terveisiä meille!</label>
  <br><br>
  <textarea class ="form-control" rows="1" cols="1" placeholder="Sähköposti" style="width:250px;" name="palautemail"></textarea>
  <br>
  <textarea class="form-control" rows="10" cols="80" name="palaute"></textarea>
  <br>
        <input type="submit" name="action"  value="Lähetä" class="btn btn-danger"></input>
        </form>
        </div>
      </div>
    </div>

</div>
						
						
		<!-- 	Vanha perusversio	
				<form action="PalauteKontrolleri" method="get">
		
		<textarea rows="10" cols="80" name="palaute">


		</textarea>
		<br>
		<br>
		<input type="submit" name="action" value="Lähetä">
	</form> -->
					
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<!-- Download Section -->
	<!-- Tässä ei mitään tällä hetkellä, muotoilua varten -->
    <section id="download" class="content-section text-center">
        <div class="download-section">
            <div class="container">
                  
                </div>
            </div>
        
    </section>
	
	

	<!-- Map Section -->
	<section id="yhteystiedot">
	
			<div class="col-lg-8 col-lg-offset-2 container text-center">
				
				<h2>Löydät meidät myös täältä</h2>

				<!-- <p>
					<a href="mailto:palaute@pizzeriafiori.fi">palaute@pizzeriafiori.com</a>
				</p> -->
				<ul class="list-inline banner-social-buttons">

					<li><a href="https://www.facebook.com"><i
							class="fa fa-facebook-square fa-5x"></i></a></li>

					<li><a href="https://www.instagram.com"><i
							class="fa fa-instagram fa-5x"></i> </a></li>

					<li><a href="http://www.twitter.com"><i
							class="fa fa-twitter-square fa-5x"></i> </a></li>
							<br>
							
							<a href="palaute.jsp">Lähetä palautetta</a>

				</ul>
			
			</div>
	<div id="map"></div>
		<div class="container text-center">

			<p style="font-size: 13px">
				<a
					href="https://www.google.fi/maps/place/Sibeliuksenkatu+7,+13100+H%C3%A4meenlinna/@60.9961755,24.4617791,17z/data=!3m1!4b1!4m2!3m1!1s0x468e5d970c10edb3:0xa654c8617544564e">Sibeliuksenkatu
					7 <br> 13100 Hämeenlinna
					<br> Puh +358 40 666 6666
				</a>
				<br>
					<br> Aukioloajat MA-SU
					<br> Klo 9.00-23.00
			</p>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p style="font-size: 10px">
				<a href="adminkirjautuminen.jsp">Copyright &copy; Team SexYSexy
					2016</a>
			</p>
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

	<!-- Jos tulee jotain virhettä valittaessa kenttiä käyttäjäkirjautumisessa, niin nämä käyttöön! -->
	<!-- <script language="javascript">
		$('.dropdown-toggle').dropdown();
		$('.dropdown-menu').find('form').click(function(e) {
			e.stopPropagation();
		});

		$(
				'a.dropdown-toggle, .dropdown-menu a, .dropdown-menu input, .dropdown-menu button')
				.on('touchstart', function(e) {
					e.stopPropagation();
				});
	</script> -->




</body>
</html>