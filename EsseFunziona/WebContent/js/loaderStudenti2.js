
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		var v = $('<option value=""></option>');
		$("#opzioniRicevimenti").append(v);
		for(var i in datiAnagrafici.studentiRicevimento){
			var p = $('<tr> <th>'+datiAnagrafici.studentiRicevimento[i].matricola+'</th> <th>'+datiAnagrafici.studentiRicevimento[i].nome+'</th> <th>'+studenti[i].cognome+'</th> </tr>');
			$("#listaStudenti").append(p);
			var d = $('<option value=\"'+datiAnagrafici.studentiRicevimento[i].matricola+'\">'+datiAnagrafici.studentiRicevimento[i].nome+' '+datiAnagrafici.studentiRicevimento[i].cognome+'</option>');
			$("#opzioniRicevimenti").append(d);
		}
	};
	xhr.send(null)
}



$(document).ready(function() {
	caricaStudenti();	
});