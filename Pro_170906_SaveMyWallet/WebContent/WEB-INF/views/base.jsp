<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="base/head.jsp"></jsp:include>
</head>
<body class="fixed-left">
<div id="wrapper">


<jsp:include page="base/left_menu.jsp"></jsp:include>

	<div class="content-page">
		<!-- Start content -->
		<div class="content">
			<div class="container">

				<jsp:include page="${jspContent}"></jsp:include>
	
		</div>
		

		</div>
		<footer class="footer text-right"> 2016 © Adminto. </footer>

	</div>

	<jsp:include page="base/footer.jsp"></jsp:include>

	<jsp:include page="base/scripts.jsp"></jsp:include>
</body>	
</html>