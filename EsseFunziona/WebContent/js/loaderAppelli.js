
function caricaAppelli(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"appelli",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var appelli=JSON.parse(jsonStringQuotes);
		for(var i in appelli){
			var c = $('<tr>  <th>'+appelli[i].id+'</th> <th>'+appelli[i].data+'</th> <th>'+appelli[i].professore.nome+'</th> <th>'+appelli[i].corso.nome+'</th> <th>'+appelli[i].nStudentiIscritti+'</th> </tr>');
			$("#listaAppelli").append(c);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaAppelli();	
});