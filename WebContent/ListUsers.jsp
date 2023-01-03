<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>

	<div class="container-fluid">

		<div class="Row">
			<div class="col-md-6">
				<table class="table table-bordered table-hover">
					<tr>
						<th>UserId</th>
						<th>FirstName</th>
						<th>Email</th>
						<th>Password</th>
					</tr>

					<%
						for (UserBean user : users) {
					%>
					<tr>
						<td><%=user.getUserId()%></td>
						<td><%=user.getFirstName()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getPassword()%></td>

					</tr>


					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>



</body>
</html>