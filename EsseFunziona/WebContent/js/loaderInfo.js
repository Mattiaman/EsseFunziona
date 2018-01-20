function caricaPDS(matricola){
	
	$.ajax({
		url : 'EditPds',
		type : 'GET',
		data:{matricola: matricola},
		success: function(corsi){
			console.log(corsi)
			if(corsi[0]!=null){
				for(var i in corsi){
					var	c = $('<tr>  <th>' + corsi[i].id + '</th> <th>'+ corsi[i].nome + '</th></tr>');
					$('#listaCorsi').append(c)
				}
			}
		}
	});
	
}

function caricaCorsiProf(){
		var nomeUtente = $('#nm').text();
		$.ajax({
			url : 'EditCorsiProf',
			type : 'GET',
			data:{nomeUtente: nomeUtente},
			success: function(corsi){
				if(corsi[0]!=null){
					for(var i in corsi){
						var	c = $('<tr> <th>'+corsi[i].id+'</th> <th>'+corsi[i].nome+'</th> </tr>');
						$('#listaCorsi').append(c);
					}
				}
			}
		});	
}

function caricaCorsiCDL(id){
	
	$.ajax({
		url : 'EditCdl',
		type : 'GET',
		data:{id: id},
		success: function(corsi){
			if(corsi[0]!=null){
				for(var i in corsi){
					var	c = $('<tr> <th>'+corsi[i].id+'</th> <th>'+corsi[i].nome+'</th> </tr>');
					$('#listaCorsi').append(c);
				}
			}
		}
	});	
	
}