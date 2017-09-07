	// ------------------------ // LOGIN SCRIPTS // ------------------------ // 
	
	// Limpiar estilo erróneo al pulsar teclas en el fomr
	$('.form-control').keypress(function() {
		$('.log-status').removeClass('wrong-entry');
	});
	
	// Efectuar movimiento de error
	function wrong_login() {
		$('.log-status').addClass('wrong-entry');
		$('.alert').fadeIn(500);
		setTimeout("$('.alert').fadeOut(1500);", 3000);
	}

	function login() {
    	var user = $('#UserName').val();
    	var password = $('#Passwod').val();
    	
        $.ajax({
            url: 'do_login.html',
            dataType: 'json',
            data:{
            	user: user,
            	password: password
            	},
            type: "get",
            success: function (json) {
            	console.log(json);
            	if (json.response == "success")
            		window.location.replace(json.url);
            	
           		wrong_login();
           		return false;
            },
            error: function (response) {
            	console.log(response);
                alert("No se han podido iniciar sesión, no se ha conectado con el servidor...");               
            }
        });
    }