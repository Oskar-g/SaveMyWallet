package es.savemywallet.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.services.MovementService;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.TemplateLoader;


@Controller
public class MovementController {

	
	@ModelAttribute("dataMovement")
	public Movement movement() {
		
		return new Movement();
	}
	
	@RequestMapping(value = {"/movement","/","/list_movement"})
	public ModelAndView listMovement(HttpServletRequest request) {
		
		//-- TEMPLATE LOADER
		String view = "list_wallet.jsp";
		String title = "Mis Movimientos";
		String menu = "movement";
		String submenu = "list_movement";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);	
		//-- FIN TEMPLATE LOADER
	
		//-- CONTROLLER FUNCTIONS			
		MovementService movementService = new MovementService();
		List<Movement> list = movementService.listMovement();
	
		modelAndView.addObject("list", list);
		//-- FIN CONTROLLER FUNCTIONS
		
		return modelAndView;
	}

	
	/*
	 * add movements
	 */
	
	/**
	 * Method registerWallet()
	 * @param request
	 * @param idWallet
	 * @param nameConcept
	 * @param dateMovementForm
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = "/add_movement", method = RequestMethod.POST)
	public ModelAndView registerMovement(HttpServletRequest request, @RequestParam("id_wallet") int idWallet, 
			@RequestParam("name_concept") String nameConcept, @RequestParam("date_movement") String dateMovementForm,
			@RequestParam("quantity") double quantity){
		
		String jspTemplate = "base";
		String jspContent = "registerMovement.jsp";
		String pageTitle = "Nuevo Movimiento";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		MovementService movementService = new MovementService();
		Movement movement = new Movement();
		movement.setIdWallet(idWallet);
		movement.setNameConcept(nameConcept);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateMovement = null;
			try {
	
				dateMovement = simpleDateFormat.parse(dateMovementForm);
	
			} catch (Exception ex) {
	
				ex.printStackTrace();
			}
		
		movement.setDateMovement(dateMovement);
		movement.setQuantity(quantity);
		movementService.addMovement(movement);
		
		return new ModelAndView("movement");
	}
	
	/*
	 * add movements fin
	 */
	
	/*
	 * update movements
	 */
	
	/**
	 * Method updateMovement()
	 * @param request
	 * @param idWallet
	 * @param nameConcept
	 * @param dateMovementForm
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = "/update_movement", method = RequestMethod.POST)
	public ModelAndView updateMovement(HttpServletRequest request, @RequestParam("id_wallet") int idWallet, 
			@RequestParam("name_concept") String nameConcept, @RequestParam("date_movement") String dateMovementForm,
			@RequestParam("quantity") double quantity){
		
		String jspTemplate = "base";
		String jspContent = "editMovement.jsp";
		String pageTitle = "Modificar Movimiento";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		MovementService movementService = new MovementService();
		Movement movement = new Movement();
		movement.setIdWallet(idWallet);
		movement.setNameConcept(nameConcept);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateMovement = null;
			try {
	
				dateMovement = simpleDateFormat.parse(dateMovementForm);
	
			} catch (Exception ex) {
	
				ex.printStackTrace();
			}
		
		movement.setDateMovement(dateMovement);
		movement.setQuantity(quantity);
		movementService.updateMovement(movement);
		
		return new ModelAndView("movement");
	}
	
	/*
	 * update movements fin
	 */
	
	/*
	 * delete movements
	 */
	
	/**
	 * Method deleteteWallet()
	 * @param request
	 * @param idMovement
	 */
	@RequestMapping(value = "/delete_movement", method = RequestMethod.POST)
	public void deleteteMovement(HttpServletRequest request,
			@RequestParam("id_movement") int idMovement){
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		MovementService movementService = new MovementService();
		movementService.deleteMovement(idMovement); 
	}
	
	/*
	 * delete movements fin
	 */
}
