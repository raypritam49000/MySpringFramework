<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<h1 align="center">Welcome to Employee Management System</h1>
	<h2 align="center" style="color: green;" class="alert alert-info">Update Employee</h2>
	<br>
	<h3><div id="msgDiv" style="display: none; color: green;" align="center"></div></h3>
	<br>
	<c:choose>
		<c:when test="${empList != null}">
			<table border="1" align="center" class="table table-hover" style="width: 28%;">
				<tr>
					<td>Select Employee ID:<span style="color: red;"> *</span></td>
					<td>
						<select id="SelectedEmpId">
							<option value="NONE">--Select Emp No--</option>
							<c:forEach items="${empList}" var="emp">
								<option value="${emp.firstName}&${emp.lastName}&${emp.deptName}" id="${emp.empNo}">${emp.empNo}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr id="EmpFirstNameTr" style="display: none;">
					<td>First Name:</td>
					<td><input type="text" name="updFirstName" id="EmpUptFirstName"></td>
				</tr>
				<tr id="EmpLastNameTr" style="display: none;">
					<td>Last Name:</td>
					<td><input type="text" name="updLastName" id="EmpUptLastName"></td>
				</tr>
				<tr id="EmpDeptNameTr" style="display: none;">
					<td>Dept Name:</td>
					<td><input type="text" name="updDeptName" id="EmpUptDeptName"></td>
				</tr>
				<tr id="EmpBtn" style="display: none;">
					<td align="center"><input type="button" id="CancelBtn" value="Cancel" class="btn btn-primary"/></td>
					<td align="center"><input type="button" id="UpdateBtn" value="Update Employee" class="btn btn-primary"/></td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#SelectedEmpId").change(function(){
			$("#msgDiv").hide();
			var empId = $("#SelectedEmpId :selected").text();
			var empTemp = $("#SelectedEmpId :selected").val();
			var id = $("#SelectedEmpId :selected").val();
			empTemp=empTemp.split("&");
			
			if(empTemp != "NONE") {
				var firstName=empTemp[0];
				var lastName=empTemp[1];
				var deptName=empTemp[2];
				$("#EmpUptFirstName").val(firstName);
				$("#EmpUptLastName").val(lastName);
				$("#EmpUptDeptName").val(deptName);
				$("#EmpFirstNameTr").show();
				$("#EmpLastNameTr").show();
				$("#EmpDeptNameTr").show();
				$("#EmpBtn").show();
				$("#SelectedEmpId").prop('disabled', false);
			} else {
				clearEmployeeData();
			}
		});
		
		$("#CancelBtn").click(function(){
			clearEmployeeData();
		});
		
		function clearEmployeeData() {
			$("#EmpFirstNameTr").hide();
			$("#EmpLastNameTr").hide();
			$("#EmpDeptNameTr").hide();
			$("#EmpBtn").hide();
			$("#SelectedEmpId").prop('selectedIndex',0);
		}
		
		$("#UpdateBtn").click(function(){
			var empNo = $("#SelectedEmpId :selected").text();
			var firstName=$("#EmpUptFirstName").val();
			var lastName=$("#EmpUptLastName").val();
			var deptName=$("#EmpUptDeptName").val();
		    $.ajax({
		        url: "./updateEmployee",
		        data: {empNo:empNo, firstName:firstName, lastName:lastName, deptName: deptName},
		        type: "POST",
		        success: function(data) {
      				$("#msgDiv").text(data);
      				$("#msgDiv").show();
      				clearEmployeeData();
		        }
		    });
		});
	});
</script>
</html>