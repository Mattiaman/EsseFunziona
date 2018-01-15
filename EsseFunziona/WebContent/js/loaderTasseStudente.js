
function caricaTasse(){
	$.ajax({
		url: 'tasseStudente',
		type: 'GET',
		success: function(tasse){
			console.log(1111)
			for (var i in tasse) {
				var c=$('<tr>  <th id="idTassa">'+tasse[i].id+'</th> <th>'+tasse[i].importo+'</th> <th>'+tasse[i].nome+'</th> <th>'+tasse[i].descrizione+'</th> <th>'+tasse[i].stato+'</tr>');
				$("#listaTasse").append(c);
			}
		}
	});
}


$(document).ready(function() {
	caricaTasse();	
});