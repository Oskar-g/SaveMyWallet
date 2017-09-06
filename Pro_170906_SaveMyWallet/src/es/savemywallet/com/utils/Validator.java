package es.savemywallet.com.utils;

import java.util.regex.Pattern;

public class Validator {

	// array letras DNI
	public static final char[] LetrasDNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
			'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	// pattern verificar Email
	private static final String PatternEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// array verificar numero empleado
	private static final char[] Abecedario = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	// metodo verifica Longitud
	public static boolean verifyLenght(String cadena, int length) {

		boolean isValid = false;

		// La cadena sera valida si no es nula, ni vacia
		// y la longitud es menor o igual a las especificada

		if ((cadena != null) && (!cadena.isEmpty()) && (cadena.length() <= length)) {

			isValid = true;
		}

		return isValid;
	}

	// metodo comprobar un DNI
	public static boolean verityDNI(String dni) {

		boolean isValid = false;

		if ((dni != null) && (!dni.isEmpty())) {

			dni = dni.trim();
			// comprobamos que el dni cimple el patron
			isValid = Pattern.matches("[0-9]{2}.[0-9]{3}.[0-9]{3}-[A-Z]", dni);

			if (isValid) {

				// obtenemos la parte numerica

				int digit = Integer.parseInt(dni.substring(0, 2) + dni.substring(3, 6) + dni.substring(7, 10));

				// comprobamos si la letra es valida
				// posicion de la letra en el String(11)
				isValid = (LetrasDNI[digit % 23] == dni.charAt(11));

			}
		}

		return isValid;
	}

	// metodo para validar Email
	public static boolean verifyEmail(String email) {

		boolean isValid = false;

		if ((email != null) && (!email.isEmpty())) {

			email = email.trim();

			isValid = Pattern.matches(PatternEmail, email);
		}

		return isValid;
	}

	// metodo para validar numero empleado
	public static boolean verificaNumeroEmpleado(String numeroEmpleado) {

		boolean isValid = false;

		if ((numeroEmpleado != null) && (!numeroEmpleado.isEmpty())) {

			numeroEmpleado = numeroEmpleado.trim();

			isValid = Pattern.matches("[0-9]{5}-[A-Z]", numeroEmpleado);

			if (isValid) {

				int dig1 = Integer.parseInt(numeroEmpleado.substring(3, 4));
				int dig2 = Integer.parseInt(numeroEmpleado.substring(4, 5));

				isValid = (Abecedario[(dig1 + dig2) - 1] == numeroEmpleado.charAt(6));
			}
		}

		return isValid;
	}

	public static boolean validateLen(String cadena, int lonMin, int lonMax) {

		boolean valid = false;

		if ((cadena != null) && (cadena.length() >= lonMin) && (cadena.length() <= lonMax)) {

			valid = true;

		}

		return valid;

	}

}
