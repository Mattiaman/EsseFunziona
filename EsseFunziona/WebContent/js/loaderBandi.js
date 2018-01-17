function caricaBandi(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"bandi",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var bandi=JSON.parse(jsonStringQuotes);
		for(var i in bandi){
			var p = $('<tr>  <th>'+bandi[i].id+'</th> <th id=\''+bandi[i].id+'\'><a href=\"downloader?id='+bandi[i].id+'&tipo=bando\">content</a></th>  <th>'+bandi[i].admin.nome+' '+bandi[i].admin.cognome+'</th> </tr>');
			$("#listaBandi").append(p);
			$('#'+bandi[i].id+'').on('click', function(){
				var xhrFile= new XMLHttpRequest();
				xhrFile.open('get',bandi[i].absolutePath,true)
				xhrFile.send(null);
			});
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaBandi();	
});