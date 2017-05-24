<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dao.PostDao"%>
<%@page import="com.bean.PostBean"%>
<%@page import="com.dao.ImageDao"%>
<%@page import="com.bean.ImageBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="com.enums.State"%>
<%@ taglib prefix='mytag' uri='/WEB-INF/tlds/loop'%>
<%@ page import="java.util.*, com.customertag.* ,com.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css" />
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCxM39UmYCSuurpCoINutq9Q2kec--RuF0"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="JS/main.js" type="text/javascript"></script>
<script src="JS/like.js" type="text/javascript"></script>
<script src="JS/location.js" type="text/javascript"></script>
<script src="JS/comment.js" type="text/javascript"></script>
<script src="JS/weather.js" type="text/javascript"></script>
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
								<li><a href="Weather.html">Check Weather</a></li>
								<li><a href="Register.jsp">Sign Up</a></li>
								<c:if test="${sessionScope == null }"><li><a href="SignIn.jsp">Sign In</a></li></c:if>
								<li><a href="updateUser.jsp">Update Profile</a></li>
								<li><a href="SignoutServlet">Sign Out</a></li>
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
					WAP FINAL PROJECT</h3> 
					<h3>Created by:<br /> 
					Gloria Gallego<br /> 
					Yi Cai<br /> 
					Diego Lussich<br /></h3> 
				</p>
				<p class="user" >Welcome: ${user.userName}</p>
				<ul class="actions">
					<li><a href="Post.jsp" class="button special">PUBLISH</a></li>
					<li><a href="#two" class="more scrolly"></a></li>
				</ul>
			</div>

		</section>

		<!-- POST -->
		<section id="two" class="wrapper alt style2">

			<!-- Blog entries -->
			<mytag:simple postList="${listreq}">
				<section class="spotlight">
					<div class="image">
					<c:if test="${not empty mypost.image}">
   					<img src="${mypost.image}" alt="" />
					</c:if>
					</div>
					<div class="content" id ="CON${mypost.post}">
						<h1>#${mypost.post}</h1>
						<h2>Publication Date: ${mypost.date_post}</h2>
						<h4>${mypost.state}</h4>
						<h3 id="S${mypost.post}">${mypost.city}</h3>
						<h3>Zip Code:${mypost.zip_code}</h3>
						<p>${mypost.text}</p>
						<p>
							<ul class="icons">
						<li><span id="L${mypost.post}">${mypost.likes}</span><a
								id="A${mypost.post}" class="icon fa-like"><span
									class="label"></span></a></li>
						<li><a id="B${mypost.post}" class="icon fa-comment"><span
									class="label"></span></a></li>
						<li><a id="C${mypost.post}" class="icon fa-location"><span
									class="label"></span></a></li>

					</ul>
					</p>
				</div>
			</section>
		</mytag:simple>
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