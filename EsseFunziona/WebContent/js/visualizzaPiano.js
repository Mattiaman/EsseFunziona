function addChangeListener(){
	$("#listaStudenti").change(function(){
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


function addClickListenerSave(){
	$('#save').on('click',function(){
		if($("#listaCdl").val()==-1){
			console.log("eeee no")
			return;
		}
		var list='[';
		var hidden=$("#newName").val()
		var first=true;
		$('#listaCorsiIn tr').each(function(){
			var id=$(this).find('.idCorso').text()
			if(first==true){
				list+=''+id+''
				first=false;
			}
			else
				list+=','+id+''
		})
		list+=']'
		console.log(list);
		$.ajax({
			url: 'EditCdl',
			type: 'POST',
			data: {
				idCdl: $("#listaCdl").val(),
				nuovoNome: hidden,
				lista: list
			},
			success: function(){
				location.reload();
			}
		})
	})
}

$(document).ready(function() {
	addChangeListener()
	loadCorsiAll();
	addClickListenerShow()
	addClickListenerSave()
});
