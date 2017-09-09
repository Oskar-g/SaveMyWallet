package es.savemywallet.com.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginStatus {

	public static void get(HttpServletResponse response,HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		
		if (session == null) 
//			|| session.getAttribute("user") == null) 
				{
			try {
				System.out.println("usuario no logueado");
				response.sendRedirect("login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("caca");

		}
	}
}
