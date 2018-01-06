
function caricaStudenti(){
	var xhr= new XMLHttpRequest();
	xhr.open('get',"studenti",true);
	xhr.onload=function(){
		var studenti=JSON.parse(xhr.responseText);
		console.log(studenti);
	};
	xhr.send(null)
}

window.onload=function(){
	caricaStudenti();
};