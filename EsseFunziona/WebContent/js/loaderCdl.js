function caricaCdl() {
	var xhr = new XMLHttpRequest();
	xhr.open('get', "cdl", true);
	xhr.onload = function() {
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var cdl = JSON.parse(jsonStringQuotes);
			$('thead').find('tr').append('<th>Info</th>');
			if (datiAnagrafici.tipo == "admin")
				$('thead').find('tr').append('<th>Elimina</th>');
			for ( var i in cdl) {
				var c;
				if (datiAnagrafici.tipo != "admin")
					c = $('<tr>  <th>' + cdl[i].id + '</th> <th>' + cdl[i].nome
							+ '</th>  <th class=\"info\"><a href=\"cdl?id='+cdl[i].id+'\">content</a></th></tr>');
				else
					c = $('<tr>  <th id="idCdl">' + cdl[i].id + '</th> <th>' + cdl[i].nome+
							'</th> <th class=\"info\"><a href=\"cdl?id='+cdl[i].id+'\">content</a></th>'+
							'<th><button id=' + cdl[i].id+'>Elimina</button></th> </tr>');
				
				$("#listaCdl").append(c);
			}
			deleteCdl()
		}
		xhrA.send(null)
	}
	xhr.send(null)
}

function deleteCdl() {
	$('button').on('click', function() {		
		var id = $(this).parent().parent().find('#idCdl').text();
		if (confirm("Sicuro di voler eliminare il corso di laurea: "+id)) {
			$.ajax({
				url : 'eliminaCdl',
				data : {
					id : id
				},
				type : 'POST',
			});
			$(this).parent().parent().remove();
		}
	});
}

$(document).ready(function() {
	caricaCdl();
});