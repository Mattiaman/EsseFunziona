$(document).ready(function() {
	var xhr= new XMLHttpRequest();
	xhr.open('get',"professoreData",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var professoreData=JSON.parse(jsonStringQuotes);
		var listRicev=professoreData.studentiRicevimento;
		
		for(var i in listRicev){
			var s = $('<option value=\"'+listRicev[i].matricola+'\">'+listRicev[i].nome+' '+listRicev[i].cognome+'</option>');
			$("#opzioniRicevimenti").append(s);
		}
		
	}
	xhr.send(null);
	
});