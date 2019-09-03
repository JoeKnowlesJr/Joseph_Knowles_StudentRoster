<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>New Contact</title>
	</head>
	<body>
		<h1>New Contact</h1>
		<form:form action="/contacts/create" method="get" modelAttribute="contact">
			<table>
				<tr>
					<td>Student</td>
					<td><form:select path="student">
						<c:forEach items="${students}" var="s">
							<form:option value="${s.getId()}">${s.getName()}</form:option>
						</c:forEach>
					</form:select></td> 
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"></td> 
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city"></td> 
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="state"></td> 
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create"></td> 
				</tr>
			</table>		
		</form:form>
	</body>
</html>