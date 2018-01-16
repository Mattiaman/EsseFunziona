function caricaDocumenti(){

	$.ajax({

		url:"documentiCorsi",
		
		type:"GET",
		
		success: function(documenti){
			for(var i in documenti){
				var p = $('<tr>  <th class=\"id\">'+documenti[i].id+'</th> <th class=\"download\"><a href=\"downloader?id='+documenti[i].id+'&tipo=materiale\">content</a></th>  <th>'+documenti[i].professore.nome+' '+documenti[i].professore.cognome+'</th> </tr>');
				$("#listaDocumenti").append(p);
			}
			//downloadListener()
		}
	})
}

$(document).ready(function() {
	caricaDocumenti();	
});