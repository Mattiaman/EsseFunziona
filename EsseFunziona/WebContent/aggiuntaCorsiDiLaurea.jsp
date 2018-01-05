<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="cdl" class="model.CorsoDiLaurea" scope="request" />
<jsp:setProperty name="cdl" property="nome" value="un Nome"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Amministratore</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  
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




	<c:if test="${corsoDL != null}">
		<h1>Ho caricato il seguente Corso di Laurea</h1>
		<p>${corsoDL.id}</p>
		<p>${corsoDL.nome}</p>
	</c:if>
	<c:if test="${bando == null}">
		<h3>Aggiungi un Corso di Laurea</h3>
		<h4>Compila il seguente form per aggiungere un Corso di Laurea</h4>
	
	<br><section class="moduloCorsiDiLaurea" class="row">
		<div>
		
			<form class="form-horizontal" method="post" action="aggiuntaCorsiDiLaurea">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="nomecdl">nome Corso di Laurea:</label>
			    	<div class="col-sm-3"> 
			      <input name="nomecdl" type="text" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group"> 
			    	<div class="col-sm-offset-2 col-sm-10">
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