<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>New Student</title>
	</head>
	<body>
		<h1>New Student</h1>
		<form:form action="/students/create" method="get" modelAttribute="student">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"></td> 
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"></td> 
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age"></td> 
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td> 
				</tr>
			</table>		
		</form:form>
	</body>
</html>