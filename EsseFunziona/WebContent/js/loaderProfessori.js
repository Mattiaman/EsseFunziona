
function caricaProfessori(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"professori",true);
	xhr.onload=function(){
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA)
			var jsonStringQuotes = xhr.responseText;
			var professori=JSON.parse(jsonStringQuotes);
			if (datiAnagrafici.tipo == "admin") {
				$('thead').find('tr').append('<th>Elimina</th>')
			}
			for(var i in professori){
				console.log(professori[i]);
				var p;
				if(datiAnagrafici.tipo == "professore"){
					if(professori[i].nomeUtente != datiAnagrafici.nomeUtente)
						p = $('<tr>  <th>'+professori[i].nomeUtente+'</th> <th>'+professori[i].nome+'</th> <th>'+professori[i].cognome+'</th> <th>'+professori[i].dataDiNascita+
								'</th> <th>'+professori[i].email+'</th>  <th class=\"info\"><a href=\"professori?nomeUtente='+professori[i].nomeUtente+'\">content</a></th>   </tr>');
				}
				else if(datiAnagrafici.tipo == "studente"){
						p = $('<tr>  <th>'+professori[i].nomeUtente+'</th> <th>'+professori[i].nome+'</th> <th>'+professori[i].cognome+'</th> <th>'+professori[i].dataDiNascita+
								'</th> <th>'+professori[i].email+'</th>  <th class=\"info\"><a href=\"professori?nomeUtente='+professori[i].nomeUtente+'\">content</a></th>   </tr>');
				}
				else if(datiAnagrafici.tipo == "admin"){
					p = $('<tr>  <th id=\"nomeUtenteProfessore\">'+professori[i].nomeUtente+'</th> <th>'+professori[i].nome+'</th> <th>'+professori[i].cognome+'</th> <th>'+professori[i].dataDiNascita+
							'</th> <th>'+professori[i].email+'</th> <th class=\"info\"><a href=\"professori?nomeUtente='+professori[i].nomeUtente+'\">content</a></th>   <th><button id='+ professori[i].nomeUtente + '>Elimina</button></th>  </tr>' );
				}
				$("#listaProfessori").append(p);
			}
			deleteProfessore();
		}
		xhrA.send(null);
	};
	xhr.send(null);
}


function deleteProfessore() {
	$('button').on('click', function() {
		var nomeUtente = $(this).parent().parent().find('#nomeUtenteProfessore').text();
		if (confirm("Sei sicuro di voler eliminare il professore "+nomeUtente)) {
			console.log(nomeUtente);
			$.ajax({
				url : 'eliminaProf',
				data : {
					id : nomeUtente
				},// $(this).parent().parent().find('#idTassa').serialize(),
				type : 'POST'
			});
			$(this).parent().parent().remove();
		}
	});
}


$(document).ready(function() {
	caricaProfessori();	
});