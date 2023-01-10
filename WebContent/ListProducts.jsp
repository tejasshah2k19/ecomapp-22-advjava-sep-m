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


	<jsp:include page="Header.jsp"></jsp:include>
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