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
	console.log(content);
	$(content).remove();
	var city= "#S"+id_post;
	var initialLatLong=null;
	var location= $(city).text();
	console.log(location);
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
		let text = "<p><b>" + location + '</b><label class="label">' 
				+ main + ':</label><span>' + description +'</span>'
				+ '<label class="label">Humidity:</label><span>' + humidity + '</span>' 
				+ '<label class="label">Min Temp:</label><span>' + tempMin +' '+grades +'</span>' 
				+ '<label class="label">Max Temp:</label><span>' + tempMax +' '+grades +'</span>'
				+ '<label class="label">Pressure:</label><span>' + pressure+'</span></p>';
		var content= "#CON"+id_post;
		$(content).append('<div id="DC'+ id_post+'"><a href="#menu" id="BC'+ id_post+'">X</a>'
		+'<div id="map"></div><div id="weather"></div></div>');
		$("#weather").append('<img id="forecastImg" alt=""/><br/>'+text);
		$('img#forecastImg').attr("src","http://openweathermap.org/img/w/"+ icon + ".png")
							.css({"width":"100px",
							"height":"100px",
							"padding":"0",
							"background-color":"white",
							"margin":"0 48px 0 48px",
							"border":"none",
							"border-radius":"50%"});
		var initialLatLong = new google.maps.LatLng(data.coord.lat,data.coord.lon);
		
		var myOptions = {
				zoom: 12,
				center: initialLatLong,
				mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map"), myOptions);

		var marker = new google.maps.Marker({
			position: initialLatLong,
			map: map,
			title: location
		});
		
		$('#BC'+id_post).click(fmaps);
	}).fail(function(){
		console.log("Couldn't find data for location: "+location )
	});


//	var content= "#DC"+id_post;
//	$(content).remove();
//	var city= "#S"+id_post;
//	var map = $(city).text();
//	var content= "#CON"+id_post;
//	$(content).append('<iframe  id=DC'+ id_post+'>'+'</iframe>');
//	$('#BC'+id_post).click(fmaps);

}

function fmaps(event){

	var val= $(this).attr('id');
	var id_post= val.substring(2, val.length);
	var content= "#DC"+id_post;
	$(content).remove();

}
