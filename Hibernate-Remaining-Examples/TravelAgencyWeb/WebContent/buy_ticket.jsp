<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Buy Ticket</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/buyTicket" method="POST">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>Passenger Id</td>
								<td>
									<input type="text" name="passengerId"/>
								</td>
							</tr>
							<tr>
								<td align="center" colspan="2">(or)</td>
							</tr>
							<tr>
								<td>First Name</td>
								<td>
									<input type="text" name="firstNm"/>
								</td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td>
									<input type="text" name="lastNm"/>
								</td>
							</tr>
							<tr>
								<td>Age</td>
								<td>
									<input type="text" name="age"/>
								</td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>
									<input type="text" name="gender"/>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table>
							<tr>
								<th>Choose</th>
								<th>Source</th>
								<th>Destination</th>
								<th>Date Of Journey</th>
							</tr>
							<c:forEach items="${journeys}" var="journey">
								<tr>
									<td>
										<input type="radio" name="journeyId" value="${journey.journeyId}"/>										
									</td>
									<td>${journey.source}</td>
									<td>${journey.destination}</td>
									<td><c:out value="${journey.dateOfJourney}"/></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Buy"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>









