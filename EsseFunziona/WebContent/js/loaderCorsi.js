function caricaProfessori() {

	var xhr = new XMLHttpRequest();
	xhr.open('get', "corsi", true);
	xhr.onload = function() {

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhr.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var corsi = JSON.parse(jsonStringQuotes);
			if(datiAnagrafici.tipo=="admin"){
				$('thead').find('tr').append('<th>Elimina<th>')
				console.log('ok')
			}
			console.log(datiAnagrafici.tipo)
			for ( var i in corsi) {
				var c;
				if(datiAnagrafici.tipo!="admin")
					c = $('<tr>  <th>' + corsi[i].id + '</th> <th>'
						+ corsi[i].nome + '</th>  </tr>');
				else
					c = $('<tr>  <th>' + corsi[i].id + '</th> <th>'
							+ corsi[i].nome + '</th>  </tr>');
					
				$("#listaCorsi").append(c);
			}
		};
		xhrA.send(null);
	}
	xhr.send(null)
}

$(document).ready(function() {
	caricaProfessori();
});