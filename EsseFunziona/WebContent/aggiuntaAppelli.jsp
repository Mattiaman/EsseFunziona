<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="app" class="model.Appello" scope="request" />
<jsp:setProperty name="app" property="id" value="1"/>


<html>
<head>
<meta charset="UTF-8">
<title>Esse Funziona</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">
<LINK rel="stylesheet" href="css/tableStyle.css" type="text/css">
  

<script type="text/javascript" src="js/loaderMenu.js"></script>
<script type="text/javascript" src="js/loaderCorsi2.js"></script>
  
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
	
	<div class="col-sm-10">
	<c:if test="${appello != null}">
		<h1>Ho caricato il seguente appello</h1>
		<h3>${appello.id}</h3>
		<h3><time>${appello.data}</time></h3>
		<h3>${appello.professore.nomeUtente}</h3>
		<h3>${appello.corso.id}</h3>
	</c:if>
	<c:if test="${appello == null}">
		<h3>Iscrivi un nuovo appello</h3>
		<h4>Compila i seguente form per registrare un nuovo appello</h4>
	
	<br>
	<div>
		
			<form class="form-horizontal" method="post" action="aggiuntaAppelli">
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="dataAppello">dataAppello:</label>
			    	<div class="col-sm-5"> 
			      <input name="dataAppello" type="date" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="corsoAppello">ID Corso:</label>    	
			    	<div> 
			      	<select name="corsoAppello" id="listaCorsi">
			      	</select>
			      	</div>
			  </div>
			  <div class="form-group"> 
			    	<div class="col-sm-offset-3 col-sm-5">
						<input name="validaDati" type="button" value="Valida Dati" class="btn btn-warning"/>
						<input name="resetDati" type="reset" value="Reset Dati"  class="btn btn-warning"/>
						<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/>
					</div>
			  </div>
			</form>
			
	</div>
	
	</c:if>
	</div>
	
	
</body>
</html>