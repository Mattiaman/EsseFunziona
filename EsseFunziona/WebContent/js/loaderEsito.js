function caricaCorsi(){
	$("#listaCorsi").append($('<option value=\"-1\">---</option>'))
	var xhr = new XMLHttpRequest();
	xhr.open('get', 'datiAnagrafici');
	xhr.onload = function() {
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici = JSON.parse(jsonStringQuotes);
		$.ajax({
			url : 'EditCorsiProf',
			type : 'GET',
			data:{nomeUtente: datiAnagrafici.nomeUtente},
			success: function(corsi){
				if(corsi[0]!=null){
					for(var i in corsi){
						var	c = $('<option value=\"'+corsi[i].id+'\">'+corsi[i].nome+'</option>');
						$('#listaCorsi').append(c);
					}
				}
			}
		});
	}
	xhr.send(null);
}

function caricaAppelli(crs){
	$("#listaStudenti").empty();
	$("#listaAppelli").empty();
	
	var xhr = new XMLHttpRequest();
	xhr.open('get', "appelli", true);
	xhr.onload = function() {
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var appelli = JSON.parse(jsonStringQuotes);
			$("#listaAppelli").empty();
			var v = $('<option value=\"-1\">---</option>');
			$("#listaAppelli").append(v);
			for ( var i in appelli) {
				var c;
				if(appelli[i].corso.id == crs.value){
					if(appelli[i].professore.nomeUtente == datiAnagrafici.nomeUtente)
						c = $('<option value=\"'+appelli[i].id+'\">'+ appelli[i].data + '</option>');
				}	
				$("#listaAppelli").append(c);
			}
		}
		xhrA.send(null)
	};

	xhr.send(null)
}

function caricaStudenti(app){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"appelli",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var appelli=JSON.parse(jsonStringQuotes);
		$("#listaStudenti").empty();
		var v = $('<option value=\"-1\">---</option>');
		$("#listaStudenti").append(v);
		for(var i in appelli){
			if(appelli[i].id == app.value){
				for(var j in appelli[i].studentiIscritti){
					var s = $('<option value=\"'+appelli[i].studentiIscritti[j].matricola+'\">'+appelli[i].studentiIscritti[j].nome+' '+appelli[i].studentiIscritti[j].cognome+'</option>');
					$("#listaStudenti").append(s);
				}
			}
		}
	};
	xhr.send(null)
}


$(document).ready(function() {
	caricaCorsi();
});

