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
							class="btn btn-primary btn-bordred waves-effect w-md waves-light m-b-5">
							<i class="fa fa-arrow-left" aria-hidden="true"></i> &nbsp; Volver
							a mis movimientos
						</button>
					</a>
					<h4 class="m-b-30 m-t-0 header-title">
						<b>${pageTitle} "${movement.getConcept().getName()}"</b>
					</h4>

					<form class="form-horizontal" action="update_movement.html"
						method="post">
						<div class="form-group">
							<label class="col-sm-4 control-label">Concepto</label>
							<div class="col-sm-7">
								<input type="hidden" name="id" value="${movement.getId()}">
								<input type="hidden" name="wallet_id" value="${wallet.getId()}">
								<input list="concepts" class="form-control" name="concept"
								required maxlength="40"
									placeholder="Concepto" autocomplete="on"
									value="${movement.getConcept().getName()}"
									placeholder="Ej: ingreso de nómina" />
								<datalist id="concepts">
									<c:forEach items="${concepts}" var="concept">
										<option value="${concept.getName()}">
									</c:forEach>
								</datalist>
							</div>
						</div>
						<label class="col-sm-4 control-label">Fecha</label>
						<div class="form-group">
							<div class="col-sm-7">
								<input class="form-control" name="date"
									id="datepicker-autoclose" placeholder="Fecha del movimiento"
									value="${movement.getDate()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Tipo de operación</label>
							<div class="col-sm-7">
								<c:choose>
									<c:when test="${movement.getType()=='ingreso'}">
										<input id="ingreso" type="radio" checked name="type" value="ingreso" /> 
										<label for="ingreso">Ingreso</label>									
										 <br>
										<input id="gasto" type="radio" name="type" value="gasto" /> 						
										<label for="gasto">Gasto</label>									
									</c:when>

									<c:when test="${movement.getType()=='gasto'}">
										<input id="ingreso" type="radio" name="type" value="ingreso" /> Ingreso									
										<label for="ingreso">Ingreso</label>
										<br>
										<input id="gasto" type="radio" checked name="type" value="gasto" /> 
										<label for="gasto">Gasto</label>									
						
									</c:when>
								</c:choose>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Cantidad</label>
							<div class="col-sm-7">
								<input type="number" id="num" step="0.01" min="1" class="form-control" required name="quantity"
									placeholder="Cantidad" value="${movement.getQuantity()}" />
							</div>
							<label class="col-sm-0.5 control-label">&euro;</label>
						</div>
						<br />
						<div align="center">
							<button type="submit"
								class="btn btn-success waves-effect waves-light">
								<i class="fa fa-check-square" aria-hidden="true"></i>&nbsp;
								Editar
							</button>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#datepicker-autoclose").datepicker({
			formatDate : "yyyy-mm-dd",
			format : "yyyy-mm-dd",
			autoclose : true,
			todayHighlight : true
		});
		
		
		if ($('#num').val() == 0)
			$('#num').val(1);
		if ($('#num').val() < 0){			
			var curr = $('#num').val();
			var conv = curr - (curr*2);
			$('#num').val(conv);
		}
	});
</script>