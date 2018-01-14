function caricaStud(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studentiRichiesta",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var stud=JSON.parse(jsonStringQuotes);
		$("#listaStudenti").append($('<option value=\"-1\">---</option>'))
		for(var i in stud){
			var c = $('<option value=\"'+stud[i].matricola+'\">'+stud[i].matricola+' '+stud[i].nome+' '+stud[i].cognome+'</option>');
			$("#listaStudenti").append(c);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaStud();	
});