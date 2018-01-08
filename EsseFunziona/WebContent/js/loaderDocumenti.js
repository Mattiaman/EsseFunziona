function caricaDocumetni(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"documenti",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var documenti=JSON.parse(jsonStringQuotes);
		for(var i in documenti){
			var p = $('<tr>  <th>'+documenti[i].id+'</th> <th>'+documenti[i].contenuto+'</th>  <th>'+documenti[i].professore+'</th> </tr>');
			$("#listaDocumenti").append(p);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaDocumetni();	
});