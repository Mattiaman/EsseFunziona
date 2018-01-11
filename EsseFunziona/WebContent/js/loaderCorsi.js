function caricaProfessori() {
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
			if (datiAnagrafici.tipo == "admin") {
				$('thead').find('tr').append('<th>Elimina</th>')
				console.log('ok')
			}
			console.log(datiAnagrafici.tipo)
			for ( var i in corsi) {
				var c;
				if (datiAnagrafici.tipo != "admin")
					c = $('<tr>  <th>' + corsi[i].id + '</th> <th>'
							+ corsi[i].nome + '</th>  </tr>');
				else
					c = $('<tr>  <th id=\"idCorso\">' + corsi[i].id + '</th> <th>'
							+ corsi[i].nome + '</th> <th><button id='
							+ corsi[i].id + '>Elimina</button></th>  </tr>');

				$("#listaCorsi").append(c);
			}
			deleteCorso();
		};
		xhrA.send(null);
	}
	xhr.send(null)
}

function deleteCorso() {
	$('button').on('click', function() {
		var id = $(this).parent().parent().find('#idCorso').text();
		console.log(id);
		$.ajax({
			url : 'eliminaCorso',
			data : {
				id : id
			},// $(this).parent().parent().find('#idTassa').serialize(),
			type : 'POST'
		});
		$(this).parent().parent().remove();
	});
}

$(document).ready(function() {
	caricaProfessori();
});

