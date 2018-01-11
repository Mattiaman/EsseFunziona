
function caricaProfessori(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"professori",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var professori=JSON.parse(jsonStringQuotes);
		for(var i in professori){
			var p = $('<tr>  <th>'+professori[i].nomeUtente+'</th> <th>'+professori[i].nome+'</th> <th>'+professori[i].cognome+'</th> <th>'+professori[i].dataDiNascita+'</th> <th>'+professori[i].email+'</th>  </tr>');
			$("#listaProfessori").append(p);
			var p = $('<option value=\"'+professori[i].nomeUtente+'\">'+professori[i].cognome+' '+professori[i].nome+'</option>');
			$("#opzioniProfessori").append(p);
		}
	};
	xhr.send(null)
}



$(document).ready(function() {
	caricaProfessori();	
});