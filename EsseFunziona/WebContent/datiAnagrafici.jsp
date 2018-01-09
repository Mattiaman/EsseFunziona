<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="studente" class="model.Studente" scope="request" />
<jsp:useBean id="professore" class="model.Professore" scope="request" />
<jsp:useBean id="admin" class="model.Admin" scope="request" />


<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Professore</title>
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
    			<a>Professore</a>
      			<a href="profMenu.html">EsseFunziona</a>
    		</div>
    		<ul>
     			<li>
        			<label for="home">Home</label>
       				<input type="radio" name="verticalMenu" id="home" />
        			<div>
        			<ul>
		          		<li><a href="datiAnagrafici.jsp">Dati anagrafici</a></li>
		          		<li><a href="email.jsp">E-mail</a></li>
		          		<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="corsi.html">Corsi</a></li>
		          		<li><a href="documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="bandiNews.html">Bandi/News</a></li>
		          	</ul>
		        	</div>
		        </li>
      			<li>
      				<label for="studenti">Studenti</label>
       				<input type="radio" name="verticalMenu" id="studenti" />
        			<div>
        			<ul>
		          		<li><a href="pianoDiStudio.html">Piano Carriera</a></li>
		          		<li><a href="richiesteRicevimento.jsp">Richieste Ricevimento</a></li>
		          	</ul>
		        	</div>
      			</li>
      			<li>
      				<label for="esami">Esami</label>
       				<input type="radio" name="verticalMenu" id="esami" />
        			<div>
        			<ul>
		          		<li><a href="appelli.html">Appelli</a></li>
		          		<li><a href="aggiuntaAppelli.jsp">Aggiunta Appelli</a></li>
		          		<li><a href="aggiuntaEsiti.jsp">Aggiunta Esiti</a></li>
		          		<li><a href="aggiuntaMateriale.jsp">Aggiunta Documenti corsi</a></li>
		          		<li><a href="verbalizzareEsami.html">Verbalizzare</a></li>
		          		<li><a href="esiti.html">Bacheca Esiti</a></li>
		          		<li><a href="prenotazioni.html">Bacheca Prenotazioni</a></li>
		          	</ul>
		        	</div>
      			</li>
    		</ul>
  		</nav>
	</div>
	</section>	

	<br>
	<c:if test="${utente == studente}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${utente.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${utente.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${utente.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${utente.email}</label>
		<label class="control-label col-sm-2" for="matricola">Matricola</label>
				<label class="control-label col-sm-10">${utente.matricola}</label>
		<label class="control-label col-sm-2" for="cdl">CdL</label>
				<label class="control-label col-sm-10">${utente.corsoDiLaurea.id}</label>
	</div>
	</c:if>
	<c:if test="${utente == professore}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${utente.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${utente.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${utente.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${utente.email}</label>
		<label class="control-label col-sm-2" for="nomeUtente">Nome Utente</label>
				<label class="control-label col-sm-10">${utente.nomeUtente}</label>
		<label class="control-label col-sm-2" for="cdl">CdL</label>
				<label class="control-label col-sm-10">${utente.corsoDiLaurea.id}</label>
	</div>
	</c:if>
	<c:if test="${utente == admin}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${utente.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${utente.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${utente.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${utente.email}</label>
		<label class="control-label col-sm-2" for="nomeUtente">Nome Utente</label>
				<label class="control-label col-sm-10">${utente.nomeUtente}</label>
	</div>
	</c:if>
	<c:if test="${utente != studente}">
		<c:if test="${utente != professore}">
			<c:if test="${utente != admin}">
				<h1>Prima dovresti loggarti</h1>
				<a href="loginProfessore.html">Come Professore</a>
				<a href="loginAdmin.html">Come Admin</a>
				<a href="loginStudente.html">Come Studente</a>
			</c:if>
		</c:if>
	</c:if>
</body>
</html>