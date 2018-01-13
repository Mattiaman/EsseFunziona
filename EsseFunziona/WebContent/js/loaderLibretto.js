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
			for ( var i in esiti) {
				var c;
				if (esiti[i].matricola == datiAnagrafici.matricola){
					c = $('<tr> <th id="idEsito">' + esiti[i].id + '</th> <th>' + esiti[i].corso.nome + '</th> <th>' + esiti[i].data + '</th> <th>'+ esiti[i].voto + '</th> </tr>');
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