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
					¿Deseas continuar?</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">Cancelar</button>
				<a id="delete_wallet_button">
					<button type="button" class="btn btn-info waves-effect waves-light">
						Aceptar</button>
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
					¿Deseas continuar?</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">Cancelar</button>
				<a id="delete_movement_button">
					<button type="button" class="btn btn-info waves-effect waves-light">
						Aceptar</button>
				</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->





<!-- sample modal content -->
<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Modal Heading</h4>
			</div>
			<div class="modal-body">
				<h4>Text in a modal</h4>
				<p>Duis mollis, est non commodo luctus, nisi erat porttitor
					ligula.</p>
				<hr>
				<h4>Overflowing text to show scroll behavior</h4>
				<p>Cras mattis consectetur purus sit amet fermentum. Cras justo
					odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus,
					porta ac consectetur ac, vestibulum at eros.</p>
				<p>Praesent commodo cursus magna, vel scelerisque nisl
					consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum
					faucibus dolor auctor.</p>
				<p>Aenean lacinia bibendum nulla sed consectetur. Praesent
					commodo cursus magna, vel scelerisque nisl consectetur et. Donec
					sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
				<p>Cras mattis consectetur purus sit amet fermentum. Cras justo
					odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus,
					porta ac consectetur ac, vestibulum at eros.</p>
				<p>Praesent commodo cursus magna, vel scelerisque nisl
					consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum
					faucibus dolor auctor.</p>
				<p>Aenean lacinia bibendum nulla sed consectetur. Praesent
					commodo cursus magna, vel scelerisque nisl consectetur et. Donec
					sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
				<p>Cras mattis consectetur purus sit amet fermentum. Cras justo
					odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus,
					porta ac consectetur ac, vestibulum at eros.</p>
				<p>Praesent commodo cursus magna, vel scelerisque nisl
					consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum
					faucibus dolor auctor.</p>
				<p>Aenean lacinia bibendum nulla sed consectetur. Praesent
					commodo cursus magna, vel scelerisque nisl consectetur et. Donec
					sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					data-dismiss="modal">Close</button>
				<button type="button"
					class="btn btn-primary waves-effect waves-light">Save
					changes</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
