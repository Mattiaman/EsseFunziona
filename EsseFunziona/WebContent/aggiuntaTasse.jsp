<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="tax" class="model.Tassa" scope="request" />
<jsp:setProperty name="tax" property="nome" value="un Nome"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Esse Funziona</title>
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
	<c:if test="${tassa != null}">
		<h1>Ho caricato la seguente Tassa</h1>
		<h3>${tassa.importo}</h3>
		<h3>${tassa.nome}</h3>
		<h3>${tassa.descrizione}</h3>
		<h3>${tassa.admin.nomeUtente}</h3>
	</c:if>
	<c:if test="${tassa == null}">
		<h3>Aggiungi una tassa</h3>
		<h4>Compila il seguente form per aggiungere una tassa</h4>
	
		<div>
		
			<form class="form-horizontal" method="post" action="aggiuntaTasse">
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="importoTassa">Importo:</label>
			    	<div class="col-sm-5"> 
			      <input name="importoTassa" type="text" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="nomeTassa">Nome:</label>
			    	<div class="col-sm-5"> 
			      <input name="nomeTassa" type="text" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-3" for="descrizioneTassa">Descrizione:</label>
			    	<div class="col-sm-5"> 
			      <input name="descrizioneTassa" type="text" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group"> 
			    	<div class="col-sm-offset-3 col-sm-5">
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