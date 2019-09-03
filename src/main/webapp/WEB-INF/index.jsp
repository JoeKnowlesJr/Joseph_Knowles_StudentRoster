<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Student Roster</title>
	</head>
	<body>
		<h1>Student Roster</h1>
		
		<form method="post">
			<input type="submit" formaction="/students/new" value="Create Student">
			<input type="submit" formaction="/contacts/new" value="Create Conatct">
			<input type="submit" formaction="/students" value="Show Students">
		</form>
	</body>
</html>