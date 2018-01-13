<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="prof" class="model.Professore" scope="request" />
<jsp:setProperty name="prof" property="nome" value="un Nome"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Studente</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">
<LINK rel="stylesheet" href="css/tableStyle.css" type="text/css">
  

<script type="text/javascript" src="js/loaderMenu.js"></script>
<script type="text/javascript" src="js/loaderProfessori2.js"></script>
  
<body style="background: lightblue">
	<figure style=" text-align: left">		
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>		
	</figure>
	
	<section class="col-sm-2">
	<div class="wrapper">
  		<nav class="vertical" id="navMenu">
    		
  		</nav>
	</div>
	</section>	


<section class="col-sm-10">
<br>
<div>
		<c:if test="${professore != null }">
			<h1>Ho chiesto il ricevimento al professore</h1>
			<h3>${professore.nomeUtente}</h3>
		</c:if>
		<c:if test="${professore == null }">
		<form class="form-horizontal" method="post" action="chiedereRicevimento">
		  <div class="form-group">
			<label class="control-label col-sm-2" for="professoreRicevimento">Professore:</label>
			<div class="col-sm-5">
				<select name="professoreRicevimento" id="opzioniProfessori">
				</select>
			</div>
		  </div>
		 	
		  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/>
				</div>
		  </div>
		   </form>
		</c:if>

</div>
</section>
</body>
</html>