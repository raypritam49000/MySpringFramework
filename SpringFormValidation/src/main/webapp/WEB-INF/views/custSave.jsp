<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Save Page</title>
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
						<h1>Add Customer</h1>
					</div>

					<div class="card-body">

						<form  action="${pageContext.request.contextPath}/addCustomer"   method="post">
						
							<div class="mb-3"> 
							    <label for="name" class="form-label">Enter Your Name </label>
							    <input type="text" class="form-control" id="name" name="name" placeholder="Enter Here" required="required">
							</div>

							<div class="mb-3">
								<label for="email" class="form-label">Enter Your Email</label>
								<input type="email" class="form-control" id="email" name="email" placeholder="Enter Here" required="required">
							</div>
							
							<div class="mb-3">
								<label for="age" class="form-label">Enter Your Age</label>
								<input type="text" class="form-control" id="age" name="age" placeholder="Enter Here" required="required">
							</div>
							
							<div class="mb-3">
								<label for="phone" class="form-label">Enter Your Mobile Number</label>
								<input type="number" class="form-control" id="phone" name="phone" placeholder="Enter Here" required="required">
							</div>
							
							<div class="mb-3">
								<label for="birthday" class="form-label">Enter Your BirthDay</label>
								<input type="date" class="form-control" id="birthday" name="birthday" placeholder="Enter Here" required="required">
							</div>

			
							<div class="container text-center">
							   <button type="submit" class="btn btn-primary">Add Customer</button>
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