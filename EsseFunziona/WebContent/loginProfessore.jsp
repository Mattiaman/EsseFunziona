<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">


<body style="background: lightblue">
	<figure style=" text-align: left">		
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>		
	</figure>

	<section class="col-sm-2">
	<div class="wrapper">
  		<nav class="vertical">
    		<div>
      			<a href="adminMenu.html">EsseFunziona</a>
    		</div>
    		<ul>
				<li> 
					<a href="startMenu.html">Home</a>
				</li>
				<li>
					<a href="loginStudente.jsp">Login Studente</a>
				</li>
				<li>
					<a href="loginProfessore.jsp">Login Prof</a>
				</li>
				<li>
					<a href="loginAdmin.jsp">Login Admin</a>
				</li>
    		</ul>
  		</nav>
	</div>
	</section>

	
	<div class="intestazione">Accedi come Professore</div>
	<div class="col-sm-10">
		
			<c:if test="${password != null }">
				<h3>Nome Utente o Password Errati</h3>
			</c:if>	
		
			<form class="form-horizontal" method="post" action="loginProfessore">
			  <div class="form-group">
			    <label class="control-label col-sm-1" for="nomeUtente">UserID:</label>
			    <div class="col-sm-offset-1 col-sm-5">
			     <input name="nomeUtente" type="text" class="form-control" /> 
			    </div> 
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-1" for="password">Password:</label>
			    	<div class="col-sm-offset-1 col-sm-5"> 
			      <input name="password" type="password" class="form-control" />
			    </div>
			  </div>
			  <div class="form-group"> 
			    <div>
			      <button type="submit" class="btn btn-default">Submit</button>
			    </div>
			  </div>
			</form>
			
	</div>
	
</body>



</html>