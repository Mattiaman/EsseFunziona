
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var studenti=JSON.parse(jsonStringQuotes);
		for(var i in studenti){
			var s = $('<tr>  <th>'+studenti[i].matricola+'</th> <th>'+studenti[i].nome+'</th> <th>'+studenti[i].cognome+'</th> <th>'+studenti[i].dataDiNascita+'</th> <th>'+studenti[i].email+'</th>  </tr>');
			$("#listaStudenti").append(s);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaStudenti();	
});