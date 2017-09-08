package es.savemywallet.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class WalletController {
	// Metodo para registrar el bean

	@ModelAttribute("datasWallet")
	public Wallet wallet() {
		return new Wallet();
	}
	
	/**
	 * List my wallets
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView listWallet(HttpServletRequest request) {
		//-- TEMPLATE LOADER
		String view = "listWallet.jsp";
		String title = "Mis Carteras";
		String menu = "wallet";
		String submenu = "list_wallet";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, submenu);		
		//-- FIN TEMPLATE LOADER
		
		//-- CONTROLLER FUNCTIONS
		WalletService walletService = new WalletService();
		List<Wallet> list = walletService.listWallet();

		modelAndView.addObject("list", list);

		//-- FIN CONTROLLER FUNCTIONS

		return modelAndView;
	}
		
	/**
	 * Edit send form
	 * @return
	 */
	@RequestMapping(value = "/edit_wallet", method = RequestMethod.GET)
	public ModelAndView accesWallet() {
		String jspTemplate = "base";
		String jspContent = "editWallet.jsp";
		String pageTitle = "Mis carteras";
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		
		return modelAndView;
	}
	
	/**
	 * Register new wallet
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/add_wallet", method = RequestMethod.POST)
	public ModelAndView registerWallet(HttpServletRequest request,
			@RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet){
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
	 * @param request
	 * @param nameWallet
	 * @param descriptionWallet
	 * @return
	 */
	@RequestMapping(value = "/update_wallet", method = RequestMethod.POST)
	public ModelAndView updateWallet(HttpServletRequest request,
			@RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet){
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
	 * Delet wallet
	 * @param request
	 * @param idWallet
	 * @return
	 */
	@RequestMapping(value = "/delete_wallet", method = RequestMethod.POST)
	public ModelAndView deleteteWallet(HttpServletRequest request,
			@RequestParam("idWallet") int idWallet){
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		WalletService walletService = new WalletService();
		walletService.deleteWallet(idWallet);;
		return new ModelAndView("fin");
	}
}
