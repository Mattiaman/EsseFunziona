<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>

<html>
<head lang="it">
<meta charset="utf-8">
<title>Esse Funziona</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="js/loadDropDownStudenti.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">


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
	<c:if test="${studente != null}">
		<h1>Ho caricato il seguente studente</h1>
		<h3>${studente.matricola}</h3>
		<h3>${studente.nome}</h3>
		<h3>${studente.cognome}</h3>
		<h3>${studente.dataDiNascita}</h3>
		<h3>${studente.email}</h3>
		<h3>${studente.corsoDiLaurea.nome}</h3>
	</c:if>
	<c:if test="${studente == null}">
		<h3>Iscrivi un nuovo Studente</h3>
		<h4>Compila i seguente form per registrare un nuovo studente</h4>

		<div>

			<form class="form-horizontal" method="post" action="signupStudente">
				<div class="form-group">
					<label class="control-label col-sm-3" for="matricola">Matricola:</label>
					<div class="col-sm-5">
						<input name="matricola" type="text" class="form-control" />
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
					<label class="control-label col-sm-3"  for="email">Email:</label>
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
					<label class="control-label col-sm-3" for="corsoDiLaurea">Corso di Laurea:</label>
					<div class="col-sm-5">
						<select name="corsoDiLaurea" id="listaCdl">
						</select>
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