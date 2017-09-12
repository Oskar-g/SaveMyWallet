<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin page -->


<div class="row">
	<div class="col-sm-12">
		<a href="create_wallet.html">
			<button type="button"
				class="btn btn-success btn-bordred waves-effect w-md waves-light m-b-5"><i class="fa fa-plus-square" aria-hidden="true"></i>&nbsp; Añadir
				Cartera</button>
		</a><br/><br/>
	</div>
	<c:forEach items="${list}" var="wallet">
		<div class="col-lg-3 col-md-6">
			<div class="card-box clicable_item">
				<div class="dropdown pull-right">
					<a href="#" class="dropdown-toggle card-drop"
						data-toggle="dropdown" aria-expanded="false">&nbsp;&nbsp; <i
						class="zmdi zmdi-more-vert"></i>&nbsp;&nbsp;
					</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-wallet"><a
							href="list_movement.html?wallet=${wallet.getId()}"><i class="fa fa-line-chart" aria-hidden="true"></i>&nbsp;&nbsp;Ver
								movimientos</a></li>
						<li class="dropdown-wallet"><a
							href="edit_wallet.html?idWallet=${wallet.getId()}"><i class="fa fa-pencil-square" aria-hidden="true"></i>&nbsp;&nbsp;Editar</a></li>
						<li class="divider"></li>
						<li class="dropdown-wallet btn-del" data-toggle="modal" data-target="#dropWallet" data_identifier="${wallet.getId()}"><a><i class="fa fa-close" aria-hidden="true"></i>&nbsp;&nbsp;Eliminar</a></li>
					</ul>
				</div>
				<div
					onclick="window.location.replace('list_movement.html?wallet=${wallet.getId()}')">
					<h4 class="header-title m-t-0 m-b-30">${wallet.getName()}</h4>
					<p class="header-title m-t-0 m-b-30">${wallet.getDescription()}</p>

					<div class="widget-box-2">
						<div class="widget-detail-2">
							<!-- 
							<span class="badge badge-success pull-left m-t-20">34% <i
								class="zmdi zmdi-trending-up"></i>
							</span>
							 -->
							 <c:choose>
								<c:when test="${wallet.getBalance()>0}">
									<h2 class="m-b-0 text-success">${wallet.getBalance()} &euro;</h2>
								</c:when>
								<c:otherwise>
									<h2 class="m-b-0 text-danger">${wallet.getBalance()} &euro;</h2>
								</c:otherwise>
							 </c:choose>

							<p class="text-muted m-b-25">Saldo Actual</p>
						</div>
						<div class="progress progress-bar-success-alt progress-sm m-b-0">

							 <c:choose>
								<c:when test="${wallet.getBalance()>0}">
									<div class="progress-bar progress-bar-success" role="progressbar"
										aria-valuenow="34" aria-valuemin="0" aria-valuemax="100"
										style="width: 100%;">
									</div>									
								</c:when>
								<c:otherwise>
									<div class="progress-bar progress-bar-danger" role="progressbar"
										aria-valuenow="34" aria-valuemin="0" aria-valuemax="100"
										style="width: 100%;">
									</div>									
								</c:otherwise>
							 </c:choose>


						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<!-- end col -->
</div>
<!-- end row -->

<script type="text/javascript">
	$(document).ready(function() {
		//Listener de clic en botones
		$(".btn-del").on("click", function() {
			var wallet = $(this).attr("data_identifier");
			var location = "delete_wallet.html?id=" + wallet;
			$("#delete_wallet_button").attr("href", location);
		});
	});
</script>

