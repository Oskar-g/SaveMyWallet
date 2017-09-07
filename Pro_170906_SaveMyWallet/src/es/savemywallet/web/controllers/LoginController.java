package es.savemywallet.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.utils.JSON_Encode;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		String jspfile = "login";
		return new ModelAndView(jspfile);
	}
	
	@RequestMapping(value = "/do_login", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String doLogin(HttpSession sesion, HttpServletResponse rs, 
			@RequestParam("user") String user,
			@RequestParam("password") String pass) {

		Map<String, Object> response = new HashMap<String, Object>();

		
		//Sustituir este if con un si el usuario encontrado con el dao es null
		if (!user.equals("roger") && !pass.equals("trolasho")) {
			response.put("response", "error");

		
		
		} else {
			response.put("response", "success");
			response.put("url", "main.html");
			//Generar sesion usuario
		}

		String json = JSON_Encode.parse(response);
		System.out.println(json);
		return json;
	}
}
