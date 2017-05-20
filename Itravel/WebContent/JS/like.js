/**
 * 
 */

$(document).ready(function() {
	
	$('.fa-like').click(function(e) {
		
		alert(e);
		
		$(e)
		.closest( "h1" )
		.css( "background-color", "red" );
	
		});
	});


