<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page -->

<div class="row">
	<div class="col-sm-12">
		<div class="card-box">
			<div class="row">
				<div class="col-lg-6">
					<a href="list_movement.html?wallet=${wallet.getId()}">
						<button type="button"
							class="btn btn-primary btn-bordred waves-effect w-md waves-light m-b-5">Volver
							a mis Movimientos</button>
					</a><br/><br/>
					<h4 class="m-b-30 m-t-0 header-title">
						<b>${pageTitle} "${movement.getConcept().getName()}"</b>
					</h4>

					<form class="form-horizontal" action="update_movement.html"
						method="post">
						<div class="form-group">
							<label class="col-sm-4 control-label">Fecha</label>
							<div class="col-sm-7">
								<input type="hidden" name="id"
									value="${movement.getId()}"> <input
									class="form-control" name="date"
									placeholder="Fecha del movimiento"
									value="${movement.getDate()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Concepto</label>
							<div class="col-sm-7">
								<input class="form-control" name="concept"
									placeholder="Concepto"
									value="${movement.getConcept().getName()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Tipo de operación</label>
							<div class="col-sm-7">
								<c:choose>
									<c:when test="${movement.getType()=='ingreso'}">
										<input type="radio" checked name="type" value="ingreso" /> Ingreso									
										 <br> <input type="radio" name="type" value="${movement.getType()}" /> Gasto						

									</c:when>
									
									<c:when test="${movement.getType()=='gasto'}">
										<input type="radio" name="type" value="ingreso" /> Ingreso									
										 <br> <input type="radio" checked name="type" value="${movement.getType()}" /> Gasto						
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Cantidad</label>
							<div class="col-sm-7">
								<input class="form-control" name="quantity"
									placeholder="Cantidad"
									value="${movement.getQuantity()}" />
							</div>
							<label class="col-sm-0.5 control-label">&euro;</label>
						</div>
						<br/>
						<div align="center">
							<button type="submit" class="btn btn-success waves-effect waves-light">Submit</button>
						</div>
						
					</form>
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
	</div>
	<!-- end col -->
</div>
<!-- end row -->