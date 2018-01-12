function caricaCorsi(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		var v = $('<option value=""></option>');
		$("#listaCorsi").append(v);
		if(datiAnagrafici.tipo == "studente"){ 
			for(var i in datiAnagrafici.corsoDiLaurea.corsi){
				var c = $('<option value=\"'+datiAnagrafici.corsoDiLaurea.corsi[i].id+'\">'+datiAnagrafici.corsoDiLaurea.corsi[i].nome+'</option>');
				$("#listaCorsi").append(c);
			}
		}
	};
	xhr.send(null)
}

function caricaAppelli(crs){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"appelli",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var appelli=JSON.parse(jsonStringQuotes);
		$("#listaAppelli").empty();
		var v = $('<option value=""></option>');
		$("#listaAppelli").append(v);
		for(var i in appelli){
			if(appelli[i].corso.id == crs.value){
				var c = $('<option value=\"'+appelli[i].id+'\">'+appelli[i].data+'</option>');
				$("#listaAppelli").append(c);
			}
		}
	};
	xhr.send(null)
}


$(document).ready(function() {
	caricaCorsi();
});
