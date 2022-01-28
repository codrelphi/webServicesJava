<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de Produits</title>
</head>
<body>
	<h1>Gestion de produits avec SOAP Web Service</h1>
	
	<table border="1px">
		<tr>
			<th>Code</th>
			<th>Description</th>
			<th>Prix</th>
		</tr>
		<c:forEach items="${listeDesProduits }" var="p">
			<tr>
				<td><c:out value="${p.code }"></c:out></td>
				<td><c:out value="${p.description }"></c:out></td>
				<td><c:out value="${p.prix }"></c:out></td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>