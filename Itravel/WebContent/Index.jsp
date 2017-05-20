<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dao.PostDao"%>
<%@page import="com.bean.PostBean"%>
<%@page import="com.dao.ImageDao"%>
<%@page import="com.bean.ImageBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="JS/main.js" type="text/javascript"></script>
<script src="JS/like.js" type="text/javascript"></script>

<title>ITRAVEL WAP</title>
</head>
<!--<body class="landing is-mobile is-menu-visible">-->
<body class="landing">
	<!-- Page Wrapper -->
	<div id="page-wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<nav id="nav">
				<ul>
					<li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
						<div id="menu">
							<ul>
								<li><a href="Index.jsp">Home</a></li>
								<li><a href="Post.jsp">Publish Post</a></li>
								<li><a href="elements.html">Delete Post</a></li>
								<li><a href="elements.html">Check Weather</a></li>
								<li><a href="#">Sign Up</a></li>
								<li><a href="#">Log In</a></li>
							</ul>
						</div></li>
				</ul>
			</nav>
		</header>
		<!-- Banner -->
		<section id="banner">
			<div class="inner">
				<h2>ITRAVEL</h2>
				<p>
					PROJECT FOR WAP<br /> Create by:<br /> Gloria Gallego<br /> Yi
					Cai<br /> Diego Lussich<br />
				</p>
				<ul class="actions">
					<li><a href="Register.jsp" class="button special">REGISTER</a></li>
				</ul>
			</div>
			<a href="#two" class="more scrolly">Learn More</a>
		</section>

		<!-- POST -->
		<section id="two" class="wrapper alt style2">
			<!-- Blog entries -->
			<%
				PostDao PostDao = new PostDao(); //not recommended.Pass this object from servlet
				ImageDao ImageDao = new ImageDao();
				String img = "";
				ImageBean ImageBean;
				int id;

				List<PostBean> list = PostDao.listAllPost();
				for (PostBean c : list) {
					// The core Logic of the Registration application is present here. We
					// are going to insert user data in to the database.
					id = Integer.valueOf(c.getPost());
					ImageBean = ImageDao.GetImage(id);
					img = ImageBean.getImageString();
			%>
			<section class="spotlight">
				<div class="image">
					<%
						if (img != null) {
					%>
					<img src="<%=img%>" alt="" />
					<%
						}
					%>
				</div>
				<div class="content">
					<h1>#<%=c.getPost()%></h1>
					<h2>Publication Date: <%=c.getDate_post()%></h2>
					<h3><%=c.getLocation()%></h3>
					<p><%=c.getText()%></p>
					<p>
					<ul class="icons">
						<li><span id="L<%=c.getPost()%>"><%=c.getLikes()%></span><a
							id="A<%=c.getPost()%>" class="icon fa-like"><span
								class="label"></span></a></li>
						<li><a id="B<%=c.getPost()%>" class="icon fa-comment"><span
								class="label"></span></a></li>
						<li><a id="C<%=c.getPost()%>"
							class="icon fa-location"><span class="label"></span></a></li>

					</ul>
					</p>
				</div>
			</section>
			<%
				}
			%>

			<!-- Footer -->
			<footer id="footer">
				<ul class="copyright">
					<li>&copy; MUM</li>
					<li>Design: GROUP TEAM</li>
				</ul>
			</footer>
	</div>

	<!-- Scripts -->


</body>
</html>