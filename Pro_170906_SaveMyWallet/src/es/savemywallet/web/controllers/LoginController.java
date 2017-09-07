package es.savemywallet.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.interfaces.IUserService;
import es.savemywallet.com.services.UserService;
import es.savemywallet.com.utils.JSON_Encode;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		
		String jspfile = "login";
		return new ModelAndView(jspfile);
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView login(HttpSession sesion, HttpServletResponse rs) {
		
		//Destroy session aqui
		String jspfile = "login";
		return new ModelAndView(jspfile);
	}
	
	@RequestMapping(value = "/do_login", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String doLogin(HttpSession sesion, HttpServletResponse response, HttpServletRequest request,
			@RequestParam("user") String userForm,
			@RequestParam("password") String passForm) {
		
		HttpSession session = request.getSession(true);
		/*
		if (session != null){
			try {
				response.sendRedirect("main");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
			
		Map<String, Object> responseJSON = new HashMap<String, Object>();

		IUserService userService = new UserService();
		
		User user = userService.findUser(userForm, passForm);
		
		if(user == null){
			//No se encontró el usuario
			responseJSON.put("response", "error");
			responseJSON.put("debug", user);
		}else {
			//Generar sesion usuario
			session.setAttribute("user", user);
			
			responseJSON.put("response", "success");
			responseJSON.put("url", "main.html");
		}
		
		return JSON_Encode.parse(responseJSON);
	}
}