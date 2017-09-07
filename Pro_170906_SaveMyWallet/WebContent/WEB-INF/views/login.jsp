<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SaveMyWallet | Login</title>


<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="assets/css/custom.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

<body>
	<div class="login-form">
		<h1>Save My Wallet</h1>
		<div class="form-group ">
			<input type="text" class="form-control" placeholder="nombre o correo"
				name="user" id="UserName"> <i class="fa fa-user"></i>
		</div>
		<div class="form-group log-status">
			<input type="password" class="form-control" placeholder="Password"
				name="password" id="Passwod"> <i class="fa fa-lock"></i>
		</div>
		<span class="alert">Credenciales inválidos</span> <a class="link"
			href="#">¿Olvidaste la contraseña?</a>
		<button type="button" class="log-btn" onclick="login()">Log in</button>
	</div>
	<script src="assets/js/custom.js"></script>

</body>
</html>
