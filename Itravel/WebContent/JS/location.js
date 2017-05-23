/**
 * 
 */


$(document).ready(function() {
	$(".fa-location").click(flocation);
});

function flocation(event){
	event.preventDefault();
	var val= $(this).attr('id');
	var id_post= val.substring(1, val.length);
	var content= "#DC"+id_post;
	$(content).remove();
	var city= "#S"+id_post;
	var initialLatLong=null;
	var location= $(city).text();
	$.get("http://api.openweathermap.org/data/2.5/weather",{
		"q":location,
		"APPID": "2cbac0d6282afa096674267c64a8af5c"
	}).done(function(data){
	    location = data.name;
		let weather= data.weather[0];
		let grades = '&#176;K';
		let tempMax = data.main.temp_max;
		let tempMin = data.main.temp_min;
		let humidity=data.main.humidity;
		let icon= weather.icon;
		let main= weather.main;
		let pressure = data.main.pressure;
		let description= weather.description;
		let text = "<h4 class='center'>" + location + '</h4><p><label>' 
				+ main + ': ' + description +'</label>'
				+ '<label>Humidity: ' + humidity + '</label>' 
				+ '<label>Min Temp: ' + tempMin +' '+grades +'</label>' 
				+ '<label>Max Temp: ' + tempMax +' '+grades +'</label>'
				+ '<label>Pressure: ' + pressure+'</label></p>';
		var content= "#CON"+id_post;
		$(content).append('<div id="DC'+ id_post+'">'
		+'<div class="close_div">Close<a href="#menu" id="BC'+ id_post+'">X</a></div><div id="mapContainer"><div id="map"></div>'
		+'<div id="weather"></div></div></div>');
		$("#weather").append('<img id="forecastImg" alt=""/>'+text);
		$('img#forecastImg').attr("src","http://openweathermap.org/img/w/"+ icon + ".png")
							.css({"width":"100px",
							"height":"100px",
							"padding":"0",
							"background-color":"white",
							"margin":"10px 48px 30px 48px",
							"border":"none",
							"border-radius":"50%"});
		var initialLatLong = new google.maps.LatLng(data.coord.lat,data.coord.lon);
		
		var myOptions = {
				zoom: 12,
				center: initialLatLong,
				draggable:false,
				mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map"), myOptions);
		
		var marker = new google.maps.Marker({
			position: initialLatLong,
			map: map,
			draggable:false,
			title: location
		});
		
		$('#BC'+id_post).click(fmaps);
	}).fail(function(){
		console.log("Couldn't find data for location: "+location )
	});

}

function fmaps(event){

	var val= $(this).attr('id');
	var id_post= val.substring(2, val.length);
	var content= "#DC"+id_post;
	$(content).remove();

}
