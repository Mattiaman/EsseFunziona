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
  
<body style="background: lightblue">
	<figure style=" text-align: left">		
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>		
	</figure>

	<section class="col-sm-2">
	<div class="wrapper">
  		<nav class="vertical">
    		<div>
    			<a>Studente</a>
      			<a href="studentMenu.html">EsseFunziona</a>
    		</div>
    		<ul>
     			<li>
        			<label for="home">Home</label>
       				<input type="radio" name="verticalMenu" id="home" />
        			<div>
        			<ul>
		          		<li><a href="datiAnagrafici.html">Dati anagrafici</a></li>
		          		<li><a href="email.html">E-mail</a></li>
		          		<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="corsi.html">Corsi</a></li>
		          		<li><a href="documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="bandiNews.html">Bandi/News</a></li>
		          	</ul>
		        	</div>
		        </li>
      			<li>
      				<label for="segreteria">Segreteria</label>
       				<input type="radio" name="verticalMenu" id="segreteria" />
        			<div>
        			<ul>
		          		<li><a href="tasse.html">Situazione Tasse</a></li>
		          		<li><a href="libretto.html">Libretto</a></li>
		          		<li><a href="pianoDiStudio.html">Piano Carriera</a></li>
		          		<li><a href="modificaPiano.html">Modifica Piano</a></li>
		          	</ul>
		        	</div>
      			</li>
      			<li>
      				<label for="esami">Esami</label>
       				<input type="radio" name="verticalMenu" id="esami" />
        			<div>
        			<ul>
		          		<li><a href="appelli.html">Appelli</a></li>
		          		<li><a href="esiti.html">Bacheca Esiti</a></li>
		          		<li><a href="prenotazioni.html">Bacheca Prenotazioni</a></li>
		          		<li><a href="chiedereRicevimento.html">Chiedere un Ricevimento</a></li>
		          	</ul>
		        	</div>
      			</li>
    		</ul>
  		</nav>
	</div>
	</section>	


	<br>
		<div class="col-sm-10">
		
			<form class="form-horizontal" method="post" action="richiestaRicevimento">
			  <div class="form-group">
				<label class="control-label col-sm-2" for="professoreRicevimento">Professore:</label>
				<select name="indirizzo" class="control-label col-sm-4" class="form-control"  >
					<option value="0"></option>
					<option value="1">Ricca Francesco</option>
					<option value="2">Grasso Giovanni</option>	
				</select>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="dataRicevimento">Data:</label>
			    <div class="col-sm-4">
			     <input name="idMateriale" type="date" class="form-control" /> 
			    </div> 
			  </div>
			  </form>	
			  <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
			  </div>
		</div>

</body>
</html>