<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="JS/main.js" type="text/javascript"></script>
<title>Itravel</title>
</head>
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
						<li><a href="elements.html">Delete Post</a></li>
						<li><a href="elements.html">Check Weather</a></li>
						<li><a href="Register.jsp">Sign Up</a></li>
						<li><a href="SignIn.jsp">Sign In</a></li>
						<li><a href="SignoutServlet">Sign Out</a></li>
					</ul>
				</div></li>
		</ul>
		</nav> </header>	
		<!-- One -->
		<section id="one" class="wrapper style1 special">
		<div class="inner">
			<header>
			<h2>Sign in:</h2>
			</header>
		</div>
		</section>
<section>
	<form action="SignInServlet" method="POST">
			User Name: <input type="text" name="user_name" required /> <br />
			Password: <input type="password"
				pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$"
				title="Password should be at least 6 letters and must include at least one upper case letter, one lower case letter, and one numeric digit."
				name="password" required /> <br /> 	
		<input type="submit" value="Submit" />
		<div>${errMessage}</div>
	</form>
</section>
</body>
</html>