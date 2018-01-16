
$(document).ready(function() {
		$("#listaCorsi").append($('<option value=\"-1\">---</option>'))
		var xhr = new XMLHttpRequest();
		xhr.open('get', 'datiAnagrafici');
		xhr.onload = function() {
			var jsonStringQuotes = xhr.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotes);
			$.ajax({
				url : 'EditCorsiProf',
				type : 'GET',
				data:{nomeUtente: datiAnagrafici.nomeUtente},
				success: function(corsi){
					if(corsi[0]!=null){
						for(var i in corsi){
							var	c = $('<option value=\"'+corsi[i].id+'\">'+corsi[i].nome+'</option>');
							$('#listaCorsi').append(c);
						}
					}
				}
			});
		}
		xhr.send(null);
});

