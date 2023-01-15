<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<h1 align="center">Welcome to Employee Management System</h1>​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​
	<h2 align="center" style="color: green;" class="alert alert-info">Employee
		List</h2>
	<br>
	<c:if test="${empList != null}">
		<table align="center" class="table table-hover table-bordered"
			style="width: 70%;">
			<tr style="background-color: silver;">
				<th>SNo</th>
				<th>Emp ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Dept</th>
			</tr>
			<c:forEach items="${empList}" var="emp" varStatus="counter">
				<tr>
					<td align="center"><c:out value="${counter.count}"></c:out></td>
					<td><c:out value="${emp.empNo}"></c:out></td>
					<td><c:out value="${emp.firstName}"></c:out></td>
					<td><c:out value="${emp.lastName}"></c:out></td>
					<td><c:out value="${emp.deptName}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>