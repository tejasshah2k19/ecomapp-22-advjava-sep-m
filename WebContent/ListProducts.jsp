<%@page import="com.bean.ProductBean"%>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<%
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");
	%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">eComApp</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="Home.jsp">Home
						 
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Features</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="ListProductServlet">View Products</a></li>
				<li class="nav-item"><a class="nav-link" href="#">My Cart</a></li>
				<li class="nav-item"><a class="nav-link" href="#">My Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Logout</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">

		<div class="Row">
			<div class="col-md-4">



				<%
					for (ProductBean p : products) {
				%>

				<div class="card">
					<div class="card-body">
						<%=p.getName()%><br>
						<%=p.getPrice()%><br> <a href="AddToCartServlet?productId=<%=p.getProductId()%>">AddToCart</a>
					</div>
				</div>
				<br>
				<%
					}
				%>

			</div>
		</div>
	</div>



</body>
</html>