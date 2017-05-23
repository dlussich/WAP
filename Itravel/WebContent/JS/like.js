/**
 * 
 */

$(document).ready(function() {
	$(".fa-like").click(addLikes);
});



function addLikes(event){	
	event.preventDefault();
	var val= $(this).attr('id');
	var id_post= val.substring(1, val.length);
		$.ajax("LikesServlet", {
			"type" : "post",
			"data" : {
				"id_post" : id_post
			}
		}).done(function(response) {
			if(response !=-1) {
				var like= "#L"+ id_post;
				$(like).text(response);
				var post_like="#"+val;
				 $(post_like).unbind("click");
			}
			else {
				 alert("Error with the like!!");
			}
		}).fail(function() {
			console.log("Failed");
		})
	 
}


