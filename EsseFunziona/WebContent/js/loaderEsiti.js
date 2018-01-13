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
			for ( var i in esiti) {
				var c;
				if (esiti[i].matricola == datiAnagrafici.matricola){
					c = $('<tr> <th id="idEsito">' + esiti[i].id + '</th> <th>' + esiti[i].corso.nome + '</th> <th>' + esiti[i].data + '</th><th>'+ esiti[i].voto + '</th> <th><button id=' + esiti[i].id+ 
							'>Accetta</button></th>' + '</th> <th><button id=' + esiti[i].id+ '>Rifiuta</button></th> </tr>');
					$("#listaEsiti").append(c);
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
	$('button').on('click', function() {
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
	$('button').on('click', function() {
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