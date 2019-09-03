<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Students</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age</td>
					<td>Address</td>
					<td>City</td>
					<td>State</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="s">
					<c:set var="c" value="${s.getContact()}"></c:set>
					<tr>
						<td>${s.getFirstName()}</td>
						<td>${s.getLastName()}</td>
						<td>${s.getAge()}</td>
						<td>${c.getAddress()}</td>
						<td>${c.getCity()}</td>
						<td>${c.getState()}</td>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>