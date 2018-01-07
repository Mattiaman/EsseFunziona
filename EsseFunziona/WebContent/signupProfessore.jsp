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

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">

<body style="background: lightblue">
	<figure style="text-align: left">
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>
	</figure>
	

	<section class="col-sm-2">
	<div class="wrapper">
  		<nav class="vertical">
    		<div >
    			<a>Amministratore</a>
      			<a href="#">EsseFunziona</a>
    		</div>
    		<ul>
     			<li>
					<label for="home">Home</label>
       				<input type="radio" name="verticalMenu" id="home" />
        			<div>
		        	<ul>
		          		<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>
		          		<li><a href="corsi.html">Corsi</a></li>
		          		<li><a href="documentiCorsi.html">Documenti corsi</a></li>
		          		<li><a href="bandiNews.html">Bandi/News</a></li>
		        	</ul>
		        	</div>
		        </li>	
		        <li>
		        	<label for="blog">Utenti</label>
       				<input type="radio" name="verticalMenu" id="blog" />
        			<div>
        			<ul>
		          		<li><a href="studenti.html">Studenti</a></li>
		          		<li><a href="professori.html">Professori</a></li>
		        	</ul>
		        	</div>
		        </li>	
      			<li>
        			<label for="work">Segreteria</label>
       				<input type="radio" name="verticalMenu" id="work" />
		        	<div>
		        	<ul>
		          		<li><a href="aggiuntaTasse.jsp">Aggiungere Tasse</a></li>
		          		<li><a href="aggiuntaBandi.jsp">Pubblicare Bandi/News</a></li>
		          		<li><a href="aggiuntaCorsi.jsp">Aggiungere Corsi</a></li>
		          		<li><a href="aggiuntaCorsiDiLaurea.jsp">Aggiungere Corsi Di Laurea</a></li>
		          		<li><a href="signupStudente.jsp">Registra Studente</a></li>
		          		<li><a href="signupProfessore.jsp">Registra Professore</a></li>        		
		        	</ul>
		        	</div>
      			</li>
    		</ul>
  		</nav>
	</div>
	</section>
	
	
	<div class="col-sm-10">
	<c:if test="${professore != null}">
		<h1>Ho caricato il seguente professore</h1>
		<h3>${professore.nomeUtente}</h3>
		<h3>${professore.nome}</h3>
		<h3>${professore.cognome}</h3>
		<h3>${professore.dataDiNascita}</h3>
		<h3>${professore.email}</h3>
	</c:if>
	<c:if test="${professore == null}">
		<h3>Iscrivi un nuovo Professore</h3>
		<h4>Compila i seguente form per registrare un nuovo professore</h4>
	
	
		<div>
			<form class="form-horizontal" method="post" action="signupProfessore">
				<div class="form-group">
					<label class="control-label col-sm-3" for="nomeUtente">Nome Utente:</label>
					<div class="col-sm-5">
						<input name="nomeUtente" type="text" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-3" for="nome">Nome:</label>
					<div class="col-sm-5">
						<input name="nome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3"  for="cognome">Cognome:</label>
					 <div class="col-sm-5">
						<input name="cognome" type="text"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3"  for="dataNascita">Data di Nascita:</label> 
					<div class="col-sm-5">
						<input name="dataNascita" type="date" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label  class="control-label col-sm-3" for="email">Email:</label>
					<div class="col-sm-5">
						<input name="email" type="email"class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="password">Password:</label>
					<div class="col-sm-5">
						<input name="password" type="password" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="confermapassword">Conferma Password:</label>
					<div class="col-sm-5">
						<input name="confermapassword" type="password" class="form-control" />
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