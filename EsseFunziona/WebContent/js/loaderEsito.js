function caricaCorsi(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"corsi",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var corsi=JSON.parse(jsonStringQuotes);
		for(var i in corsi){
			var c = $('<option value=\"'+corsi[i].id+'\">'+corsi[i].nome+'</option>');
			$("#listaCorsi").append(c);
		}
	};
	xhr.send(null)
}

function caricaAppelli(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"appelli",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var appelli=JSON.parse(jsonStringQuotes);
		for(var i in appelli){
			var c = $('<option value=\"'+appelli[i].id+'\">'+appelli[i].data+'</option>');
			$("#listaAppelli").append(c);
		}
	};
	xhr.send(null)
}

function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var studenti=JSON.parse(jsonStringQuotes);
		for(var i in studenti){
			var s = $('<option value=\"'+studenti[i].id+'\">'+studenti[i].nome+' '+studenti[i].cognome+'</option>');
			$("#listaStudenti").append(s);
		}
	};
	xhr.send(null)
}


$(document).ready(function() {
	caricaAppelli();	
	caricaStudenti();
	caricaCorsi();
});

