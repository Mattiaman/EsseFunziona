<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="mtl" class="model.Materiale" scope="request" />
<jsp:setProperty name="mtl" property="id" value="1"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Professore</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  
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
	<c:if test="${materiale != null}">
		<h1>Ho caricato il seguente materiale</h1>
		<h3>${materiale.contenuto}</h3>
		<h3>${materiale.professore.nomeUtente}</h3>
	</c:if>
	<c:if test="${materiale == null}">
		<h3>Aggiungi un materiale</h3>
		<h4>Compila il seguente form per aggiungere un materiale</h4>
	
		<div>
			<form class="form-horizontal" method="post" action="aggiuntaMateriale">
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="contenutoMateriale">ContenutoMateriale:</label>
			    	<div class="col-sm-5"> 
			      <input name="contenutoMateriale" type="file" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="nomeUtente">Nome Utente:</label>
			    	<div class="col-sm-5"> 
			      <input name="nomeUtente" type="text" class="form-control" />
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