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


$(document).ready(function() {
    $('#loginForm').on('submit', function(e) {
            e.preventDefault();

            // Use Ajax to submit form data
            $.ajax({
                url: $('#loginForm').attr('action'),
                type: 'GET',
                data: $('#loginForm').serialize(),
                dataType: "json",
        		beforeSend: function(){
        			$('#loader').show();
        		},
        		success : function(json) {
        			console.log(json)
        			if (json.response == "success"){	
        				window.location.replace(json.url);
        				return true;
        			}
        			else {
        				wrong_login();
            			$('#loader').hide();
        				return false;
        			}
        		},
        		error : function(response) {
        			alert("No se han podido iniciar sesión, no se ha conectado con el servidor...");
        			return false;
        		},
            });
        });
});