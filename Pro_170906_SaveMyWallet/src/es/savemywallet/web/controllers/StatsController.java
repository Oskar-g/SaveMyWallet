package es.savemywallet.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.savemywallet.com.beans.User;
import es.savemywallet.com.beans.Wallet;
import es.savemywallet.com.interfaces.IStatisticsService;
import es.savemywallet.com.interfaces.IUserService;
import es.savemywallet.com.services.StatisticsService;
import es.savemywallet.com.services.UserService;
import es.savemywallet.com.services.WalletService;
import es.savemywallet.com.utils.JSON_Encode;
import es.savemywallet.com.utils.LoginStatus;
import es.savemywallet.com.utils.TemplateLoader;

@Controller
public class StatsController {

	/*
	 * --------------------------------------------------------------------------------
	 * READ OBJECT
	 * --------------------------------------------------------------------------------
	 */

	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("wallet") int id) {
		//- TEMPLATE LOADER
		String view = "statistics.jsp";
		String title = "Balance de movimientos";
		String menu = "statistics";
		ModelAndView modelAndView = TemplateLoader.start(request, view, title, menu, null);
		modelAndView.addObject("script_chart", true);
		
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
			Wallet wallet = walletService.findByPrimaryIdWallet(id);
			modelAndView.addObject("wallet", wallet);
			
		return modelAndView;
	}

	
	@RequestMapping(value = "/getStatistics", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String doLogin(HttpSession sesion, HttpServletResponse response, HttpServletRequest request,
			@RequestParam("wallet") int wallet) {

		Object[] loginStatus = LoginStatus.gete(response, request);
		if (!(boolean) loginStatus[0]) {
			response = (HttpServletResponse) loginStatus[1];
			return null;
		}
		
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		Map<String, Object> responseJSON = new HashMap<String, Object>();

		IStatisticsService statisticsService= new StatisticsService();
		
		System.out.println("ACA"+user.getId());
		try{
			Object ingresos = statisticsService.ingresos(wallet);
			Object gastos = statisticsService.gastos(wallet);
			responseJSON.put("response", "success");
			responseJSON.put("ingresos", ingresos);
			responseJSON.put("gastos", gastos);
			Object versus = statisticsService.versus(wallet);
			responseJSON.put("versus", versus);
			Object versusAll = statisticsService.versusAll(user.getId());
			responseJSON.put("versusAll", versusAll);
			
		}catch (Exception e) {
			responseJSON.put("response", "error");
		}

		String debugger = JSON_Encode.parse(responseJSON);
		System.out.println(debugger);

		return JSON_Encode.parse(responseJSON);
	}
	
}
