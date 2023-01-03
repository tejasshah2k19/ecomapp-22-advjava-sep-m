<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>


	<div class="container-fluid">
		<div class="row">

			<div class="col-md-6">
				<h2>Login</h2>
				<form action="LoginController" method="post">

					<div class="form-group">
						<label>Email</label> <input type="text" name="email"
							class="form-control" placeholder="Email">
					</div>


					<div class="form-group">
						<label>Password</label> <input type="text" class="form-control"
							placeholder="Password" name="password">
					</div>
					<br>

					<button class="btn btn-primary">Login</button>
				</form>
				
				${error}
				<br>
				<a href="Signup.jsp">New User?</a>
			</div>

		</div>

	</div>


</body>
</html>