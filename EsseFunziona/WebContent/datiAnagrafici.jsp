<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>
<jsp:useBean id="prof" class="model.Professore" scope="request" />
<jsp:setProperty name="prof" property="nome" value="un Nome"/>
<jsp:useBean id="adm" class="model.Admin" scope="request" />
<jsp:setProperty name="adm" property="nome" value="un Nome"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>EsseFunziona</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">
<LINK rel="stylesheet" href="css/tableStyle.css" type="text/css">
  
<script type="text/javascript">
$(document).ready(function() {
	console.log(studente)
});
</script>  
  
<body style="background: lightblue">
	<figure style=" text-align: left">		
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>		
	</figure>

	<section class="col-sm-2">
	<div class="wrapper">
  		<nav class="vertical">
    		<div>
    			<a>${studente.matricola}</a>
    			<a>${professore.nomeUtente}</a>
    			<a>${admin.nomeUtente}</a>
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
	<c:if test="${studente != null}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${studente.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${studente.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${studente.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${studente.email}</label>
		<label class="control-label col-sm-2" for="matricola">Matricola</label>
				<label class="control-label col-sm-10">${studente.matricola}</label>
		<label class="control-label col-sm-2" for="cdl">CdL</label>
				<label class="control-label col-sm-10">${studente.corsoDiLaurea.nome}</label>
	</div>
	</c:if>
	<c:if test="${professore != null}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${professore.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${professore.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${professore.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${professore.email}</label>
		<label class="control-label col-sm-2" for="nomeUtente">Nome Utente</label>
				<label class="control-label col-sm-10">${professore.nomeUtente}</label>
		<label class="control-label col-sm-2" for="cdl">CdL</label>
				<label class="control-label col-sm-10">${professore.corsoDiLaurea.id}</label>
	</div>
	</c:if>
	<c:if test="${admin != null}">
	<div class="col-sm-10">
		<label class="control-label col-sm-2" for="nome">Nome</label>
				<label class="control-label col-sm-10">${admin.nome}</label>
		<label class="control-label col-sm-2" for="cognome">Cognome</label>
				<label class="control-label col-sm-10">${admin.cognome}</label>
		<label class="control-label col-sm-2" for="datadiNascita">Data di Nascita</label>
				<label class="control-label col-sm-10">${admin.dataDinascita}</label>
		<label class="control-label col-sm-2" for="e-mail">E-mail</label>
				<label class="control-label col-sm-10">${admin.email}</label>
		<label class="control-label col-sm-2" for="nomeUtente">Nome Utente</label>
				<label class="control-label col-sm-10">${admin.nomeUtente}</label>
	</div>
	</c:if>
	<c:if test="${studente == null}">
		<c:if test="${professore == null}">
			<c:if test="${admin == null}">
				<h1>Prima dovresti loggarti</h1>
				<a href="loginProfessore.html">Come Professore</a>
				<a href="loginAdmin.html">Come Admin</a>
				<a href="loginStudente.html">Come Studente</a>
			</c:if>
		</c:if>
	</c:if>
</body>
</html>