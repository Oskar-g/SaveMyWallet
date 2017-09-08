<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!-- Top Bar Start -->
	<div class="topbar">

		<!-- LOGO -->
		<div class="topbar-left">
			<a href="index.html" class="logo"><img alt="" style="width:80%;" src="assets/images/wallet.png">	<i
				class="zmdi zmdi-layers"></i></a>
		</div>

		<!-- Button mobile view to collapse sidebar menu -->
		<div class="navbar navbar-default" role="navigation">
			<div class="container">

				<!-- Page title -->
				<ul class="nav navbar-nav navbar-left">
					<li>
						<button class="button-menu-mobile open-left">
							<i class="zmdi zmdi-menu"></i>
						</button>
					</li>
					<li>
						<h4 class="page-title">Dashboard</h4>
					</li>
				</ul>

			</div>
			<!-- end container -->
		</div>
		<!-- end navbar -->
	</div>
	<!-- Top Bar End -->


	<!-- ========== Left Sidebar Start ========== -->
	<div class="left side-menu">
		<div class="sidebar-inner slimscrollleft">

			<!-- User -->
			<div class="user-box">
				<div class="user-img">
					<img src="assets/images/users/avatar-3.jpg" alt="user-img"
						title="Mat Helme" class="img-circle img-thumbnail img-responsive">
					<div class="user-status offline">
						<i class="zmdi zmdi-dot-circle"></i>
					</div>
				</div>
				<h5>
					<a href="#">%%Nombre Usuario</a>
				</h5>
				<ul class="list-inline">

					<li><a href="logout.html" class="text-custom"> <i
							class="zmdi zmdi-power"></i>
					</a></li>
				</ul>
			</div>
			<!-- End User -->

			<!--- Sidemenu -->
			<div id="sidebar-menu">
				<ul>
					<li class="text-muted menu-title">Navegación</li>

					<li><a href="index.html" class="waves-effect active"><i
							class="zmdi zmdi-money"></i> <span> Mis Carteras </span> </a></li>

					<li><a href="typography.html" class="waves-effect"><i
							class="zmdi zmdi-account-box"></i> <span> Mi perfil
						</span> </a></li>

					<li><a href="typography.html" class="waves-effect"><i
							class="zmdi zmdi-chart"></i> <span> Movimientos
						</span> </a></li>

					<li><a href="typography.html" class="waves-effect"><i
							class="zmdi zmdi-format-chart"></i> <span> Balance
						</span> </a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<!-- Sidebar -->
			<div class="clearfix"></div>

		</div>

	</div>
	<!-- Left Sidebar End -->
