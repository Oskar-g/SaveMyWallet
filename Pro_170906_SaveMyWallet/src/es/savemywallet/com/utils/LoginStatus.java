package es.savemywallet.com.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginStatus {

	public static boolean get(HttpServletResponse response, HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		if (session.getAttribute("user") == null) {
			try {
				System.out.println("usuario no logueado");
				response.sendRedirect("login.html");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static Object[] gete(HttpServletResponse response, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		Object result[];
		if (session.getAttribute("user") == null) {
			try {
				System.out.println("usuario no logueado");
				response.sendRedirect("login.html");
				result = new Object[]{false,response};
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new Object[]{true};
	}
}
