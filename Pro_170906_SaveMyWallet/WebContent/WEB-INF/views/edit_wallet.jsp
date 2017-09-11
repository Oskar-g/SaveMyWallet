<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page -->

<div class="row">
	<div class="col-sm-12">
		<div class="card-box">
			<div class="row">
				<div class="col-lg-6">
					<h4 class="m-b-30 m-t-0 header-title">
						<b>${pageTitle} " ${wallet.getNameWallet()}"</b>
					</h4>
					<form class="form-horizontal" action="update_wallet.html"
						method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">Nombre</label>
							<div class="col-sm-10">
								<input type="hidden" name="id_wallet" value="${wallet.getIdWallet()}">
								<input class="form-control" name="name_wallet"
									placeholder="Nombre de la cartera" 
									value="${wallet.getNameWallet()}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Descripción</label>
							<div class="col-sm-10">
								<textarea class="form-control" name="description" rows="5"
									placeholder="Decripción representativa de esta cartera">${wallet.getDescription()}</textarea>
							</div>
						</div>
						<button type="submit"
							class="btn btn-purple waves-effect waves-light">Submit</button>
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