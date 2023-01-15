<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>

<link href="<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/webjars/bootstrap/5.1.3/js/bootstrap.js" />" rel="stylesheet">
<script src="<c:url value="/webjars/jquery/3.6.0/jquery.js" />"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col col-md-8 offset-md-2">
				<div class="card">

					<div class="card-header">
					        <div id="result"></div>
						<h6 class="text-center">Add Employee</h6>
					</div>

					<div class="card-body">

						<form id="submitForm">

							<div class="mb-3">
								<label for="name" class="form-label">Enter Name</label> <input
									type="text" class="form-control" id="name" name="name">
							</div>

							<div class="mb-3">
								<label for="email" class="form-label">Enter Email</label> <input
									type="email" class="form-control" id="email" name="email">
							</div>

							<div class="mb-3">
								<label for="city" class="form-label">Enter City</label> <input
									type="text" class="form-control" id="city" name="city">
							</div>

							<div class="mb-3">
								<label for="salary" class="form-label">Enter Salary</label> <input
									type="text" class="form-control" id="salary" name="salary">
							</div>

							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" id="checkBox">
								<label class="form-check-label" for="checkBox">Check me
									out</label>
							</div>

							<button type="submit" class="btn btn-primary">Add
								Employee</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			console.log("page is ready....")
			var ctx = "${pageContext.request.contextPath}"

			$('#submitForm').on('submit', function(event) {

				event.preventDefault();
				console.log("sumbit page is ready....")
				var formData = $(this).serialize();
				console.log(JSON.stringify(formData));

				$.ajax({
					url : ctx + "/addEmployee",
					data : formData,
					type : 'POST',
					contentType : "application/json; charset=utf-8",
					async : false, //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
					cache : false, //This will force requested pages not to be cached by the browser          
					processData : false,
					success : function(response,textStatus, jqXHR) {
						console.log(response.trim());
						console.log(textStatus);
						console.log(jqXHR);
						console.log(jqXHR.statusText);
						console.log(jqXHR.status);
						
						if(jqXHR.status==200){
							swal("Add Employee Successfully...");
							$("#submitForm")[0].reset();
							console.log("Clear Form ...")
						}
						
						if(jqXHR.status!=200){
							swal("Error Occure When add Employee...");
						}
						
					},
					error : function(jqXHR, textStatus, errorThrown) {
						if(jqXHR.status!=200){
							swal("Error Occure When add Employee...");
						}
					}
				});

			})

		});
	</script>
</html>