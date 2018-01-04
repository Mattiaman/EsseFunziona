<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>

<jsp:useBean id="corsoDiLaurea" class="model.CorsoDiLaurea" scope="request" />
<jsp:setProperty name="corsoDiLaurea" property="nome" value="un Nome"/>

<html>
<head lang="it">
<meta charset="utf-8">
<title>SignUp Studente</title>
</head>

<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<body style="background: lightblue">
	<figure style="text-align: left">
		<a href="images/logo_unical.png"><img class="img-responsive" src="../images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
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
		          		<li><a href="aggiuntaBandi.html">Pubblicare Bandi/News</a></li>
		          		<li><a href="signupStudente.jsp">Registra Studente</a></li>
		          		<li><a href="">Registra Professore</a></li>
		        	</ul>
      			</li>
    		</ul>
  		</div>
	</nav>


	<c:if test="${studente != null}">
		<h1>Ho caricato il seguente studente</h1>
		<p>${studente.matricola}</p>
		<p>${studente.nome}</p>
		<p>${studente.cognome}</p>
		<p>${studente.dataNascita}</p>
	</c:if>
	<c:if test="${studente == null}">
		<h3>Iscrivi un nuovo Studente</h3>
		<h4>Compila i seguente form per registrare un nuovo studente</h4>
	</c:if>

	<section class="moduloRegistrazione" class="row">
		<div>

			<form class="form-horizontal" method="post" action="registrazione">
				<div class="form-group">
					<label class="control-label col-sm-2" for="matricola">Matricola:</label>
					<div class="col-sm-3">
						<input name="matricola" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-2" for="nome">Nome:</label>
					<div class="col-sm-3">
						<input name="nome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"  for="cognome">Cognome:</label>
					 <div class="col-sm-3">
						<input name="cognome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"  for="dataNascita">Data di Nascita:</label> 
					<div class="col-sm-3">
						<input name="dataNascita" type="date" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="password">Password:</label>
					<div class="col-sm-3">
						<input name="password" type="password" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="confermapassword">Conferma Password:</label>
					<div class="col-sm-3">
						<input name="confermapassword" type="password" class="form-control" />
					</div>
				</div>
		
				<div class="form-group">
					<label class="control-label col-sm-2" for="corsoDiLaurea">Corso di Laurea:</label>
					<select name="corsoDiLaurea" class="control-label col-sm-3" class="form-control"  >
						<c:forEach var="corsoDiLaurea" items="${corsiDiLaurea}" >
							<option>${corsoDiLaurea.nome}</option>
						</c:forEach>
								
					</select>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<input name="validaDati" type="button" value="Valida Dati" class="btn btn-warning"/>
						<input name="resetDati" type="reset" value="Reset Dati"  class="btn btn-warning"/>
						<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/>
					</div>
				</div>
			</form>

		</div>
	</section>

</body>
</html>