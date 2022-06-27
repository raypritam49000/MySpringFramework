<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-2">

		<div class="row">

			<div class="col-md-8 offset-md-2">


				<div class="card">

					<div class="card-header text-center text-white bg-primary">
						<h1>Add Employee</h1>
					</div>

					<div class="card-body">

						<form  action="${pageContext.request.contextPath}/addEmployee"   method="post">
						
							<div class="mb-3"> 
							    <label for="name" class="form-label">Enter Your Name </label>
							    <input type="text" class="form-control" id="name" name="name" placeholder="Enter Here" required="required">
							</div>

							<div class="mb-3">
								<label for="city" class="form-label">Enter Your City</label>
								<input type="text" class="form-control" id="city" name="city" placeholder="Enter Here" required="required">
							</div>
							
							<div class="mb-3">
								<label for="salary" class="form-label">Enter Your Salary</label>
								<input type="text" class="form-control" id="salary" name="salary" placeholder="Enter Here" required="required">
							</div>

			
							<div class="container text-center">
							   <button type="submit" class="btn btn-primary">Add Employee</button>
							   <button type="reset" class="btn btn-danger">Reset</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>