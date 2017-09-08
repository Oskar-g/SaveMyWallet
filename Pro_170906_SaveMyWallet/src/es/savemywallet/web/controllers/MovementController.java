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

import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.services.MovementService;
import es.savemywallet.com.services.WalletService;

@Controller
public class MovementController {

	
	@ModelAttribute("dataMovement")
	public Movement movement() {
		
		return new Movement();
	}
	
	@RequestMapping(value = "/movement")
	public ModelAndView listMovement() {
		
		String jspTemplate = "base";
		String jspContent = "listMovement.jsp";
		String pageTitle = "Mis Movimientos";
		
		ModelAndView modelAndView = new ModelAndView(jspTemplate);		
		modelAndView.addObject("pageTitle", pageTitle);
		modelAndView.addObject("jspContent", jspContent);
		
		MovementService movementService = new MovementService();
		List<Movement> list = movementService.listMovement();

		modelAndView.addObject("list", list);
		return modelAndView;
	}
	
	@RequestMapping(value = "/registerWallet", method = RequestMethod.GET)
	public ModelAndView accessMovement() {
		String jspfile = "registerMovement";
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
	
	
	
	
}
