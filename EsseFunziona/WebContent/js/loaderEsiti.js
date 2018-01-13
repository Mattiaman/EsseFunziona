$(document).ready(function() {
	var xhr = new XMLHttpRequest();
	xhr.open('get', "esiti", true);
	xhr.onload = function() {

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var esiti = JSON.parse(jsonStringQuotes);
			if (datiAnagrafici.tipo == "studente"){
				$('thead').find('tr').append('<th>Accetta</th>')
				$('thead').find('tr').append('<th>Rifiuta</th>')
			}
			console.log(esiti)
			console.log(datiAnagrafici)
			for ( var i in esiti) {
				var c;
				for ( var j in esiti[i].studentiIscritti){
					if (esiti[i].studentiIscritti[j].matricola == datiAnagrafici.matricola){
						c = $('<tr> <th id="idEsito">' + esiti[i].id + '</th> <th>' + esiti[i].corso.nome + '</th> <th>' + esiti[i].data + '</th><th>'+ esiti[i].voto + '</th> <th><button id="accetta">Accetta</button></th>' + '</th> <th><button id="rifiuta">Rifiuta</button></th> </tr>');
						$("#listaEsiti").append(c);
					}
				}
			}	
			rifiuta();
			accetta();
		}
		xhrA.send(null);
	}
	xhr.send(null)
});


function rifiuta() {
	$('#rifiuta').on('click', function() {
		var id = $(this).parent().parent().find('#idEsito').text();
		$.ajax({
			url : 'rifiutaEsame',
			data : {
				idEsito : id
			},
			type : 'POST'
		});
		$(this).parent().parent().remove();
	});
}

function accetta() {
	$('#accetta').on('click', function() {
		var id = $(this).parent().parent().find('#idEsito').text();
		$.ajax({
			url : 'accettaEsame',
			data : {
				idEsito : id
			},
			type : 'POST'
		});
		$(this).parent().parent().remove();
	});
}