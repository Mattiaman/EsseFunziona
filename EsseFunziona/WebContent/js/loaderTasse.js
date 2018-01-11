
function caricaTasse(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"tasse",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var tasse=JSON.parse(jsonStringQuotes);
		for(var i in tasse){
			//console.log(tasse[i]);
			var c = $('<tr>  <th id="idTassa">'+tasse[i].id+'</th> <th>'+tasse[i].importo+'</th> <th>'+tasse[i].nome+'</th> <th>'+tasse[i].descrizione+'</th> <th><button id='+tasse[i].id+'>Elimina</button></th></tr>');
			$("#listaTasse").append(c);
		}
		deleteTassa();
	};
	xhr.send(null)
}

function deleteTassa(){
	$('button').on('click',function(){
		var id=$(this).parent().parent().find('#idTassa').text();
		console.log(id);
		$.ajax({
			url: 'eliminaTassa',
			data: {id: id},//$(this).parent().parent().find('#idTassa').serialize(),
			type: 'POST'
		});
		$(this).parent().parent().remove();
	});
}

$(document).ready(function() {
	caricaTasse();	
	deleteTassa();
});