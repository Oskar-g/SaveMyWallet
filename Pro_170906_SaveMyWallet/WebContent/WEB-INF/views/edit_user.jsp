<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page -->

<div class="row">
	<div class="col-sm-12">
		<div class="card-box">
			<div class="row">
				<div class="col-lg-6">
					<a href="list_wallet.html">
						<button type="button"
							class="btn btn-primary btn-bordred waves-effect w-md waves-light m-b-5">Volver
							a mis Carteras</button>
					</a><br/><br/>
					<h4 class="m-b-30 m-t-0 header-title">
						<b>${pageTitle} "${user.getName()}"</b>
					</h4>

					<form class="form-horizontal" action="update_user.html"
						method="post">
						<div class="form-group">
							<label class="col-sm-4 control-label">Nombre de usuario</label>
							<div class="col-sm-7">
								<input type="hidden" name="id"
									value="${user.getId()}"> <input
									class="form-control" name="username"
									placeholder="Nombre de usuario"
									value="${user.getUsername()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Nombre</label>
							<div class="col-sm-7">
								<input class="form-control" name="name"
									placeholder="Nombre"
									value="${user.getName()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Apellidos</label>
							<div class="col-sm-7">
								<input class="form-control" name="surname"
									placeholder="Apellidos"
									value="${user.getSurname()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Email</label>
							<div class="col-sm-7">
								<input class="form-control" name="email"
									placeholder="Email"
									value="${user.getEmail()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Contraseña</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" name="password"
									placeholder="Contraseña"
									value="${wallet.getPassword()}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">Confirmar contraseña</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" name="password"
									placeholder="Confirmar contraseña" />
							</div>
						</div><br/>
						<div align="center"><button type="submit"
							class="btn btn-purple waves-effect waves-light">Submit</button>
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