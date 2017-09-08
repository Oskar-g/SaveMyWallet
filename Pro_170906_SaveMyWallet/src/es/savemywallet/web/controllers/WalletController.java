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

@Controller
public class WalletController {
	// Metodo para registrar el bean

	@ModelAttribute("datasWallet")
	public Wallet wallet() {
		return new Wallet();
	}

	@RequestMapping(value = "/main")
	public ModelAndView listWallet() {
		//-- TEMPLATE LOADER
		String jspTemplate = "base";
		String pageTitle = "Mis carteras";
		String jspContent = "listWallet.jsp";
		
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		//-- FIN TEMPLATE LOADER
		
		//-- CONTROLLER FUNCTIONS
		WalletService walletService = new WalletService();
		List<Wallet> list = walletService.listWallet();

		modelAndView.addObject("list", list);
		//-- FIN CONTROLLER FUNCTIONS
		return modelAndView;
	}
	
	@RequestMapping(value = "/register_wallet", method = RequestMethod.GET)
	public ModelAndView accesWallet() {
		String jspfile = "registerWallet";
		return new ModelAndView(jspfile);
	}

	@RequestMapping(value = "/do_wallet", method = RequestMethod.POST)
	public ModelAndView registerWallet(HttpServletRequest request,
			@RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet){
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		WalletService walletService = new WalletService();
		Wallet wallet = new Wallet();
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(descriptionWallet);
		walletService.addWallet(wallet);
		return new ModelAndView("fin");
	}
	
	@RequestMapping(value = "/update_wallet", method = RequestMethod.POST)
	public ModelAndView updateWallet(HttpServletRequest request,
			@RequestParam("nameWallet") String nameWallet,
			@RequestParam("descriptionWallet") String descriptionWallet){
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		WalletService walletService = new WalletService();
		Wallet wallet = new Wallet();
		wallet.setIdUser(user.getIdUser());
		wallet.setNameWallet(nameWallet);
		wallet.setDescription(descriptionWallet);
		walletService.updateWallet(wallet);
		return new ModelAndView("fin");
	}
	
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
