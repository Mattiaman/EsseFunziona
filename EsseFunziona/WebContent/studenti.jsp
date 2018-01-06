<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head lang="it">
<title>Area Amministratore</title>
<meta charset="utf-8">
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/loaderStudenti.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<LINK rel="stylesheet" href="css/tableStyle.css" type="text/css">


<body style="background: lightblue">
	<figure style=" text-align: left">		
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>		
	</figure>

	<h3>Amministratore</h3>
	<nav class="menu" style="background: darkblue" >
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand" href="#">EsseFunziona</a>
    		</div>
    		<ul class="nav navbar-nav">
     			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Home<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="corsi.html">Corsi</a></li>
		          		<li><a href="documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="bandiNews.html">Bandi/News</a></li>
		        	</ul>
		        </li>	
		        <li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Utenti<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="studenti.jsp">Studenti</a></li>
		          		<li><a href="professori.html">Professori</a></li>
		        	</ul>
		        </li>	
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Segreteria<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="aggiuntaTasse.jsp">Aggiungere Tasse</a></li>
		          		<li><a href="aggiuntaBandi.jsp">Pubblicare Bandi/News</a></li>
		          		<li><a href="aggiuntaCorsi.jsp">Aggiungere Corsi</a></li>
		          		<li><a href="aggiuntaCorsiDiLaurea.jsp">Aggiungere Corsi Di Laurea</a></li>
		          		<li><a href="signupStudente.jsp">Registra Studente</a></li>
		          		<li><a href="signupProfessore.jsp">Registra Professore</a></li>        		
		        	</ul>
      			</li>
    		</ul>
  		</div>
	</nav>

	<br>
	<div class="container">
	  <div class="table-responsive">          
		  <table class="table">
		    <caption>Nominativo degli studenti iscritti</caption>
			<thead>
			<tr>
				<th>Matricola</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Data di Nascita</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="studente" items="${studenti}">
			<tr>
				<td>${studente.matricola}</td>
				<td>${studente.nome}</td>
				<td>${studente.cognome}</td>
				<td><time>${studente.dataDiNascita}</time></td>
				<td>${studente.email}</td>
				<td>${studente.corsoDiLaurea}</td>
				<td>${studente.pianoDiStudi}</td>
			</tr>			
			</c:forEach>
			</tbody>
		</table>
	  </div>
	</div>

</body>
</html>