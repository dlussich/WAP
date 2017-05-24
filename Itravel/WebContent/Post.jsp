<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="JS/main.js" type="text/javascript"></script>
<script src="JS/post.js" type="text/javascript"></script>

<title>CREATE POST</title>
</head>
<!--<body class="landing is-mobile is-menu-visible">-->
<body class="landing">
	<!-- Page Wrapper -->
	<div id="page-wrapper">
		<!-- Header -->
		<header id="header" class="alt"> <nav id="nav">
		<ul>
			<li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
				<div id="menu">
					<ul>
						<li><a href="Index.jsp">Home</a></li>
						<li><a href="Post.jsp">Publish Post</a></li>
						<li><a href="Weather.html">Check Weather</a></li>
						<li><a href="Register.jsp">Sign Up</a></li>
						<c:if test="${sessionScope == null }"><li><a href="SignIn.jsp">Sign In</a></li></c:if>
						<li><a href="updateUser.jsp">Update Profile</a></li>
						<li><a href="SignoutServlet">Sign Out</a></li>
					</ul>
				</div></li>
		</ul>
		</nav> </header>
		<!-- One -->
		<section id="one" class="wrapper style1 special">
		<div class="inner">
			<header>
			<h2>Create Post:</h2>
			</header>
		</div>
		</section>
		<section>
		<form action="PostServlet" method="post" enctype="multipart/form-data">
			Tell us about your travel:
			<textarea rows="5" cols="10" name="text_post" required="required"></textarea>
			<br />
			State:
			<select id="states" name="state">
					<option>Select State</option>
				</select>
			<br />
			City:<input type="text" name="city"
				required="required" />
			<br /> 
			Street:<input type="text" name="street"
				required="required" />
			<br /> 
			Zip Code:<input
				type="text" name="zip_code" pattern="[0-9]{5}"
				title="Five digit zip code" required="required" />
			<br /> 
			<input
				type="file" name="image" /><br /> <br /> <input type="submit" />
		</form>
		</section>
	</div>

	<!-- Scripts -->


</body>
</html>