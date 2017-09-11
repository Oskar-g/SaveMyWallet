package es.savemywallet.web.controllers;

import java.io.IOException;
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
import es.savemywallet.com.interfaces.IMovementService;
import es.savemywallet.com.services.ConceptService;
import es.savemywallet.com.services.MovementService;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class MovementController {

	/*
	 * -------------------------------------------------------------------------
	 * ------- CREATE OBJECT
	 * -------------------------------------------------------------------------
	 * -------
	 */

	@RequestMapping(value = { "/create_movement" })
	public ModelAndView createMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet") int walletId) {

		// - TEMPLATE LOADER
		String view = "create_movement.jsp";
		String title = "Añadir movimiento";
		String menu = "movement";
		String submenu = "create_movement";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);
		modelAndView.addObject("script_datepicker", true);
		
		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		// -CONTROLLER FUNCTIONS
		// --Session
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		modelAndView.addObject("user", user);

		WalletService walletService = new WalletService();
		Wallet wallet = walletService.findByPrimaryIdWallet(walletId);
		modelAndView.addObject("wallet", wallet);
		
		return modelAndView;
	}

	/*
	 * ------------------------------------------------------------------ add
	 * movements
	 * -------------------------------------------------------------------
	 */
	/**
	 * Method new Movement()
	 * 
	 * @param request
	 * @param idWallet
	 * @param nameConcept
	 * @param dateMovementForm
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = "/add_movement", method = RequestMethod.POST)
	public ModelAndView registerMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet_id") int walletId, @RequestParam("concept") String conceptString,
			@RequestParam("type") String type, @RequestParam("date") String dateform,
			@RequestParam("quantity") double quantityForm) {

		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		
		//Date parser
		Date date = new Date();
		if (dateform != null || dateform.trim() != "") {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				date = simpleDateFormat.parse(dateform);
			} catch (Exception ex) {

				ex.printStackTrace();
			}
		}
		
		//Gasto parser
		double quantity = quantityForm;
		if (type.equals("gasto")){
			quantity = quantityForm - (quantityForm*2);
		}
		
		Movement movement = new Movement();
		Concept concept = new Concept(conceptString);
		movement.setWalletId(walletId);
		movement.setConcept(concept);
		movement.setDate(date);
		movement.setType(type);
		movement.setQuantity(quantity);

		IMovementService movementService = new MovementService();
		movementService.addMovement(movement);

		try {

			response.sendRedirect("create_movement.html?wallet=" + walletId);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ------------------------------------------------------------------ EDIT
	 * MOVEMENTS
	 * -------------------------------------------------------------------
	 */

	/**
	 * Edit send form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit_movement", method = RequestMethod.GET)
	public ModelAndView editMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("idMovement") int idMovement) {
		// - TEMPLATE LOADER
		String view = "edit_movement.jsp";
		String title = "Editar Movimiento";
		String menu = "movement";
		String submenu = "create_movement";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);

		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		// -CONTROLLER FUNCTIONS
		// --Session
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		modelAndView.addObject("user", user);

		MovementService movementService = new MovementService();
		Movement movement = movementService.findByPrimaryIdMovement(idMovement);
		modelAndView.addObject("movement", movement);

		return modelAndView;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Update Movement
	 * 
	 * @param request
	 * @param idWallet
	 * @param nameConcept
	 * @param dateMovementForm
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = "/update_movement", method = RequestMethod.POST)
	public ModelAndView editMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet_id") int walletId, @RequestParam("concept") String conceptString,
			@RequestParam("date") String dateMovementForm, @RequestParam("quantity") double quantity) {

		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		// -CONTROLLER FUNCTIONS
		// --Session
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		Concept concept = new Concept(conceptString);

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

		MovementService movementService = new MovementService();
		movementService.updateMovement(movement);

		try {
			response.sendRedirect("list_movement.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * -------------------------------------------------------------------------
	 * ------- DELETE MOVEMENTS
	 * -------------------------------------------------------------------------
	 * -------
	 */

	/**
	 * Delete Movement
	 * 
	 * @param request
	 * @param idMovement
	 */
	@RequestMapping(value = "/delete_movement", method = RequestMethod.GET)
	public ModelAndView deleteteMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet") int walletId, 
			@RequestParam("movement") int id) {

		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		MovementService movementService = new MovementService();
		movementService.deleteMovement(id);

		try {

			response.sendRedirect("list_movement.html?wallet=12");

		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	/*
	 * -------------------------------------------------------------------------
	 * ------- LIST MOVEMENTS
	 * -------------------------------------------------------------------------
	 * -------
	 */

	/**
	 * Listar movements del usuario (requiere estar logueado) Lista los
	 * movements pertenecientes a la id del usuario logueado y las muestra en la
	 * vista
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/list_movement" })
	public ModelAndView listMovement(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet") int idWallet) {

		// -- TEMPLATE LOADER
		String view = "list_movement.jsp";
		String title = "Mis Movimientos";
		String menu = "movement";
		String submenu = "list_movement";

		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);

		// -- Requerir login
		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}

		// -- CONTROLLER FUNCTIONS
		WalletService walletService = new WalletService();
		Wallet wallet = walletService.findByPrimaryIdWallet(idWallet);

		MovementService movementService = new MovementService();
		List<Movement> movements = movementService.listMovement(idWallet);

		modelAndView.addObject("wallet", wallet);
		modelAndView.addObject("movements", movements);

		modelAndView.addObject("script_datatables", true);
		modelAndView.addObject("script_modal", true);
		//-- FIN CONTROLLER FUNCTIONS
		
		return modelAndView;
	}
}
