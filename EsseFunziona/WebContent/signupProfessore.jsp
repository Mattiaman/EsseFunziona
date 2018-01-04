<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="prof" class="model.Professore" scope="request" />
<jsp:setProperty name="prof" property="nome" value="un Nome"/>



<html>
<head lang="it">
<meta charset="utf-8">
<title>SignUp Professore</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<body style="background: lightblue">
	<figure style="text-align: left">
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
		          		<li><a href="report/corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="report/corsi.html">Corsi</a></li>
		          		<li><a href="report/documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="report/bandiNews.html">Bandi/News</a></li>
		        	</ul>
		        </li>	
		        <li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Utenti<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="studenti.jsp">Studenti</a></li>
		          		<li><a href="report/professori.html">Professori</a></li>
		        	</ul>
		        </li>	
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="background: darkblue">Segreteria<span class="caret"></span></a>
		        	<ul class="dropdown-menu">
		          		<li><a href="report/aggiuntaTasse.html">Aggiungere Tasse</a></li>
		          		<li><a href="report/aggiuntaBandi.html">Pubblicare Bandi/News</a></li>
		          		<li><a href="signupStudente.jsp">Registra Studente</a></li>
		          		<li><a href="signupProfessore.jsp">Registra Professore</a></li>
		        	</ul>
      			</li>
    		</ul>
  		</div>
	</nav>


	<c:if test="${professore != null}">
		<h1>Ho caricato il seguente professore</h1>
		<p>${professore.nomeUtente}</p>
		<p>${professore.nome}</p>
		<p>${professore.cognome}</p>
		<p>${professore.dataDiNascita}</p>
		<p>${professore.email}</p>
	</c:if>
	<c:if test="${professore == null}">
		<h1>Iscrivi un nuovo Professore</h1>
		<h2>Compila i seguente form per registrare un nuovo professore</h2>
	
	<section class="moduloRegistrazione" class="row">
		<div class="col-lg-3">

			<form class="form-horizontal" method="post" action="signupProfessore">
				<div class="form-group">
					<label class="control-label col-sm-3" for="nomeUtente">Nome Utente:</label>
					<div class="col-sm-9">
						<input name="nomeUtente" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-3" for="nome">Nome:</label>
					<div class="col-sm-9">
						<input name="nome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3"  for="cognome">Cognome:</label>
					 <div class="col-sm-9">
						<input name="cognome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3"  for="dataNascita">Data di Nascita:</label> 
					<div class="col-sm-9">
						<input name="dataNascita" type="date" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-3" for="email">Email:</label>
					<div class="col-sm-9">
						<input name="email" type="email"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="password">Password:</label>
					<div class="col-sm-9">
						<input name="password" type="password" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="confermapassword">Conferma Password:</label>
					<div class="col-sm-9">
						<input name="confermapassword" type="password" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-12">
						<input name="validaDati" type="button" value="Valida Dati" class="btn btn-warning"/>
						<input name="resetDati" type="reset" value="Reset Dati"  class="btn btn-warning"/>
						<input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/>
					</div>
				</div>
			</form>

		</div>
	</section>
</c:if>

</body>
</html>