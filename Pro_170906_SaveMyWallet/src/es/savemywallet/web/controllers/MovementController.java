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
import es.savemywallet.com.services.MovementService;


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
	
	/*
	 * add movements
	 */
	
	@RequestMapping(value = "/register_movement", method = RequestMethod.GET)
	public ModelAndView accessMovement() {
		String jspfile = "registerMovement";
		return new ModelAndView(jspfile);
	}
	
	@RequestMapping(value = "/add_movement", method = RequestMethod.POST)
	public ModelAndView registerWallet(HttpServletRequest request, @RequestParam("id_wallet") int idWallet, 
			@RequestParam("name_concept") String nameConcept, @RequestParam("date_movement") String dateMovementForm,
			@RequestParam("quantity") double quantity){
		
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
	 * update movements
	 */
	
	@RequestMapping(value = "/edit_movement", method = RequestMethod.GET)
	public ModelAndView editMovement() {
		String jspfile = "editMovement";
		return new ModelAndView(jspfile);
	}
	
	@RequestMapping(value = "/update_movement", method = RequestMethod.POST)
	public ModelAndView updateMovement(HttpServletRequest request, @RequestParam("id_wallet") int idWallet, 
			@RequestParam("name_concept") String nameConcept, @RequestParam("date_movement") String dateMovementForm,
			@RequestParam("quantity") double quantity){
		
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
	 * delete movements
	 */
	
	@RequestMapping(value = "/delete_movement", method = RequestMethod.POST)
	public void deleteteWallet(HttpServletRequest request,
			@RequestParam("id_movement") int idMovement){
		
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		MovementService movementService = new MovementService();
		movementService.deleteMovement(idMovement); 
	}
	
	
	
	
	
	
}
