<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="app" class="model.Appello" scope="request" />
<jsp:setProperty name="app" property="id" value="1"/>


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
	
	<div class="col-sm-10">
	<c:if test="${appello != null}">
		<h1>Ho caricato il seguente studente</h1>
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
		
			<form class="form-horizontal" method="post" action="aggiuntaAppello">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="idAppello">IDAppello:</label>
			    <div class="col-sm-4">
			     <input name="idAppello" type="text" class="form-control" /> 
			    </div> 
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="dataAppello">dataAppello:</label>
			    	<div class="col-sm-4"> 
			      <input name="dataAppello" type="date" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="corsoAppello">ID Corso:</label>    	
			    	<div class="col-sm-4"> 
			      	<input name="corsoAppello" type="text" class="form-control" />
			      	</div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="nomeUtente">Nome Utente:</label>
			    	<div class="col-sm-4"> 
			      <input name="nomeUtente" type="text" class="form-control" />
			    	</div>
			  </div>
			  <div class="form-group"> 
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			  </div>
			</form>
			
	</div>
	
	</c:if>
	</div>
	
	
</body>
</html>