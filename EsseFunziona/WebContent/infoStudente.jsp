<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>

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
<script type="text/javascript" src="js/loaderInfo.js"></script>
  
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

		<br>	
		<c:if test="${studente!=null }">
		<div>	
		
		 	<h3>Studente</h3>
		 	<label class="control-label col-sm-4" >Matricola: </label><label class="control-label col-sm-8" >${studente.matricola}</label>
		 	<label class="control-label col-sm-4" >Nome: </label><label class="control-label col-sm-8" >${studente.nome}</label>
		 	<label class="control-label col-sm-4" >Cognome: </label><label class="control-label col-sm-8" >${studente.cognome}</label>
		 	<label class="control-label col-sm-4" >Data di Nascita: </label><label class="control-label col-sm-8" >${studente.dataDiNascita}</label>
		 	<label class="control-label col-sm-4" >E-Mail: </label><label class="control-label col-sm-8" >${studente.email}</label>
		
		</div>
		<div>
			<table class="table" id="tabellaCorsi">
			    <thead>
			      <tr>
			        <th>ID Corso</th>
			        <th>Nome Corso</th>
			      </tr>
			    </thead>
		   		<tbody id="listaCorsi">	     		
	    		</tbody>
	  		</table>
		</div>
		<script type="text/javascript">
			caricaPDS(${studente.matricola})
		</script>
		</c:if>
	</div>
</body>
</html>