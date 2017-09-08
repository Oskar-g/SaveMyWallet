<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Begin page -->


		
<div class="row">
	<c:forEach items="${list}" var="wallet">
	<div class="col-sm-12">
		<div class="card-box">
			<div class="row">
				<div class="col-lg-6">
					<h4 class="m-b-30 m-t-0 header-title"><b>Editar Cartera</b></h4>
					<form class="form-horizontal" action="edit_wallet.html" method="post">
						<div class="form-group">
							<label class="col-sm-5 control-label">Nombre</label>
							<div class="col-sm-7">
								<a href="#" id="inline-username" data-type="text" data-pk="1" data-title="Enter username" name="name_wallet">${wallet.getNameWallet()}</a>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-5 control-label">Descripción<i>ctrl+enter</i></label>
							<div class="col-sm-7">
								<a href="#" id="inline-comments" data-type="textarea" data-pk="1" data-placeholder="Your comments here..." data-title="Enter comments" name="description">${wallet.getDescription()}</a>
							</div>
						</div>
					</form>
				</div><!-- end col -->
			</div><!-- end row -->
		</div>
	</div><!-- end col -->
	</c:forEach>
</div>
<!-- end row -->


	<!--<form:form method="post" action="do_wallet.html">
			<h1>Formulario con datos del wallet</h1>
			<table>
				<tbody>
					<tr>
						<td>Name:</td>
						<td><input name="nameWallet" />
						</td>
					</tr>
	                <tr>
						<td>Descripción:</td>
						<td><input name="descriptionWallet"/></td>
					</tr>					
					<tr>
						<td colspan="3"><input type="submit" value="Enviar" />
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>-->