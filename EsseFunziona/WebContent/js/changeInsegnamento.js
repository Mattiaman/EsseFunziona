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
	$("#listaProf").change(function(){
		$("#listaCorsiIn").children().remove();
		loadCorsiAll()
		var nomeUtente=$(this).val()
		$.ajax({
			url : 'EditCorsiProf',
			type : 'GET',
			data:{nomeUtente: nomeUtente},
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


function addClickListenerSave(){
	$('#save').on('click',function(){
		if($("#listaProf").val()==-1){
			console.log("eeee no")
			return;
		}
		var list='[';
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
			url: 'EditCorsiProf',
			type: 'POST',
			data: {
				nomeUtente: $("#listaProf").val(),
				lista: list
			},
			success: function(){
				location.reload();
			}
		})
	})
}

function loadProf(){
	
	var xhr = new XMLHttpRequest();
	xhr.open('get', "professori", true);
	xhr.onload = function() {
		var jsonStringQuotes = xhr.responseText;
		var professori = JSON.parse(jsonStringQuotes);
		var v = $('<option value=\"-1\">---</option>');
		$("#listaProf").append(v);
		for ( var i in professori) {
			var d = $('<option value=\"'+professori[i].nomeUtente+'\">'+professori[i].nome+' '+professori[i].cognome+'</option>');
			$("#listaProf").append(d);
		}	
	}
	xhr.send(null);
}


$(document).ready(function() {
	loadProf();
	addChangeListener();
	loadCorsiAll();
	addClickListenerSave();
});