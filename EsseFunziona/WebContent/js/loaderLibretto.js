$(document).ready(function() {
	var xhr = new XMLHttpRequest();
	xhr.open('get', "esami", true);
	xhr.onload = function() {

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var esami = JSON.parse(jsonStringQuotes);
			for ( var i in esiti) {
				var c;
				if (esami[i].matricola == datiAnagrafici.matricola){
					c = $('<tr> <th id="idEsami">' + esami[i].id + '</th> <th>' + esami[i].corso.nome + '</th> <th>' + esami[i].data + '</th> <th>'+ esami[i].voto + '</th> </tr>');
					$("#listaEsami").append(c);
				}
			}
		}
		xhrA.send(null);
	}
	xhr.send(null)
});