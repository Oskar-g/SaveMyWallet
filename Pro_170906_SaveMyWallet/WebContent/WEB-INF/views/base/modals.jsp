<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Modal Wallet -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myLargeModalLabel">Eliminando
					Cartera</h4>
			</div>
			<div class="modal-body">
				<div class="row">Estás apunto de eliminar esta cartera.
					¿Deseas continuar?
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">Cancelar</button>
			<a id="delete_wallet_button">
				<button type="button" class="btn btn-info waves-effect waves-light">
				Aceptar
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
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myLargeModalLabel">Eliminando
					Movimiento</h4>
			</div>
			<div class="modal-body">
				<div class="row">Estás apunto de eliminar este movimiento.
					¿Deseas continuar?
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">Cancelar</button>
				<a id="delete_movement_button">
					<button type="button" class="btn btn-info waves-effect waves-light" >
					Aceptar
					</button>
				</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

