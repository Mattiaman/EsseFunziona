
function caricaTasse(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"tasse",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var tasse=JSON.parse(jsonStringQuotes);
		for(var i in tasse){
			//console.log(tasse[i]);
			var c = $('<tr>  <th>'+tasse[i].id+'</th> <th>'+tasse[i].importo+'</th> <th>'+tasse[i].nome+'</th> <th>'+tasse[i].descrizione+'</th> <th><button id='+tasse[i].id+'>Elimina</button></th></tr>');
			$("#listaTasse").append(c);
			$("#"+tasse[i].id).on('click',function(){
				
			});
			
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaTasse();	
});