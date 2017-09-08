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
		WalletService walletService = new WalletService();
		List<Wallet> list = walletService.listWallet();
		ModelAndView modelAndView = new ModelAndView("listWallet");
		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	@RequestMapping(value = "/registerWallet", method = RequestMethod.GET)
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
		wallet.setDescripcion(descriptionWallet);
		walletService.addWallet(wallet);
		return new ModelAndView("fin");
	}
}
