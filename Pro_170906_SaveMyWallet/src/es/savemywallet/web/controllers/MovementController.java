package es.savemywallet.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovementController {

	@RequestMapping(value = "/movement")
	public ModelAndView login() {
		
		String jspfile = "movement";
		return new ModelAndView(jspfile);
	}
	
	
	
	
}
