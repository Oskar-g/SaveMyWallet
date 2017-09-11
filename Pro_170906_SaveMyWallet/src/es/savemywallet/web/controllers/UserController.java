package es.savemywallet.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.services.UserService;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class UserController {

	/*
	 * --------------------------------------------------------------------------------
	 * CREATE OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * Crear user (FORMULARIO)
	 * (requiere estar logueado)
	 * Abre la vista de formulario para añadir una nueva user
	 * 
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 * 
	 * @return 			ModelAndView
	 */
	@RequestMapping(value = { "/create_user" })
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response){
		
		//- TEMPLATE LOADER
		String view = "create_user.jsp";
		String title = "Registrar usuario";
		String menu = "user";
		String submenu = "create_user";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);
			
		return modelAndView;
	}
	

	// --------------------------------------------------------------------------------
	 
	/**
	 * Register new user
	 * 
	 * @param request
	 * @param nameUser
	 * @param descriptionUser
	 * @return
	 */
	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("username") String username,
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("password") String password,
			@RequestParam("email") String email) {
		
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(password);
		
		UserService userService = new UserService();
		userService.addUser(user);

		try {
			response.sendRedirect("login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 * --------------------------------------------------------------------------------
	 * EDIT OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * Edit send form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit_user", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("idUser") int idUser) {
		//- TEMPLATE LOADER
		String view = "edit_user.jsp";
		String title = "Editar Cartera";
		String menu = "user";
		String submenu = "create_user";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);
	
		//-- Requerir login
			Object[] loginStatus = LoginStatus.gete(response, request);
			if (!(boolean) loginStatus[0]) {
				response = (HttpServletResponse) loginStatus[1];
				return null;
			}
	
	//-CONTROLLER FUNCTIONS
		//--Session
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("user");
			modelAndView.addObject("user", user);

		UserService userService = new UserService();
		User newUser = userService.findByPrimaryIdUSer(user.getId());	
		modelAndView.addObject("user", user);
		modelAndView.addObject("newUser", newUser);
			
		return modelAndView;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Update user
	 * 
	 * @param request
	 * @param nameUser
	 * @param descriptionUser
	 * @return
	 */
	@RequestMapping(value = "/update_user", method = RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") int idUser,
			@RequestParam("username") String username,
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("password") String password,
			@RequestParam("email") String email) {
		
		//-- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}
		
		//-CONTROLLER FUNCTIONS
			//--Session
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("user");
		
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setName(name);
		newUser.setUsername(username);
		newUser.setSurname(surname);
		newUser.setPassword(password);
		newUser.setEmail(email);
		UserService userService = new UserService();
		userService.updateUser(user);
		
		session.setAttribute("user", newUser);
		
		try {
			response.sendRedirect("edit_user.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
