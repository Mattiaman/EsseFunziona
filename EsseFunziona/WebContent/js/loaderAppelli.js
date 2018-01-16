
function caricaProfessori() {
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
			if(datiAnagrafici.tipo=="professore")
				$('thead').find('tr').append('<th>Elimina</th>')
			for ( var i in appelli) {
				var c;
				if(datiAnagrafici.tipo!="professore")
					c = $('<tr>  <th>' + appelli[i].id + '</th> <th>'
							+ appelli[i].data + '</th> <th>'
							+ appelli[i].professore.nome + ' '+appelli[i].professore.cognome+ '</th> <th>'
							+ appelli[i].corso.nome + '</th> <th>'
							+ appelli[i].nStudentiIscritti + '</th> </tr>');
				else
					c = $('<tr>  <th id="idAppello">' + appelli[i].id + '</th> <th>'
							+ appelli[i].data + '</th> <th>'
							+ appelli[i].professore.nome + ' '+appelli[i].professore.cognome+ '</th> <th>'
							+ appelli[i].corso.nome + '</th> <th>'
							+ appelli[i].nStudentiIscritti + '</th><th><button id='
							+ appelli[i].id + '>Elimina</button></th></tr>');
					
				$("#listaAppelli").append(c);
			}
			deleteAppello();
		}
		xhrA.send(null)
	};

	xhr.send(null)
}

function deleteAppello() {
	$('button').on('click', function() {
		var id = $(this).parent().parent().find('#idAppello').text();
		console.log(id);
		$.ajax({
			url : 'eliminaAppello',
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