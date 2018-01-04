<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>



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
		          		<li><a href="report/corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="report/corsi.html">Corsi</a></li>
		          		<li><a href="report/documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="report/bandiNews.html">Bandi/News</a></li>
		        	</ul>
		        </li>	
		        <li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Utenti<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="report/studenti.html">Studenti</a></li>
		          		<li><a href="report/professori.html">Professori</a></li>
		        	</ul>
		        </li>	
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Segreteria<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="report/aggiuntaTasse.html">Aggiungere Tasse</a></li>
		          		<li><a href="report/aggiuntaBandi.html">Pubblicare Bandi/News</a></li>
		          		<li><a href="report/signup.jsp">Registra Studente</a></li>
		          		<li><a href="report/">Registra Professore</a></li>
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
		<h1>Iscrivi un nuovo Studente</h1>
		<h2>Compila i seguente form per registrare un nuovo studente</h2>
	</c:if>

	<section class="moduloRegistrazione" class="row">
		<div class="col-lg-3">

			<form class="form-horizontal" method="post" action="registrazione">
				<div class="form-group">
					<label class="control-label col-sm-2" for="matricola">Matricola:</label>
					<div class="col-sm-10">
						<input name="matricola" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-2" for="nome">Nome:</label>
					<div class="col-sm-10">
						<input name="nome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"  for="cognome">Cognome:</label>
					 <div class="col-sm-10">
						<input name="cognome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"  for="dataNascita">Data di Nascita:</label> 
					<div class="col-sm-10">
						<input name="dataNascita" type="date" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="password">Password:</label>
					<div class="col-sm-10">
						<input name="password" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="confermapassword">Conferma Password:</label>
					<div class="col-sm-10">
						<input name="confermapassword" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="indirizzo">Indirizzo:</label>
					<select name="indirizzo" class="control-label col-sm-10" class="form-control"  >
						<option value="1">Informatica</option>
						<option value="2">Ingegneria Informatica</option>
						<option value="3">Matematica</option>		
					</select>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input name="validaDati" type="button" value="Valida Dati" class="btn btn-warning"/>
					</div>
					<div class="col-sm-offset-2 col-sm-10">
						<input name="resetDati" type="reset" value="Reset Dati"  class="btn btn-danger"/>
					</div>
					<div class="col-sm-offset-2 col-sm-10">
						<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-success"/>
					</div>
				</div>
			</form>

		</div>
	</section>


</body>
</html>