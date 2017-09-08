<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
				<thead>
					<tr>
						<th>ID WALLET</th>
						<th>ID USER</th>
						<th>NAME WALLET</th>
						<th>DESCRIPTION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="wallet">
						<tr>
							<td><c:out value="${wallet.getIdWallet()}"/></td>
							<td><c:out value="${wallet.getIdUser()}"/></td>
							<td><c:out value="${wallet.getNameWallet()}"/></td>
							<td><c:out value="${wallet.getDescription()}"/></td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
	</body>
</html>