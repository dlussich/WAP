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
	var map = $(city).text();
	var content= "#CON"+id_post;
	$(content).append('<div  id=DC'+ id_post+'>'
			+'<a href="#menu"  id=BC'+ id_post+ '>'+'X'+'</a>'
			+'<p>'+map+'</p>'
			+'</div>');
	$('#BC'+id_post).click(fmaps);
	
}

function fmaps(event){
	
	var val= $(this).attr('id');
	var id_post= val.substring(2, val.length);
	var content= "#DC"+id_post;
	$(content).remove();
	
}
