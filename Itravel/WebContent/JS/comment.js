/**
 * 
 */
$(document).ready(function() {
	$(".fa-comment").click(fcomment);
});

function fcomment(event) {
	event.preventDefault();
	var val = $(this).attr('id');
	var id_post = val.substring(1, val.length);
	var content = "#DZ" + id_post;
	$(content).remove();
	flistcommet(id_post);// call all the list of comments
	var content = "#CON" + id_post;
	var textarea = '<textarea class="comment" name=CT' + id_post + ' id=CT'
			+ id_post + '></textarea>';

	$(content).append(
			'<div  id=DZ' + id_post + '>' + '<div class="close_div" > Close <a href="#menu"  id=BY' + id_post
					+ '>' + 'X' + '</a></div>' + '<p>Write your Comment: ' + textarea + '</br>'
					+ '<input class="botton_comment" type="submit" value="Send Comment" id=BZ' + id_post
					+ '  />' + '</p>' + '</div>');
	$('#BY' + id_post).click(closecomment);
	$('#BZ' + id_post).click(faddcomment);
}

function closecomment(event) {
	var val = $(this).attr('id');
	var id_post = val.substring(2, val.length);
	var content = "#DZ" + id_post;
	$(content).remove();

}

function flistcommet(id_post) {
	var $select = $("#DZ" + id_post);

	$.ajax("CommentListServlet", {
		"type" : "post",
		"data" : {
			"id_post" : id_post
		}
	}).done(
			function(responseJson) {
				if (responseJson !== null) {
					$("#DZ" + id_post).append(
							'<table class="comment"  id=T'
									+ id_post + '/>');
					var table = "#DZ" + id_post + " #T" + id_post;
					$(table).append('<th>Comment</th>');
					$(table).append('<th>User</th>');
					$(table).append('<th>Date</th>');
					$.each(responseJson, function(key, value) {
						$(table).append('<tr>',
								'<td>' + value.comment + '</td>',
								'<td>' + value.id_user.userName + '</td>',
								'<td>' + value.date_comment + '</td>',
								'</tr>');
					});
					$("#DZ" + id_post).append('</br>');
				} else {
					alert("Error with the like!!");
				}
			}).fail(function() {
		console.log("Failed");
	})

}

function faddcomment(event) {
	var val = $(this).attr('id');
	var id_post = val.substring(2, val.length);
	var comment = $("#CT" + id_post).val();
	$.ajax("CommentServlet", {
		"type" : "post",
		"data" : {
			"id_post" : id_post,
			"comment" : comment,
		}
	}).done(function(response) {
		if (response != -1) {
			$("#CT" + id_post).val("");
			$("#T"+id_post).remove();
			flistcommet(id_post);
		} else {
			alert("Error with the add comment!!");
		}
	}).fail(function() {
		console.log("Failed");
	})

}