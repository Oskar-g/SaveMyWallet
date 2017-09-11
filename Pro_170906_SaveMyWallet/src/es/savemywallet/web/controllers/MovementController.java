package es.savemywallet.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.services.ConceptService;
import es.savemywallet.com.services.MovementService;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;


@Controller
public class MovementController {

	
	@RequestMapping(value = { "/create_movement" })
	public ModelAndView createWallet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet") int idWallet){
		
		//- TEMPLATE LOADER
		String view = "create_movement.jsp";
		String title = "Añadir movimiento";
		String menu = "movement";
		String submenu = "create_movement";
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
		
		WalletService walletService = new WalletService();
		Wallet wallet = walletService.findByPrimaryIdWallet(idWallet);
		modelAndView.addObject("wallet", wallet);
			
		ConceptService conceptService = new ConceptService();
		List<Concept> concepts = conceptService.listConcept();
		modelAndView.addObject("concepts", concepts);
	
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = {"/list_movement"})
	public ModelAndView listMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam ("wallet") int idWallet) {
		
		//-- TEMPLATE LOADER
		String view = "list_movement.jsp";
		String title = "Mis Movimientos";
		String menu = "movement";
		String submenu = "list_movement";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);	
		modelAndView.addObject("script_datatables",true);

		//-- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}
		
		//-- CONTROLLER FUNCTIONS			
		WalletService walletService = new WalletService();
		Wallet wallet = walletService.findByPrimaryIdWallet(idWallet);
		
		MovementService movementService = new MovementService();
		List<Movement> movements = movementService.listMovement(idWallet);
	

		modelAndView.addObject("wallet", wallet);
		modelAndView.addObject("movements", movements);
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
	public ModelAndView registerMovement(HttpServletRequest request, @RequestParam("wallet_id") int walletId, 
			@RequestParam("concept") String conceptString, @RequestParam("date") String dateMovementForm,
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
		Concept concept = new Concept(conceptString);
		movement.setWalletId(walletId);
		movement.setConcept(concept);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
			try {
	
				date = simpleDateFormat.parse(dateMovementForm);
	
			} catch (Exception ex) {
	
				ex.printStackTrace();
			}
		
		movement.setDate(date);
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
	public ModelAndView updateMovement(HttpServletRequest request, @RequestParam("wallet_id") int walletId, 
			@RequestParam("concept") String conceptString, @RequestParam("date") String dateMovementForm,
			@RequestParam("quantity") double quantity){
		
		String jspTemplate = "base";
		String jspContent = "editMovement.jsp";
		String pageTitle = "Modificar Movimiento";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		Concept concept = new Concept(conceptString);
		MovementService movementService = new MovementService();
		Movement movement = new Movement();
		movement.setWalletId(walletId);
		movement.setConcept(concept);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
			try {
	
				date = simpleDateFormat.parse(dateMovementForm);
	
			} catch (Exception ex) {
	
				ex.printStackTrace();
			}
		
		movement.setDate(date);
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
