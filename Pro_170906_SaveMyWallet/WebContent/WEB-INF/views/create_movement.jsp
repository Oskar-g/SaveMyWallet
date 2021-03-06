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
					</a> <a href="list_wallet.html">
						<button type="button"
							class="btn btn-custom btn-bordred waves-effect w-md waves-light m-b-5">
							<i class="fa fa-list-alt" aria-hidden="true"></i> &nbsp; Volver a
							mis Carteras
						</button>
					</a><br /> <br />
					<h4 class="m-b-30 m-t-0 header-title">
						<b>${pageTitle} a la cartera ${wallet.getName()}</b>
					</h4>
					<form class="form-horizontal" action="add_movement.html"
						method="post">
						<div class="form-group">
							<input type="hidden" name="wallet_id" value="${wallet.getId()}">
							<label class="col-sm-4 control-label">Concepto</label>
							<div class="col-sm-7">
								<input list="concepts" required maxlength="40" name="concept"
									class="form-control" autocomplete="off"
									placeholder="Ej: ingreso de n�mina">
								<datalist id="concepts">
									<c:forEach items="${concepts}" var="concept">
										<option value="${concept.getName()}">
									</c:forEach>
								</datalist>
							</div>

						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Tipo de operacion</label>
							<div class="col-sm-7">
								<input id="ingreso" type="radio" checked name="type"
									value="ingreso" /> <label for="ingreso">Ingreso</label> <br>
								<input id="gasto" type="radio" name="type" value="gasto" /> <label
									for="gasto">Gasto</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Fecha</label>
							<div class="col-sm-7">
								<input type="text" name="date" class="form-control"
									placeholder="YYYY-MM-DD" id="datepicker-autoclose" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Cantidad</label>
							<div class="col-sm-7">
								<input type="number" id="num" min="1" step="0.01" required
									class="form-control" name="quantity" />
							</div>
							<label class="col-sm-0.5 control-label">&euro;</label>

						</div>
						<div align="center">
							<button type="submit"
								class="btn btn-success waves-effect waves-light">
								<i class="fa fa-plus-square" aria-hidden="true"></i>&nbsp;
								Agregar
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
	});
</script>