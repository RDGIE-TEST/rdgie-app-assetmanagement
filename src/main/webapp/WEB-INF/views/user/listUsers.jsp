<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIST OF USERS</title>

<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">

</head>
<body>
	<h1>LIST OF USERS</h1>
	<form:form action="listUsers" commandName="user">
		<table id="customers">
			<tr>
				<th>USER ID</th>
				<th>FIRST NAME</th>
				<th>LAST NAME</th>
				<th>EMAIL</th>
				<th>USERNAME</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>

			<c:forEach items="${userList}" var="user">
				<tr>

					<td>${user.userId}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.email}</td>
					<td>${user.username}</td>
					<td><a href="#">Edit</a></td>
					<td><a href="#">Delete</a></td>
				</tr>

			</c:forEach>


		</table>
	</form:form>
</body>
</html>