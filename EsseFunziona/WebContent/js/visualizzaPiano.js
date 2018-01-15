function addChangeListener(){
	$("#listaStudenti").change(function(){
		if($("#listaStudenti").val()==-1){
			console.log("eeee no")
			return;
		}
		$("#listaCorsi").children().remove();
		var id=$(this).val()
		$.ajax({
			url : 'showPiano',
			type : 'GET',
			data:{id: id},
			success: function(corsi){
				if(corsi[0]!=null){
					for(var i in corsi){
						var	c = $('<tr>  <th class=\"idCorso\">' + corsi[i].id + '</th> <th class=\"nomeCorso\">'
								+ corsi[i].nome + '</th>  </tr>');
						$('#listaCorsi').append(c)
					}
				}
			}
		});
	})
}


function addClickListenerAccept(){
	$('#accetta').on('click',function(){
		if($("#listaStudenti").val()==-1){
			console.log("eeee no")
			return;
		}

		$.ajax({
			url: 'showPiano',
			type: 'POST',
			data: {
				id: $("#listaStudenti").val(),
				status: "1"
			},
			success: function(){
				location.reload();
			}
		})
	})
}

function addClickListenerRefuse(){
	$('#accetta').on('click',function(){
		if($("#listaStudenti").val()==-1){
			console.log("eeee no")
			return;
		}

		$.ajax({
			url: 'showPiano',
			type: 'POST',
			data: {
				id: $("#listaStudenti").val(),
				status: "2"
			},
			success: function(){
				location.reload();
			}
		})
	})
}


$(document).ready(function() {
	addChangeListener()
	addClickListenerAccept()
});
