"use strict";
var latitude=0;
var longitude=0;

function localization() {
    if (navigator.geolocation) { 
        navigator.geolocation.getCurrentPosition(coordinates, errors);
    }else{
        alert("sorry! your browser doesn't allow to get your location!");
    }
}

function coordinates(position) {
    latitude = position.coords.latitude;
    longitude = position.coords.longitude;
    getforecast(latitude,longitude);
}

function errors(err) {
    if (err.code == 0) {
      alert("sorry! something went wrong");
    }
    if (err.code == 1) {
      alert("sorry! you haven't shared your location on the browser.");
    }
    if (err.code == 2) {
      alert("sorry! not able to get your position.");
    }
    if (err.code == 3) {
      alert("sorry! timeout expired.");
    }
}

$(document).ready(function() {
	
	localization();
});


function getforecast(lat,lng){
	$.get("http://api.openweathermap.org/data/2.5/forecast",{
		"lat":lat,
		"lon":lng,
		"APPID": "2cbac0d6282afa096674267c64a8af5c"
	 }).done(function(data){
								 
		 let grades = '&#176;k';
		 var days = [];
		 var indx = [];
		 var count = 0;
		 var content = '';
		
		 for(var it in data.list)
		 {
			let obj = data.list[it];
			let date = obj.dt_txt.split(' ')[0];	
			
			if(days.indexOf(date) == -1)
			{
				days[count] = date;
				indx[count] = it;
				count++;
			}
		}
			$('.floaty').css("visibility","hidden");
			//displaying the 5 days
			if(indx.length >= 1)
			{
				let title = data.city.name + ', ' +data.city.country;
				content = data.list[indx[0]].main.temp + ' '+ grades;
				let description = '<b>'+data.list[indx[0]].weather[0].main + ' :</b>  ' + data.list[indx[0]].weather[0].description + '<br/><br/>'
					+ '<b>Temp min:</b>  ' + data.list[indx[0]].main.temp_min +' '+grades +'<br/><br/>' 
					+ '<b>Temp max:</b>  ' + data.list[indx[0]].main.temp_max +' '+grades + '<br/><br/>' 
					+ '<b>Humidity:</b>  ' + data.list[indx[0]].main.humidity + '<br/><br/>' 
					+ '<b>Pressure:</b>  ' + data.list[indx[0]].main.pressure;
				$('#actual').css("visibility","visible");
				$('#actual img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[0]].weather[0].icon + ".png");
				$('#actual > p').html(description);
				$('#actual h3').text(title);	
					
			}
				if(indx.length >= 2)
				{
					let title = new Date(data.list[indx[1]].dt_txt).toString();
					let description = '<b>'+data.list[indx[1]].main.temp + ' '+ grades + '<b/><br/>' 
						+'<b>'+ data.list[indx[1]].weather[0].description +'<b/>';
					$('#first').css("visibility","visible");
					$('#first img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[1]].weather[0].icon + ".png");
					$('#first p').html(description);
					$('#first h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
				}
				if(indx.length >= 3)
				{
					let title = new Date(data.list[indx[2]].dt_txt).toString();
					let description = '<b>'+data.list[indx[2]].main.temp + ' '+ grades + '<b/><br/>' 
					+'<b>'+ data.list[indx[2]].weather[0].description +'<b/>';
					$('#second').css("visibility","visible");
					$('#second img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[2]].weather[0].icon + ".png");
					$('#second p').html(description);
					$('#second h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
				}
				if(indx.length >= 4)
				{
					let title = new Date(data.list[indx[3]].dt_txt).toString();
					let description = '<b>'+data.list[indx[3]].main.temp + ' '+ grades + '<b/><br/>' 
					+'<b>'+ data.list[indx[3]].weather[0].description +'<b/>';
					$('#third').css("visibility","visible");
					$('#third img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[3]].weather[0].icon + ".png");
					$('#third p').html(description);
					$('#third h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
				}
				if(indx.length >= 5)
				{
					let title = new Date(data.list[indx[4]].dt_txt).toString();
					let description = '<b>'+data.list[indx[4]].main.temp + ' '+ grades + '<b/><br/>' 
					+'<b>'+ data.list[indx[4]].weather[0].description +'<b/>';
					$('#fourth').css("visibility","visible");
					$('#fourth img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[4]].weather[0].icon + ".png");
					$('#fourth p').html(description);
					$('#fourth h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
				}
				if(indx.length >= 6)
				{
					let title = new Date(data.list[indx[5]].dt_txt).toString();
					let description = '<b>'+data.list[indx[5]].main.temp + ' '+ grades + '<b/><br/>' 
					+'<b>'+ data.list[indx[5]].weather[0].description +'<b/>';
					$('#fifth').css("visibility","visible");
					$('#fifth img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[5]].weather[0].icon + ".png");
					$('#fifth p').html(description);
					$('#fifth h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
				}					
				

	   }).fail(function(){
		    console.log("couldn't got the weather forecast for your position");
	    });
}

