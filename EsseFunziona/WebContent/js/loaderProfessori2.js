$(document).ready(function() {

	var xhr= new XMLHttpRequest();
	xhr.open('get',"professori",true);
	xhr.onload=function(){
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var professori=JSON.parse(jsonStringQuotes);
			var v = $('<option value=\"-1\">---</option>');
			$("#opzioniProfessori").append(v);
			var cont=0;
			for(var h in professori){
				var d = $('<option value=\"'+professori[h].nomeUtente+'\">'+professori[h].cognome+' '+professori[h].nome+'</option>');
				$("#opzioniProfessori").append(d);
			}
			for(var i in professori){
				for( var j in professori[i].studentiRicevimento){
					console.log(professori[i].studentiRicevimento);
					if (professori[i].studentiRicevimento[j] != null) {
						if(professori[i].studentiRicevimento[j].matricola == datiAnagrafici.matricola){
							var a = $('<tr> <th value=\"'+professori[i].nomeUtente+'\">'+professori[i].cognome+' '+professori[i].nome+'</th> <th id="data'+cont+'"></th> </tr>');
							$("#listaRicevimenti").append(a);
							trovaRicevimento(professori[i].nomeUtente,cont);
							cont++;					
					}
					}
				}
			}
		}
		xhrA.send(null);
	}
	xhr.send(null)
});

function trovaRicevimento(nM,cont) {
	
	$.ajax({
		url : 'trovaRicevimento',
		data : {
			nomeUtente : nM
		},
		type : 'get',
		success: function(data){
			$('#data'+cont+'').text(data);
		}
	});
	
}