function caricaPDS(){
	var matricola = $('#m').text();
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

function caricaCorsiCDL(){
	var id = $('#id').text();
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

function initMap() {
	var nomeUtente = $('#nm').text();
	$.ajax({
		url : 'professori',
		type : 'GET',
		success: function(prof){
			var p;
			for(var i in prof){

				if(prof[i].nomeUtente==nomeUtente){
					p=prof[i];

					break;
				}
			}
			console.log(p)
				var stud={lat: p.studio.latitudine, lng: p.studio.longitudine}
				var map = new google.maps.Map(document.getElementById('map'), {
				    zoom: 4,
				    center: stud
				});
				var marker = new google.maps.Marker({
				      position: stud,
				      map: map
				});

		}
	});	
 }