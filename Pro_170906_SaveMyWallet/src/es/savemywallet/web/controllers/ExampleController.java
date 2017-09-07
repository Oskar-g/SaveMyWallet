package es.savemywallet.web.controllers;

import es.savemywallet.com.utils.JSON_Encode;

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

@Controller
public class ExampleController {

	
	@RequestMapping(value = "/main")
	public ModelAndView index() {
		String jspfile = "test";
		// Content

		return new ModelAndView(jspfile);
	}
}
