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
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/favicon.ico">
<title>Rekisteröidy</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap core CSS -->

<!-- MUOTOILU CTRL+SHIFT+F RIKKOO NÄMÄ TAGIT, ÄLÄ TEE!! -->
<style type="text/css">
<%@include file="/bootstrap/css/bootstrap.min.css"%>
</style>
    <!-- Custom CSS -->
<style type="text/css">
<%@include file="/bootstrap/css/grayscale.css"%>
</style>

<style type="text/css">
<%@include file="bootstrap/css/form-elements.css"%>
</style>

<style>
<%@include file="bootstrap/css/style.css"%>
</style>
 <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500" rel='stylesheet' type='text/css'>
        
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
    
        <!-- Favicon and touch icons -->
       
</head>

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
					<li><a class="page-scroll" href="#page-top">REKISTERÖIDY</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">KIRJAUDU</a>
						<div class="dropdown-menu" style="padding: 3px; background-color:transparent;">
							
							<!-- Tähän syötetään parametrit kirjautumista varten, jotka otetaan kirjautumisservletistä
							Samat kuin adminsivuilla, pitää vain käyttää omaa servlettiä?
							<form class="form-signin" method="post" action="kontrolleri"> MH -->
							
							<form action="KirjauduKayttaja" method="post">
							<br>
								<label for="inputEmail" class="sr-only" >Tunnus</label> <input style="margin-top: 8px"
									type="text" name="kayttajatunnus" class="form-control"
									placeholder="Tunnus" required autofocus> 
									
									<label
									for="inputPassword" class="sr-only">Salasana</label> <input  style="margin-top: 8px"
									type="text" name="salasana" class="form-control"
									placeholder="Salasana" required>
								<button class="btn btn-md"
									style="background-color:transparent; margin-top: 4px; font-size: 12px;"  type="submit" value="Login">Kirjaudu
									sisään</button>
							</form>
							<a href="rekisteroidy.jsp" class="btn btn-md"
									style="background-color:transparent; margin-top: 4px; font-size: 12px;">Rekisteröidy
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
						<h1 class="brand-heading" style="text-transform: none; text-shadow:2px 2px 2px black; letter-spacing:-8px; font-size:130px;">Rekisteröidy</h1>
						<br><br><br><br>
						<p class="intro-text" style="text-shadow:1px 1px 1px black;">
							Rekisteröidy kanta-asiakkaaksemme! <br>
							Saat etuja.
						</p>
						<a href="#about" class="btn btn-circle page-scroll"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- About Section//REKISTERÖIDY LOMAKE -->
	<!-- About Section//REKISTERÖIDY LOMAKE -->
	
<section id="about" class="container content-section text-center">
				<!-- Top content -->
      
      
      <div class="top-content">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Rekisteröidy</strong> Nyt</h1>
                            <div class="description">
                            	<p>
	                            	This is a free responsive registration form made with Bootstrap. 
	                            	Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col-sm-6 book">
                    		<img src="bootstrap/img/ebook.png" alt="">
                    	</div>
                        <div class="col-sm-5 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Lomake</h3>
                            		<h4>Täytä nyt ja pääse heti kiinni etuihin!</h4>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-pencil"></i>
                        		</div>
                            </div>
                            
                           <!--  Post methodit tänne, että käyttäjä saa salasanan jne. -->
                            <div class="form-bottom">
			                    <form role="form" action="" method="post" class="registration-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-first-name">Etunimi</label>
			                        	<input type="text" name="form-first-name" placeholder="Etunimi..." class="form-first-name form-control" id="form-first-name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-last-name">Sukunimi</label>
			                        	<input type="text" name="form-last-name" placeholder="Sukunimi..." class="form-last-name form-control" id="form-last-name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-email">Sähköposti</label>
			                        	<input type="text" name="form-email" placeholder="Sähköposti..." class="form-email form-control" id="form-email">
			                        </div>
			                        <button type="submit" class="btn">Rekisteröidy</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
				
			
		
   
     
	</section>
<!-- END OF About Section//REKISTERÖIDY LOMAKE -->
<!-- END OF About Section//REKISTERÖIDY LOMAKE -->
	



	<!-- Map Section -->
	<section id="yhteystiedot">
	<div id="map"></div>
		<div class="container text-center">
			<p style="font-size: 13px">
				<a
					href="https://www.google.fi/maps/place/Sibeliuksenkatu+7,+13100+H%C3%A4meenlinna/@60.9961755,24.4617791,17z/data=!3m1!4b1!4m2!3m1!1s0x468e5d970c10edb3:0xa654c8617544564e">Sibeliuksenkatu
					7 <br> 13100 Hämeenlinna
				</a>
			</p>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p style="font-size:10px"><a href="adminkirjautuminen.jsp">Copyright &copy; Team SexYSexy 2016</a></p>
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
	
	<!-- Javascript for reg form -->
        <script src="bootstrap/js/jquery-1.11.1.min.js"></script>
        <script src="bootstrap/js/jquery.backstretch.min.js"></script>
        <script src="bootstrap/js/retina-1.1.0.min.js"></script>
        <script src="bootstrap/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="bootstrap/js/placeholder.js"></script>
        <![endif]-->
	
	
	

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