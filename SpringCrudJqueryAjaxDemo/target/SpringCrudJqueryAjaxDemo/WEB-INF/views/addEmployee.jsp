<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<h1 align="center">Welcome to Employee Management System</h1>
	<h2 align="center" style="color: green;" class="alert alert-info">Register Employee</h2>
	<h3 align="center" style="color: green;" id="msgDiv">${msg}</h3>
	<br>
	<form action="./addEmployee" method="POST">
		<table align="center" style="width: 35%;"
			class="table table-hover table-bordered">
			<tr>
				<td>First Name:</td>
				<td><input type="text" id="firstName" name="firstName" required /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" id="lastName" name="lastName" required /></td>
			</tr>
			<tr>
				<td>Dept Name:</td>
				<td><input type="text" id="deptName" name="deptName" required /></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit" class="btn btn-primary"
							value="Register Employee" align="middle" />
					</center></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#firstName, #lastName, #deptName").click(function() {
			$("#msgDiv").hide();
		});
	});
</script>
</html>