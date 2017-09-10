package es.savemywallet.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class WalletController {

	/*
	 * --------------------------------------------------------------------------------
	 * CREATE OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * Crear wallet (FORMULARIO)
	 * (requiere estar logueado)
	 * Abre la vista de formulario para añadir una nueva wallet
	 * 
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 * 
	 * @return 			ModelAndView
	 */
	@RequestMapping(value = { "/create_wallet" })
	public ModelAndView createWallet(HttpServletRequest request, HttpServletResponse response){
		
		//- TEMPLATE LOADER
		String view = "create_wallet.jsp";
		String title = "Crear Cartera";
		String menu = "wallet";
		String submenu = "create_wallet";
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
			
		return modelAndView;
	}
	

	// --------------------------------------------------------------------------------
	 
	/**
	 * Register new wallet
	 * 
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/add_wallet", method = RequestMethod.POST)
	public ModelAndView addWallet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("name_wallet") String nameWallet,
			@RequestParam("description") String descriptionWallet) {
		
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
		
		Wallet wallet = new Wallet();
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(descriptionWallet);
		
		WalletService walletService = new WalletService();
		walletService.addWallet(wallet);

		try {
			response.sendRedirect("create_wallet.html");
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
	@RequestMapping(value = "/edit_wallet", method = RequestMethod.GET)
	public ModelAndView editWallet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("idWallet") int idWallet) {
		//- TEMPLATE LOADER
		String view = "edit_wallet.jsp";
		String title = "Editar Cartera";
		String menu = "wallet";
		String submenu = "create_wallet";
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
			
		return modelAndView;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Update wallet
	 * 
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/update_wallet", method = RequestMethod.POST)
	public ModelAndView updateWallet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id_wallet") int idWallet,
			@RequestParam("name_wallet") String nameWallet,
			@RequestParam("description") String description) {
		
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
		
		Wallet wallet = new Wallet();
		wallet.setIdWallet(idWallet);
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(description);
		
		WalletService walletService = new WalletService();
		walletService.updateWallet(wallet);

		try {
			response.sendRedirect("list_wallet.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * --------------------------------------------------------------------------------
	 * DELETE OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * Elimina una Wallet de un usuario
	 * (requiere estar logueado)
	 * Elimina la wallet del usuario registrado cuyo id se obtiene como parámetro
	 * 
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 * @param idWallet	ID de la wallet a eliminar
	 * 
	 * @return 			ModelAndView
	 */
	@RequestMapping(value = "/delete_wallet", method = RequestMethod.GET)
	public ModelAndView deleteteWallet(HttpServletRequest request, HttpServletResponse response, @RequestParam("idWallet") int idWallet) {
		//-- Requerir login
			Object[] loginStatus = LoginStatus.gete(response, request);
			if (!(boolean) loginStatus[0]) {
				response = (HttpServletResponse) loginStatus[1];
				return null;
			}
				
		WalletService walletService = new WalletService();
		walletService.deleteWallet(idWallet);
		
		try {
			response.sendRedirect("list_wallet.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	
	}

	/*
	 * --------------------------------------------------------------------------------
	 * LIST OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * Listar wallets del usuario
	 * (requiere estar logueado)
	 * Lista las wallet pertenecientes a la id del usuario logueado y las muestra en la vista
	 * 
	 * @param request	HttpServletRequest
	 * @param response	HttpServletResponse
	 * 
	 * @return 			ModelAndView
	 */
	@RequestMapping(value = { "/main", "/", "/list_wallet" })
	public ModelAndView listWallet(HttpServletRequest request, HttpServletResponse response) {
		//- TEMPLATE LOADER
			String view = "list_wallet.jsp";
			String title = "Mis Carteras";
			String menu = "wallet";
			String submenu = "list_wallet";
			ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);
		
			//-- Requerir login
				Object[] loginStatus = LoginStatus.gete(response, request);
				if (!(boolean) loginStatus[0]) {
					response = (HttpServletResponse) loginStatus[1]; 
					return null;
				}
		
		//-CONTROLLER FUNCTIONS
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		int id_user = user.getIdUser();

		WalletService walletService = new WalletService();
		List<Wallet> list = walletService.listWallet(id_user);

		modelAndView.addObject("list", list);
			
		return modelAndView;
	}

}
