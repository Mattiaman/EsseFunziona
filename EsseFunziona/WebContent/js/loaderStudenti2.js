$(document).ready(function() {
		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var v = $('<option value=""></option>');
			$("#opzioniRicevimenti").append(v);
			console.log( datiAnagrafici.nStudentiRicevimento);
			for ( var i in datiAnagrafici.studentiRicevimento) {
				var d = $('<option value=\"'+datiAnagrafici.studentiRicevimento[i].matricola+'\">'+datiAnagrafici.studentiRicevimento[i].nome+' '+datiAnagrafici.studentiRicevimento[i].cognome+'</option>');
					$("#opzioniRicevimenti").append(d);
			}
				
		}
		xhrA.send(null);

});
