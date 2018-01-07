
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var jsonStringQuotes = xhr.responseText;
		var studenti=JSON.parse(jsonStringQuotes);
		console.log(studenti[1]);
	};
	xhr.send(null)
}

window.onload=function(){
	caricaStudenti();
};