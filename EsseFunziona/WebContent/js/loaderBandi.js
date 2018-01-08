function caricaBandi(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"documentiCorsi",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var bandi=JSON.parse(jsonStringQuotes);
		for(var i in bandi){
			var p = $('<tr>  <th>'+bandi[i].id+'</th> <th>'+bandi[i].contenuto+'</th>  <th>'+bandi[i].professore+'</th> </tr>');
			$("#listaDocumenti").append(p);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaBandi();	
});