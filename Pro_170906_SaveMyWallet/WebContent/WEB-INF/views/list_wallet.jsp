<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin page -->


<div class="row">
	<c:forEach items="${list}" var="wallet">
	<div class="col-lg-3 col-md-6">
		<div class="card-box">
			<div class="dropdown pull-right">
				<a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown"
					aria-expanded="false"> <i class="zmdi zmdi-more-vert"></i>
				</a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Ver movimientos</a></li>
					<li><a href="edit_wallet.html?idWallet=${wallet.getIdWallet()}">Editar</a></li>
					<li class="divider"></li>
					<li><a href="delete_wallet.html?idWallet=${wallet.getIdWallet()}">Eliminar</a></li>
				</ul>
			</div>
									
			<h4 class="header-title m-t-0 m-b-30">${wallet.getNameWallet()}</h4>
			<p class="header-title m-t-0 m-b-30">${wallet.getDescription()}</p>
			
			<div class="widget-box-2">
				<div class="widget-detail-2">
					<span class="badge badge-success pull-left m-t-20">34% <i
						class="zmdi zmdi-trending-up"></i>
					</span>
					<h2 class="m-b-0">345</h2>
					<p class="text-muted m-b-25">Ingresos este mes</p>
				</div>
				<div class="progress progress-bar-success-alt progress-sm m-b-0">
					<div class="progress-bar progress-bar-success" role="progressbar"
						aria-valuenow="34" aria-valuemin="0" aria-valuemax="100"
						style="width: 34%;">
						<span class="sr-only">34% diferencia</span>
					</div>
				</div>
			</div>	
		</div>
	</div>
	</c:forEach>
	<!-- end col -->
</div>
<!-- end row -->

