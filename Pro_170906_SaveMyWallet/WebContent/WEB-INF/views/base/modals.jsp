<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Modal Wallet -->
<div id="dropWallet" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog modal-mg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myLargeModalLabel">Eliminando
					Cartera</h4>
			</div>
			<div class="modal-body">
				<div class="row text-center"><span class="text-danger">Estás apunto de eliminar esta
					cartera.</span> ¿Deseas continuar?</div>
			</div>
			<div class="modal-footer" style="text-align:center;">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">
					<i class="fa fa-remove" aria-hidden="true"></i> &nbsp; Cancelar
				</button>
				<a id="delete_wallet_button">
					<button type="button "
						class="btn btn-danger waves-effect waves-light">
						<i class="fa fa-check" aria-hidden="true"></i> &nbsp; Aceptar
					</button>
				</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!--Modal Movement -->
<div id="dropMovement" class="modal fade bs-example-modal-lg"
	tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
	aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-mg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myLargeModalLabel">Eliminando
					Movimiento</h4>
			</div>
			<div class="modal-body">
				<div class="row text-center"><span class="text-danger">Estás apunto de eliminar este
					movimiento.</span> ¿Deseas continuar?</div>
			</div>
			<div class="modal-footer" style="text-align:center;">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">
					<i class="fa fa-remove" aria-hidden="true"></i> &nbsp; Cancelar
				</button>

				<a id="delete_movement_button">
					<button type="button "
						class="btn btn-danger waves-effect waves-light">
						<i class="fa fa-check" aria-hidden="true"></i> &nbsp; Aceptar
					</button>
				</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



