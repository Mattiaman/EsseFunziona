
function caricaTasse(){
	$('#listaStudenti').change(function(){
		$('#listaTasse').children().remove();
		$.ajax({
		url: 'tasseStudenteAdmin',
		type: 'GET',
		data:{
			matricola: $('#listaStudenti').val()
		},
		success: function(tasse){
			console.log(1111)
			for (var i in tasse) {
				var c=$('<tr>  <th class="idTassa">'+tasse[i].id+'</th> <th>'+tasse[i].importo+'</th> <th>'+tasse[i].nome+'</th> <th>'+tasse[i].descrizione+'</th> <th class=\"stato\">'+tasse[i].stato+'</th><th><button class=\"setPagata\">Pagata</button><button class=\"setNonPagata\">Non pagata</button></th></tr>');
				$("#listaTasse").append(c);
			}
			setPagataTrue()
			setPagataFalse()
		}
		});
	})
}

function setPagataTrue(){
	$(".setPagata").on('click',function(){
		var id=$(this).parent().parent().find('.idTassa').text()
		$.ajax({
			url: 'tasseStudenteAdmin',
			type: 'POST',
			data:{
				matricola: $('#listaStudenti').val(),
				stato: "pagata",
				id: id
			},
		});
		$(this).parent().parent().find('.stato').text("Pagata")
	})
}

function setPagataFalse(){
	$(".setNonPagata").on('click',function(){
		var id=$(this).parent().parent().find('.idTassa').text()
		$.ajax({
			url: 'tasseStudenteAdmin',
			type: 'POST',
			data:{
				matricola: $('#listaStudenti').val(),
				stato: "nonPagata",
				id: id
			},
		});
		$(this).parent().parent().find('.stato').text("Non pagata")
	})
}
$(document).ready(function() {
	caricaTasse();	
});