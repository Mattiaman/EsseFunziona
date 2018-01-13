function loadCorsiAll(){
	$("#listaCorsi").children().remove();
	$.ajax({
		url : 'corsi',
		type : 'GET',
		success: function(corsi){
			for(var i in corsi){
				var	c = $('<tr>  <th class=\"idCorso\">' + corsi[i].id + '</th> <th class=\"nomeCorso\">'
						+ corsi[i].nome + '</th> <th><button class=\"add\">Aggiungi</button></th>  </tr>');
				$('#listaCorsi').append(c)
			}
			addClickListenerAdd()

		}
	});
}



function addChangeListener(){
	$("#listaCdl").change(function(){
		$("#listaCorsiIn").children().remove();
		loadCorsiAll()
		var id=$(this).val()
		$.ajax({
			url : 'EditCdl',
			type : 'GET',
			data:{id: id},
			success: function(corsi){
				if(corsi[0]!=null){
					for(var i in corsi){
						var	c = $('<tr>  <th class=\"idCorso\">' + corsi[i].id + '</th> <th class=\"nomeCorso\">'
								+ corsi[i].nome + '</th> <th><button class=\"remove\">Rimuovi</button></th>  </tr>');
						$('#listaCorsiIn').append(c)
						$('#listaCorsi tr').each(function(){
							if($(this).find('.idCorso').text()==corsi[i].id)
								$(this).find('.idCorso').parent().remove();
						})
					}
				}
				addClickListenerRem()
			}
		});
	})
}

function addClickListenerRem(){
	$('.remove').on('click', function(){
		var id=$(this).parent().parent().find(".idCorso").text();
		var rem=$(this).parent().parent()
		var but=rem.find('.remove')
		but.removeClass("remove")
		but.addClass("add")
		but.text("Aggiungi")
		$("#listaCorsi").append(rem)
		addClickListenerAdd()
	})
	
}
function addClickListenerAdd(){
	$('.add').on('click', function(){
		var id=$(this).parent().parent().find(".idCorso").text();
		var add=$(this).parent().parent()
		var but=add.find('.add')
		but.removeClass('add')
		but.addClass('remove')
		but.text("Rimuovi")
		$('#listaCorsiIn').append(add)
		addClickListenerRem();
	})
	
}

function addClickListenerShow(){
	$('#changeName').on('click',function(){
		console.log('ciao')
		$('#setNewName').show()
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
