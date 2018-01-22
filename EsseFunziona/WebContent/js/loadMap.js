function initMap(){
	var c={lat: 39.358571, lng: 16.226734}
	var map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 15,
	    center: c
	});
	google.maps.event.addListener(map, 'click', function( event ){
		$('#lat').val(event.latLng.lat())
		$('#lng').val(event.latLng.lng())
	})
}
