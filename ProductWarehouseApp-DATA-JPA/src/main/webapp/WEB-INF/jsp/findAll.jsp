<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All products</h1>
	<span>${msg}</span>
	<table>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Cost</th>
		</tr>
		<c:forEach items="${products}" var="product">
		<tr>
		    <td><c:out value="${product.pid}"></c:out></td>
		    <td><c:out value="${product.pname}"></c:out></td>
		    <td><c:out value="${product.pcost}"></c:out></td>
		    <td><a href="./deleteById?pid=${product.pid}">Delete</a></td>
		    <td><a href="./update?pid=${product.pid}">Update</a></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>