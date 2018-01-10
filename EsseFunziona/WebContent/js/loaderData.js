$(document).ready(function() {
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		
		var s ='';
		if(datiAnagrafici.tipo == "studente"){
			s = $('<label class="control-label col-sm-4" for="nome">Nome</label><label class="control-label col-sm-8">'+datiAnagrafici.nome+
					'</label><label class="control-label col-sm-4" for="cognome">Cognome</label><label class="control-label col-sm-8">'+datiAnagrafici.cognome+
					'</label><label class="control-label col-sm-4" for="datadiNascita">Data Di Nascita</label><label class="control-label col-sm-8">'+datiAnagrafici.dataDiNascita+
					'</label><label class="control-label col-sm-4" for="email">Email</label><label class="control-label col-sm-8">'+datiAnagrafici.email+
					'</label><label class="control-label col-sm-4" for="matricola">Matricola</label><label class="control-label col-sm-8">'+datiAnagrafici.matricola+
					'</label>');	
		}
		else if(datiAnagrafici.tipo == "professore"){
			s = $('<label class="control-label col-sm-4" for="nome">Nome</label><label class="control-label col-sm-8">'+datiAnagrafici.nome+
					'</label><label class="control-label col-sm-4" for="cognome">Cognome</label><label class="control-label col-sm-8">'+datiAnagrafici.cognome+
					'</label><label class="control-label col-sm-4" for="datadiNascita">Data Di Nascita</label><label class="control-label col-sm-8">'+datiAnagrafici.dataDiNascita+
					'</label><label class="control-label col-sm-4" for="email">Email</label><label class="control-label col-sm-8">'+datiAnagrafici.email+
					'</label><label class="control-label col-sm-4" for="nomeUtente">Nome utente</label><label class="control-label col-sm-8">'+datiAnagrafici.nomeUtente+
					'</label>');	
		}
		else if(datiAnagrafici.tipo == "admin"){
			s = $('<label class="control-label col-sm-4" for="nome">Nome</label><label class="control-label col-sm-8">'+datiAnagrafici.nome+
					'</label><label class="control-label col-sm-4" for="cognome">Cognome</label><label class="control-label col-sm-8">'+datiAnagrafici.cognome+
					'</label><label class="control-label col-sm-4" for="datadiNascita">Data Di Nascita</label><label class="control-label col-sm-8">'+datiAnagrafici.dataDiNascita+
					'</label><label class="control-label col-sm-4" for="email">Email</label><label class="control-label col-sm-8">'+datiAnagrafici.email+
					'</label><label class="control-label col-sm-4" for="nomeUtente">Nome utente</label><label class="control-label col-sm-8">'+datiAnagrafici.nomeUtente+
					'</label>');	
		}
		
		$("#utenteRegistrato").append(s);
	}
	xhr.send(null);
	
});