function caricaCorsi(){	
	var xhr= new XMLHttpRequest();
	xhr.open('get',"datiAnagrafici",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var datiAnagrafici=JSON.parse(jsonStringQuotes);
		$.ajax({
			url : 'EditPds',
			type : 'GET',
			data:{matricola: datiAnagrafici.matricola},
			success: function(corsi){
				var v = $('<option value=\"-1\">---</option>');
				$("#listaCorsi").append(v);
				if(corsi[0]!=null){
					for(var i in corsi){
						var c = $('<option value=\"'+corsi[i].id+'\">'+corsi[i].nome+'</option>');
						$("#listaCorsi").append(c);
					}
				}
			}
		});
	}
	xhr.send(null);
}

function caricaAppelli(crs){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"appelli",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var appelli=JSON.parse(jsonStringQuotes);
		$("#listaAppelli").empty();
		var v = $('<option value=\"-1\">---</option>');
		$("#listaAppelli").append(v);
		for(var i in appelli){
			if(appelli[i].corso.id == crs.value){
				var c = $('<option value=\"'+appelli[i].id+'\">'+appelli[i].data+'</option>');
				$("#listaAppelli").append(c);
			}
		}
	};
	xhr.send(null)
}


$(document).ready(function() {
	caricaCorsi();
});
