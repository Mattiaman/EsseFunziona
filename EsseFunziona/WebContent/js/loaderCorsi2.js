function caricaCorsi() {
	var xhr = new XMLHttpRequest();
	xhr.open('get', "corsi", true);
	xhr.onload = function() {

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var corsi = JSON.parse(jsonStringQuotes);
			var v = $('<option value=""></option>');
			$("#listaCorsi").append(v);
			for ( var i in corsi) {
				var c;
				var c = $('<option value=\"'+corsi[i].id+'\">'+corsi[i].nome+'</option>');
				$("#listaCorsi").append(c);
			}
		};
		xhrA.send(null);
	}
	xhr.send(null)
}

$(document).ready(function() {
	caricaCorsi();
});

