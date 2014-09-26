<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />

<title>Login</title>

<link
	href="<c:url value="/resources/bootstrap/loginForm/css/demo.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/loginForm/css/style.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/loginForm/css/animate-custom.css" />"
	rel="stylesheet">


<link
	href="<c:url value="/resources/bootstrap/loginForm/css/pastel-stream.css" />"
	rel="stylesheet">


</head>
<body>
	<div class="container">

		<header>
			<h1>ASSET MANAGEMENT SYSTEM</h1>

		</header>
		<section>
			<div id="container_demo">

				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
					
						
						<form method="post" action="checklogin" autocomplete="on">
						<h1><b>Login here</b></h1>
						
							<c:if test="${not empty userError}"><p><b>Incorrect username or password for user ${userError.username}</b></p></c:if>
							<p>
								<label for="username" class="uname" data-icon="u"> Your
									username </label> <input id="username" name="username"
									required="required" type="text"
									placeholder="Enter your username here" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									Your password </label> <input id="password" name="password"
									required="required" type="password"
									placeholder="Enter your password here" />
							</p>

							<p class="login button">
								<input type="submit" value="Login" name="login" />
							</p>
							<p class="change_link">
								Not yet Registered?<a href="createUser">Register here</a>
							</p>
						</form>
					</div>

					

				</div>
			</div>
		</section>
	</div>
</body>
</html>