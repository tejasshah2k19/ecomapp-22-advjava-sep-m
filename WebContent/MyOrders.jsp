<%@page import="com.bean.OrderBean"%>
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
<title>My Orders</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<%
		ArrayList<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");
	%>

	<jsp:include page="Header.jsp"></jsp:include>



	<div class="container-fluid">
		<br>
		<div class="Row">
			<div class="col-md-6">
				<table class="table table-bordered table-hover">
					<tr>
						<th>OrderId</th>
						<th>Amount</th>
						<th>OrderDate</th>
						<th>OrderStatus</th>
					</tr>

					<%
						for (OrderBean order : orders) {
					%>
					<tr>
						<td><%=order.getOrderId()%></td>
						<td><%=order.getOrderAmount()%></td>
						<td><%=order.getOrderDate()%></td>
						<td><%=order.getOrderStatus()%></td>

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