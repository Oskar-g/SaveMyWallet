<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- Begin page -->




<div class="row">
	<div class="col-sm-12">
		<div class="card-box table-responsive">
			<!-- 
                                    <div class="dropdown pull-right">
                                        <a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown" aria-expanded="false">
                                            <i class="zmdi zmdi-more-vert"></i>
                                        </a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                        </ul>
                                    </div>
                                 -->


			<a href="create_movement.html?wallet=${wallet.getId()}">
				<button type="button"
					class="btn btn-success btn-bordred waves-effect w-md waves-light m-b-5">Agregar
					movimiento</button>
			</a> <a href="list_wallet.html">
				<button type="button"
					class="btn btn-primary btn-bordred waves-effect w-md waves-light m-b-5">Volver
					a mis Carteras</button>
			</a><br/><br/>
			<h4 class="header-title m-t-0 m-b-30">Movimientos de la Cartera "${wallet.getName()}"</h4>

			<table id="datatable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Concepto</th>
						<th>Tipo</th>
						<th>Cantidad</th>
						<th>Operaciones</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${movements}" var="movement">
						<tr>
							<td><fmt:formatDate pattern="dd/MM/yyyy"
									value="${movement.getDate()}" /></td>
							<td>${movement.getConcept().getName()}</td>
							<td>${movement.getType()}</td>
							<c:choose>
								<c:when test="${movement.getType() == 'ingreso'}">
									<td style="color: green;">${movement.getQuantity()}</td>
								</c:when>
								<c:when test="${movement.getType() == 'gasto'}">
									<td style="color: red;">${movement.getQuantity()}</td>
								</c:when>
							</c:choose>
							<td>
							 <button class="btn btn-icon waves-effect waves-light btn-danger m-b-5"  data-toggle="modal" data-target="#dropMovement">
							 	<i class="fa fa-remove"></i>
							 </button>
							<a href="edit_movement.html?idMovement=${movement.getIdMovement()}">
								<button class="btn btn-icon waves-effect waves-light btn-primary m-b-5" data-toggle="modal" data-target="#con-close-modal"><i class="fa fa-wrench"></i></button>
							</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- end col -->
</div>
<!-- end row -->

<script type="text/javascript">
	jQuery(document).ready(function() {
		$('#datatable').dataTable();
	});
</script>

