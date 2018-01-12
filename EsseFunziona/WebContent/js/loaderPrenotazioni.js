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
			if (datiAnagrafici.tipo == "studente")
				$('thead').find('tr').append('<th>Elimina</th>')
			for ( var i in appelli) {
				console.log(appelli)
				for( var j in appelli[i].studentiIscritti){
					var c;
					if (appelli[i].studentiIscritti[j].matricola == datiAnagrafici.matricola){
						c = $('<tr> <th id="idAppello">' + appelli[i].id + '</th> <th>' + appelli[i].corso.nome + '</th> <th>' + appelli[i].data + '</th> <th><button id=' + appelli[i].id
							+ '>Elimina</button></th> </tr>');
		                $("#listaPrenotazioni").append(c);
					}
				}
			}
			deletePrenotazione();
		}
		xhrA.send(null);
	}
	xhr.send(null)
});


function deletePrenotazione() {
	$('button').on('click', function() {
		var id = $(this).parent().parent().find('#idAppello').text();
		$.ajax({
			url : 'eliminaPrenotazione',
			data : {
				idAppello : id
			},
			type : 'POST'
		});
		$(this).parent().parent().remove();
	});
}