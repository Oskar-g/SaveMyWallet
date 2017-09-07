package es.savemywallet.web.controllers;

import es.savemywallet.com.utils.Item;
import es.savemywallet.com.utils.JSON_Encode;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {

	/*
	 * @RequestMapping(value="/link", method = RequestMethod.POST) public
	 * ModelAndView registrarProducto(@ModelAttribute("dataObject")Object
	 * objeto){ String jspfile = "test"; //Content
	 * 
	 * return new ModelAndView(jspfile); }
	 */

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		//crear wallet
		
		
		String jspfile = "login";
		return new ModelAndView(jspfile);
	}
	
	
	@RequestMapping(value = "/do_login", method = RequestMethod.POST)
	public String doLogin(HttpSession sesion, HttpServletResponse rs, 
	//Aplicar (crear) wallet en base de datos
			
			//name del input
			@RequestParam("user") String user,
			@RequestParam("password") String pass) {

		Map<String, Object> response = new HashMap<String, Object>();

		if (!user.equals("roger") && !pass.equals("trolasho")) {
			response.put("response", "error");
		} else {
			response.put("response", "success");
			response.put("url", "main.html");
		}

		String json = JSON_Encode.parse(response);
		System.out.println(json);
		return json;
	}
}
