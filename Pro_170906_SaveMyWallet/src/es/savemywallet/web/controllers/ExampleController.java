package es.savemywallet.web.controllers;

	import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

	
	@Controller
	public class ExampleController {
		
		@ModelAttribute("dataObject")
		public Object nameFunct(){
			return new Object();
		}
		
/*		
		@RequestMapping(value="/link", method = RequestMethod.POST)
		public ModelAndView registrarProducto(@ModelAttribute("dataObject")Object objeto){
			String jspfile = "test";
			//Content
			
			return new ModelAndView(jspfile);
		}
	*/	
		@RequestMapping(value="/main")
		public ModelAndView index(){
			String jspfile = "test";
			//Content
			
			return new ModelAndView(jspfile);
		}
	
		@RequestMapping(value="/login")
		public String login(){
			String text = "asdasd";
				return text;
		}
}
