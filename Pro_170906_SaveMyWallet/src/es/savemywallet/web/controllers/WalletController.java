package es.savemywallet.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.JSON_Encode;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class WalletController {
	// Metodo para registrar el bean

	@ModelAttribute("dataWallet")
	public Wallet wallet() {
		return new Wallet();
	}


	/**
	 * Edit send form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit_wallet", method = RequestMethod.GET)
	public ModelAndView accessWallet() {
		String jspTemplate = "base";
		String jspContent = "editWallet.jsp";
		String pageTitle = "Mis carteras";
		System.out.println(jspContent);
		ModelAndView modelAndView = new ModelAndView(jspTemplate);
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		System.out.println(pageTitle);

		return modelAndView;
	}

	/**
	 * Register new wallet
	 * 
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/add_wallet", method = RequestMethod.POST)
	public ModelAndView registerWallet(HttpServletRequest request, @RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet) {
		String jspTemplate = "base";
		String jspContent = "registerWallet.jsp";
		String pageTitle = "Nueva cartera";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		WalletService walletService = new WalletService();
		Wallet wallet = new Wallet();
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(descriptionWallet);
		walletService.addWallet(wallet);

		return modelAndView;
	}

	/**
	 * Update wallet
	 * 
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/update_wallet", method = RequestMethod.POST)
	public ModelAndView updateWallet(HttpServletRequest request, @RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet) {
		String jspTemplate = "base";
		String jspContent = "updateWallet.jsp";
		String pageTitle = "Editar cartera";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		WalletService walletService = new WalletService();
		Wallet wallet = new Wallet();
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(descriptionWallet);
		walletService.updateWallet(wallet);

		return modelAndView;
	}

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
		//-- /requerir login
				
		WalletService walletService = new WalletService();
		walletService.deleteWallet(idWallet);
		
		try {
			response.sendRedirect("list_wallet.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	
	}

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
			//--Session
				HttpSession session = request.getSession(true);
				User user = (User) session.getAttribute("user");
				int id_user = user.getIdUser();

		WalletService walletService = new WalletService();
		List<Wallet> list = walletService.listWallet(id_user);

		modelAndView.addObject("list", list);
			
		return modelAndView;
	}

	
}
