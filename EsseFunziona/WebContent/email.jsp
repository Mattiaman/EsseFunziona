<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
<head>
<meta charset="ISO-8859-1">
<title>Esse Funziona</title>
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

<div class="col-sm-10">
	<br><div class="container">
	  <div class="table-responsive">          
	  <table class="table" id="tabellaEmail">
	    <thead>
	      <tr>
	        <th>#</th>
	        <th>Mittente</th>
	        <th>Oggetto</th>
	        <th>Contenuto</th>
	        <th>...</th>  
	      </tr>
	    </thead>
	    <tbody id="listaEmail">
	    </tbody>
	  </table>
	  </div>
	</div>
	
	
	
	
	<br>
		
			<h3>Inviare una e-mail</h3>
			<form class="form-horizontal" method="post" action="invioE-mail">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="destinatarioE-mail">Destinatario:</label>
			    <div class="col-sm-4">
			     <input name="destinatarioE-mail" type="text" class="form-control" /> 
			    </div> 
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="oggettoE-mail">Oggetto:</label>
			    <div class="col-sm-4">
			     <input name="oggettoE-mail" type="text" class="form-control" /> 
			    </div> 
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="contenutoE-mail">Contenuto:</label>
			    <div class="col-sm-4">
			     <input name="contenutoE-mail" type="text" class="form-control" /> 
			    </div> 
			  </div>
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			  </div>	
			  </form>	
		</div>

</body>
</html>