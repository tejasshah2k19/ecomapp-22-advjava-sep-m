<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.CartBean"%>
<%@page import="com.bean.ProductBean"%>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<%
		ArrayList<CartBean> carts = (ArrayList<CartBean>) request.getAttribute("myCart");
	%>

	<jsp:include page="Header.jsp"></jsp:include>



	<div class="container-fluid">
		<br>

		<div class="Row">
			<div class="col-md-4">



				<%
					for (CartBean p : carts) {
				%>

				<div class="card">
					<div class="card-body">
						<b>ProductdCode : </b><%=p.getProductId()%><br> <b>Name :
						</b><%=ProductDao.getProductDetailById(p.getProductId()).getName()%><br>
						<b>Qty : </b><%=p.getQty()%><br> <a
							href="RemoveCartServlet?cartId=<%=p.getCartId()%>">Remove</a>
					</div>
				</div>
				<br>
				<%
					}
				%>

			</div>
		</div>
		<br><Br>
		<a href="CheckOutServlet" class="btn btn-primary">CheckOut</a>
	</div>



</body>
</html>