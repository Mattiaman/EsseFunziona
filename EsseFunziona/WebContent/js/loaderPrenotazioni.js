$(document).ready(function() {
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
			for ( var i in appelli) {
				for( var j in appelli[i].studentiIscritti){
					var c;
					if (appelli[i].studentiIscritti[j].matricola == datiAnagrafici.matricola){
						c = $('<tr> <th>' + appelli[i].corso.nome + '</th> <th>' + appelli[i].data + '</th> </tr>');
		                $("#listaPrenotazioni").append(c);
					}
				}
			}
		};
		xhrA.send(null);
	}
	xhr.send(null)
});
