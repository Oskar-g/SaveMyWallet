<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="do_wallet.html">
			<h1>Formulario con datos del wallet</h1>
			<table>
				<tbody>
					<tr>
						<td>Name:</td>
						<td><input name="nameWallet" />
						</td>
					</tr>
	                <tr>
						<td>Descripción:</td>
						<td><input name="descriptionWallet"/></td>
					</tr>					
					<tr>
						<td colspan="3"><input type="submit" value="Enviar" />
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
</body>
</html>