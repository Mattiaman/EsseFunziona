
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		var studenti = datiAnagrafici.studentiRicevimento;
		for(var i in studenti){
			var p = $('<tr> <th>'+studenti[i].matricola+'</th> <th>'+studenti[i].nome+'</th> <th>'+studenti[i].cognome+'</th> </tr>');
			$("#listaStudenti").append(p);
			var d = $('<option value=\"'+studenti[i].matricola+'\">'+studenti[i].nome+' '+studenti[i].cognome+'</option>');
			$("#opzioniRicevimenti").append(d);
		}
	};
	xhr.send(null)
}



$(document).ready(function() {
	caricaStudenti();	
});