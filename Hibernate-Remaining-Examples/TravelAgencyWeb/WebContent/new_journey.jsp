<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Journey</title>
	</head>
	<body>
		<h1>New Journey</h1>
		<form action="${pageContext.request.contextPath}/addJourney" method="POST">
			<table>
				<tr>
					<td>Source</td>
					<td>
						<input type="text" name="source"/>
					</td>
				</tr>
				<tr>
					<td>Destination</td>
					<td>
						<input type="text" name="destination"/>
					</td>
				</tr>
				<tr>
					<td>Date of Journey (dd/mm/yyyy)</td>
					<td>
						<input type="text" name="doj"/>
					</td>
				</tr>
				<tr>
					<td>Bus</td>
					<td>
						<select name="bus">
							<c:forEach items="${buses}" var="bus">
								<option value="${bus.busNo}">${bus.registrationNo}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Staff</td>
					<td>
						<select name="staff" multiple="multiple" size="3">
							<c:forEach items="${staff}" var="s">
								<option value="${s.staffId}">${s.staffNm}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>	
		</form>
	</body>
</html>




