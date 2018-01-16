<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="stud" class="model.Studente" scope="request" />
<jsp:setProperty name="stud" property="nome" value="un Nome"/>
<jsp:useBean id="prof" class="model.Professore" scope="request" />
<jsp:setProperty name="prof" property="nome" value="un Nome"/>
<jsp:useBean id="adm" class="model.Admin" scope="request" />
<jsp:setProperty name="adm" property="nome" value="un Nome"/>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Esse Funziona</title>
</head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/navStyle.css" type="text/css">
<LINK rel="stylesheet" href="css/tableStyle.css" type="text/css">
  
<script type="text/javascript" src="js/loaderData.js"></script>  
  

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

	<br>
	
	<div class="col-sm-10" id="utenteRegistrato">

	</div>
</body>
</html>