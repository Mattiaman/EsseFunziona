
function caricaProfessori(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"corsi",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var corsi=JSON.parse(jsonStringQuotes);
		for(var i in corsi){
			var c = $('<tr>  <th>'+corsi[i].id+'</th> <th>'+corsi[i].nome+'</th>  </tr>');
			$("#listaCorsi").append(c);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaProfessori();	
});