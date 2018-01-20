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
			$.ajax({
				url : 'EditPds',
				type : 'GET',
				data:{matricola: datiAnagrafici.matricola},
				success: function(corsi){
					console.log(corsi)
					if(corsi[0]!=null){
						for(var i in corsi){
							var	c = $('<tr>  <th>' + corsi[i].id + '</th> <th>'+ corsi[i].nome + '</th></tr>');
							$('#listaCorsi').append(c)
						}
					}
				}
			});
		}
		else if(datiAnagrafici.tipo == "professore"){
			s = $('<label class="control-label col-sm-4" for="nome">Nome</label><label class="control-label col-sm-8">'+datiAnagrafici.nome+
					'</label><label class="control-label col-sm-4" for="cognome">Cognome</label><label class="control-label col-sm-8">'+datiAnagrafici.cognome+
					'</label><label class="control-label col-sm-4" for="datadiNascita">Data Di Nascita</label><label class="control-label col-sm-8">'+datiAnagrafici.dataDiNascita+
					'</label><label class="control-label col-sm-4" for="email">Email</label><label class="control-label col-sm-8">'+datiAnagrafici.email+
					'</label><label class="control-label col-sm-4" for="nomeUtente">Nome utente</label><label class="control-label col-sm-8">'+datiAnagrafici.nomeUtente+
					'</label>');
			$.ajax({
				url : 'EditCorsiProf',
				type : 'GET',
				data:{nomeUtente: datiAnagrafici.nomeUtente},
				success: function(corsi){
					if(corsi[0]!=null){
						for(var i in corsi){
							var	c = $('<tr> <th>'+corsi[i].id+'</th> <th>'+corsi[i].nome+'</th> </tr>');
							$('#listaCorsi').append(c);
						}
					}
				}
			});	
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