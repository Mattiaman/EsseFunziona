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
			for ( var i in esami) {
				var c;
				for ( var j in esami[i].studentiIscritti){
					if (esami[i].studentiIscritti[j].matricola == datiAnagrafici.matricola){
						if (esami[i].studentiIscritti[j].matricola == datiAnagrafici.matricola){
							c = $('<tr> <th>' + esami[i].corso.nome + '</th> <th>' + esami[i].data + '</th><th>'+ esami[i].studentiIscritti[j].voto + '</th> </tr>');
							$("#listaSuperati").append(c);
						}
					}
				}
						
			}	
		}
		xhrA.send(null);
	}
	xhr.send(null)
});