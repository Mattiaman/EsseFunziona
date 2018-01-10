<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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


	<br>
		<div class="col-sm-10">
		
			<form class="form-horizontal" method="post" action="richiestaRicevimento">
			  <div class="form-group">
				<label class="control-label col-sm-2" for="professoreRicevimento">Professore:</label>
				<select name="professoreRicevimento" class="control-label col-sm-4" class="form-control"  >
					
				</select>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="dataRicevimento">Data:</label>
			    <div class="col-sm-4">
			     <input name="dataRicevimento" type="date" class="form-control" /> 
			    </div> 
			  </div>
			  </form>	
			  <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input name="validaDati" type="button" value="Valida Dati" class="btn btn-warning"/>
						<input name="resetDati" type="reset" value="Reset Dati"  class="btn btn-warning"/>
						<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/>
					</div>
			  </div>
		</div>

</body>
</html>