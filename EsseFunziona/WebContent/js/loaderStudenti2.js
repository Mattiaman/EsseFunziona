$(document).ready(function() {
	
	var xhr = new XMLHttpRequest();
	xhr.open('get', "professori", true);
	xhr.onload = function() {

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var professori = JSON.parse(jsonStringQuotes);
			var v = $('<option value=""></option>');
			$("#opzioniRicevimenti").append(v);
			
			for ( var i in professori) {
				console.log(professori[i].studentiRicevimento);
				if(professori[i].nomeUtente == datiAnagrafici.nomeUtente){
					for( var j in professori[i].studentiRicevimento){
						var d = $('<option value=\"'+professori[i].studentiRicevimento[j].matricola+'\">'+professori[i].studentiRicevimento[j].nome+' '+professori[i].studentiRicevimento[j].cognome+'</option>');
						$("#opzioniRicevimenti").append(d);
					
					}
				}
			}	
		}
		xhrA.send(null);
	}
	xhr.send(null);
});
