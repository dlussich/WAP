/**
 * 
 */

$(document).ready(function() {
	$("#username").focusout(checkUser);
	$("#conpassword").keyup(confirmPassword);
	$("#register").click(function(event){
		
	});
});


function checkUser(event){
	 event.preventDefault();
	 var username = $(this).val();
		$.ajax("CheckUserServlet", {
			"type" : "post",
			"data" : {
				"username" : username
			}
		}).done(function(response) {
			if(response == -1) {
				$("td#user_name_check").text("User name already exist");
			} else {
				$("td#user_name_check").text("User name is ok!!");
			}
		}).fail(function() {
			alert("failed");
			console.log("Server wrong");
		})
	 
}


function confirmPassword(event){
	 event.preventDefault();
	 var password = $("#password").val();
	 var conpassword = $("#conpassword").val();
		
	 if(conpassword == password) {
	 	$("#ismatch").text("");
	 } else {
	 	$("#ismatch").text("Passwords have to be the same");
	 }
	 
}


