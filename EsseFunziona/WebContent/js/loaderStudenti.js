
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var studenti=jsonStringQuotes;
		console.log(studenti);
	};
	xhr.send(null)
}

window.onload=function(){
	caricaStudenti();
};