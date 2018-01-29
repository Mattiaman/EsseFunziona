
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA)
			var jsonStringQuotes = xhr.responseText;
			var studenti=JSON.parse(jsonStringQuotes);
			if (datiAnagrafici.tipo == "admin") {
				$('thead').find('tr').append('<th>Elimina</th>')
			}
			for(var i in studenti){
				var s;
				if (datiAnagrafici.tipo != "admin")
					s = $('<tr>  <th>'+studenti[i].matricola+'</th> <th>'+studenti[i].nome+'</th> <th>'+studenti[i].cognome+'</th> <th>'+studenti[i].dataDiNascita+'</th> <th>'+studenti[i].email+'</th>  <th class=\"info\"><a href=\"studenti?matricola='+studenti[i].matricola+'\">content</a></th>  </tr>');
				else
					s = $('<tr>  <th id=\"matricolaStudente\">'+studenti[i].matricola+'</th> <th>'+studenti[i].nome+'</th> <th>'+studenti[i].cognome+'</th> <th>'+studenti[i].dataDiNascita+'</th> <th>'+studenti[i].email+'</th>  <th class=\"info\"><a href=\"studenti?matricola='+studenti[i].matricola+'\">content</a></th> <th><button id='+ studenti[i].matricola + '>Elimina</button></th>  </tr>' );
				$("#listaStudenti").append(s);
			}
			deleteStudente();
		}
		xhrA.send(null);
	};
	xhr.send(null);
}


function deleteStudente() {
	$('button').on('click', function() {
		var matricola = $(this).parent().parent().find('#matricolaStudente').text();
		if (confirm("Sei sicuro di voler eliminare lo studente "+matricola)) {
			$.ajax({
				url : 'eliminaStudente',
				data : {
					matricola : matricola
				},// $(this).parent().parent().find('#idTassa').serialize(),
				type : 'POST'
			});
			$(this).parent().parent().remove();
		}
		
	});
}

$(document).ready(function() {
	caricaStudenti();	
});