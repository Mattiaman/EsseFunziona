$(document).ready(function() {
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		
		var s ='';
		if(datiAnagrafici.tipo == "studente"){
				s = $('<div><a>'+datiAnagrafici.matricola+' </a><a href="studentMenu.html">EsseFunziona</a></div>'+
						'<ul><li>'+
						'<label for="home">Home</label><input type="radio" name="verticalMenu" id="home" />'+
						'<div><ul>'+
						'<li><a href="datiAnagrafici.jsp">Dati anagrafici</a></li>'+
						'<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>'+
						'<li><a href="corsi.html">Corsi</a></li>'+
						'<li><a href="documentiCorsi.html">Documenti corsi</a></li>'+
						'<li><a href="bandiNews.html">Bandi/News</a></li>'+
						'<li><a href="professori.html">Professori</a></li>'+
						'<li id="logout"><a href="startMenu.html">Logout</a></li>'+
						'</ul></div></li>'+
						'<li><label for="segreteria">Segreteria</label><input type="radio" name="verticalMenu" id="segreteria" />'+
						'<div><ul>'+
						'<li><a href="libretto.html">Libretto</a></li>'+
						'</ul></div></li>'+
						'<li><label for="esami">Esami</label><input type="radio" name="verticalMenu" id="esami" />'+
						'<div><ul>'+
						'<li><a href="appelli.html">Appelli</a></li>'+
						'<li><a href="esiti.html">Bacheca Esiti</a></li>'+
						'<li><a href="prenotazione.jsp">Prenotazione</a></li>'+
						'<li><a href="prenotazioni.html">Bacheca Prenotazioni</a></li>'+
						'<li><a href="chiedereRicevimento.jsp"=>Chiedere un Ricevimento</a></li>'+
						'<li><a href="editPds.html">PianoDiStudi</a></li>'+
						'</ul></div></li></ul>');	
				$("#navMenu").append(s);
		}
		else if(datiAnagrafici.tipo == "professore"){
				s = $('<div><a>'+datiAnagrafici.nomeUtente+' </a><a href="profMenu.html">EsseFunziona</a></div>'+
						'<ul><li>'+
						'<label for="home">Home</label><input type="radio" name="verticalMenu" id="home" />'+
						'<div><ul>'+
						'<li><a href="datiAnagrafici.jsp">Dati anagrafici</a></li>'+
						'<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>'+
						'<li><a href="corsi.html">Corsi</a></li>'+
						'<li><a href="documentiCorsi.html">Documenti corsi</a></li>'+
						'<li><a href="bandiNews.html">Bandi/News</a></li>'+
						'<li><a href="professori.html">Professori</a></li>'+
						'<li id="logout"><a href="startMenu.html">Logout</a></li>'+
						'</ul></div></li>'+
						'<li><label for="studenti">Studenti</label><input type="radio" name="verticalMenu" id="studenti" />'+
						'<div><ul>'+
						'<li><a href="studenti.html">Studenti</a></li>'+
						'<li><a href="richiesteRicevimento.jsp">Richieste Ricevimenti</a></li>'+
						'</ul></div></li>'+
						'<li><label for="esami">Esami</label><input type="radio" name="verticalMenu" id="esami" />'+
						'<div><ul>'+
						'<li><a href="appelli.html">Appelli</a></li>'+
						'<li><a href="aggiuntaAppelli.jsp">Aggiunta Appelli</a></li>'+
						'<li><a href="aggiuntaEsiti.jsp">Aggiunta Esiti</a></li>'+
						'<li><a href="aggiuntaMateriale.jsp">Aggiunta Documenti corsi</a></li>'+
						'</ul></div></li></ul>');
				$("#navMenu").append(s);
		}
		else if(datiAnagrafici.tipo == "admin"){
				s = $('<div><a>'+datiAnagrafici.nomeUtente+' </a><a href="adminMenu.html">EsseFunziona</a></div>'+
						'<ul><li>'+
						'<label for="home">Home</label><input type="radio" name="verticalMenu" id="home" />'+
						'<div><ul>'+
						'<li><a href="corsiDiLaurea.html">Corsi Di Laurea</a></li>'+
						'<li><a href="corsi.html">Corsi</a></li>'+
						'<li><a href="documentiCorsi.html">Documenti corsi</a></li>'+
						'<li><a href="bandiNews.html">Bandi/News</a></li>'+
						'<li><a href="tasseAdmin.html">Tasse</a></li>'+
						'<li id="logout"><a href="startMenu.html">Logout</a></li></ul>'+
						'</div></li>'+
						'<li><label for="utenti">Utenti</label><input type="radio" name="verticalMenu" id="utenti" />'+
						'<div><ul>'+
						'<li><a href="studenti.html">Studenti</a></li>'+
						'<li><a href="professori.html">Professori</a></li>'+
						'</div></li>'+
						'<li><label for="segreteria">Segreteria</label><input type="radio" name="verticalMenu" id="segreteria" />'+
						'<div><ul>'+    		
						'<li><a href="aggiuntaTasse.jsp">Aggiungere Tasse</a></li>'+
						'<li><a href="modificaStatoTasse.html">Gestisci tasse</a></li>'+
						'<li><a href="aggiuntaBandi.jsp">Pubblicare Bandi/News</a></li>'+
						'<li><a href="aggiuntaCorsi.jsp">Aggiungere Corsi</a></li>'+
						'<li><a href="aggiuntaCorsiDiLaurea.jsp">Aggiungere Corsi Di Laurea</a></li>'+
						'<li><a href="editCdl.html">Modifica Corsi</a></li>'+
						'<li><a href="editProf.html">Modifica Professori</a></li>'+
						'<li><a href="signupStudente.jsp">Registra Studente</a></li>'+
						'<li><a href="signupProfessore.jsp">Registra Professore</a></li>'+
						'<li><a href="accettaPiani.html">Visiona Piani di Studio</a></li>'+
						'</ul></div></li></ul>');
				$("#navMenu").append(s);
		}
			
		
		else {
			$("body").empty();
			s = $('<a href="startMenu.html">Torna al menu</a>');
			$('body').append(s);
		}
		$('#logout').on('click',function(){
			$.ajax({
				url : 'logout',
				type : 'POST'
			});
		})
	}
	xhr.send(null);
});

function doLogout(){
	$('#logout').on('click',function(){
		var xhrOut=new XMLHttpRequest();
		xhrOut.open('get',"Logout",true)
		xhrOut.send(null);
	})
}