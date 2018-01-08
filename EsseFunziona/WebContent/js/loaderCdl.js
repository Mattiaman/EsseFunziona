
function caricaCdl(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"cdl",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var cdl=JSON.parse(jsonStringQuotes);
		for(var i in cdl){
			console.log(cdl[i]);
			var c = $('<tr>  <th>'+cdl[i].id+'</th> <th>'+cdl[i].nome+'</th>  </tr>');
			$("#listaCdl").append(c);
		}
	};
	xhr.send(null)
}

$(document).ready(function() {
	caricaCdl();	
});