<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>



<html>
<head>
<meta charset="utf-8">
<title>SignUp</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<body style="background: lightblue">
	<figure style="text-align: left">
		<a href="images/logo_unical.png"><img class="img-responsive" src="images/logo_unical.png" alt="Sito Unical" width="460" height="345"/></a>
		<figcaption>Servizi online per lo studente</figcaption>
	</figure>
	<nav id="cssmenu" role="navigation" class="navbar navbar-inverse"
		style="background: darkblue">
		<ul class="nav navbar-nav">
			<li><a href="startMenu.html">Home</a></li>
			<li><a href="signup.jsp">SignUp</a></li>
			<li><a href="login.html">Login</a></li>
		</ul>
	</nav>


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
					<label class="control-label col-sm-2" for="indirizzo">Indirizzo:</label>
					<select name="indirizzo" class="control-label col-sm-10" class="form-control"  >
						<option value="1">Informatica</option>
						<option value="2">Ingegneria Informatica</option>
						<option value="3">Matematica</option>		
					</select>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>

		</div>
	</section>


</body>
</html>