$(function() {
	$(".menuToggle").click(
			function(e) {
				console.log("MENU");
				// Menu.
				$('#menu').append('<a href="#menu" class="close"></a>').click(
						function(e) {
							console.log("ocultar menu");
							// Menu.
							$(".close").remove();
							$('body').removeClass("is-menu-visible");

						});
				$('body').addClass("is-menu-visible");

			});
	//inicialize list of post.
	$.ajax("MainServlet", {
		"type" : "post"
	}).fail(function() {
		console.log("Failed");
	})
});

