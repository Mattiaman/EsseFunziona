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
	addModifica();
});



function addModifica(){
	var xhra= new XMLHttpRequest();
	xhra.open('get',"datiAnagrafici",true);
	xhra.onload=function(){
		var jsonStringQuotes = xhra.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		
		b= $('<button id="modifica">Modifica</button>');
		$('#modify').append(b);

		$('#modifica').on('click',function(){
			$('#modify').children().remove();
			s = $('<form class="form-horizontal" method="post" action="datiAnagrafici"><div class="col-sm-12" class="form-group"><div class="col-sm-3"><label>Nome:</label></div><div class="col-sm-5"><input name="nome" type="text"class="form-control" /></div></div>'+
					'<div class="col-sm-12" class="form-group"><div class="col-sm-3"><label>Cognome:</label></div><div class="col-sm-5"><input name="cognome" type="text"class="form-control" /></div></div>'+
					'<div class="col-sm-12" class="form-group"><div class="col-sm-3"><label>Data di Nascita:</label></div><div class="col-sm-5"><input name="dataNascita" type="date" class="form-control" /></div></div>'+
					'<div class="col-sm-12" class="form-group"><div class="col-sm-3"><label>Email:</label></div><div class="col-sm-5"><input name="email" type="email"class="form-control" /></div></div>'+
					'<div class="col-sm-12" class="form-group"><input name="inviaDati" type="submit" value="Invia Dati"  class="btn btn-warning"/></div></form>');	
			$('#modify').append(s);			
		})
	}
	xhra.send(null);
}
