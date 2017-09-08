package es.savemywallet.com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;

public class TemplateLoader {

	public static ModelAndView start(HttpServletRequest request,String view,String title,String menu, String submenu){
		ModelAndView modelAndView = new ModelAndView("base");		

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		modelAndView.addObject("user", user);
						
		modelAndView.addObject("pageTitle", title);
		modelAndView.addObject("menuSelect", menu);
		modelAndView.addObject("subMenuSelect", submenu);
		modelAndView.addObject("jspContent", view);
		
		return modelAndView;
	}
	
	
}
