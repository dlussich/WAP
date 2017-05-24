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
<script src="JS/checkUser.js" type="text/javascript"></script>
<title>Update Profile</title>
</head>
<script type="text/javascript">
	$(function(){
		$("select[name='gender']").val('${sessionScope.user.gender}');
		$("select[name='state']").val('${sessionScope.user.state}');

	})

</script>
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
			<h2>Update Profile:</h2>
			</header>
		</div>
		</section>
		<section>
		<form name="form1" action="UpdateUserServlet" method="post">
			<table align="center">
				
				<tr>
					<td>Full Name</td>
					<td>
					<input type="hidden" name="user_id" value="${sessionScope.user.id_user }" />
					<input type="hidden" id="currentpass" value="${sessionScope.user.password }" />
					<input type="text" name="fullname" required value="${sessionScope.user.fullName}" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><select name="gender">
							<option>select gender</option>
							<option value="M">Male</option>
							<option value="F">Female</option>
					</select></td><td></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select name="state">
							<option>select state</option>
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District Of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WI">Wisconsin</option>
							<option value="WY">Wyoming</option>
					</select></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" value="${sessionScope.user.city }" /></td><td></td>
				</tr>
				<tr>
					<td>Street</td>
					<td><input type="text" name="street" value="${sessionScope.user.street }" /></td><td></td>
				</tr>
				<tr>
					<td>Zip Code</td>
					<td><input type="text" pattern="^\d{5}$"
						title="Please input five integer US zip code" name="zipcode" value="${sessionScope.user.zipCode }"/></td><td></td>
				</tr>
				<tr>
					<td>Birth Year</td>
					<td><input type="text" pattern="^(19|20)\d{2}$"
						title="Please input correct four digits year" name="birthyear" value="${sessionScope.user.birthYear }"/></td><td></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text"
						pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
						title="Please input correct email address" name="email" required value="${sessionScope.user.email }"/></td><td></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" id="username" required value="${sessionScope.user.userName }" disabled/></td><td id="user_name_check">Cannot change User Name.</td>
				</tr>
				<tr>
					<td>Current Password</td>
					<td><input type="password"
						name="currentpassword" id="currentpassword" required /></td><td id="iscurrentpassmatch"></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type="password"
						pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$"
						title="Password should be at least 6 letters and must include at least one upper case letter, one lower case letter, and one numeric digit."
						name="password" id="password" required /></td><td></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="conpassword" id="conpassword" required /></td><td id="ismatch"></td>
				</tr>
				<tr>
					<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></input><input
						type="reset" value="Reset"></input></td>
				</tr>
			</table>
		</form>
		</section>
	</div>
	

	<!-- Scripts -->
</body>
</html>