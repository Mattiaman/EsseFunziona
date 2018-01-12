
function caricaProfessori(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"professori",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var professori=JSON.parse(jsonStringQuotes);
		var v = $('<option value=""></option>');
		$("#opzioniProfessori").append(v);
		for(var i in professori){
			var d = $('<option value=\"'+professori[i].nomeUtente+'\">'+professori[i].cognome+' '+professori[i].nome+'</option>');
			$("#opzioniProfessori").append(d);
		}
	};
	xhr.send(null)
}



$(document).ready(function() {
	caricaProfessori();	
});