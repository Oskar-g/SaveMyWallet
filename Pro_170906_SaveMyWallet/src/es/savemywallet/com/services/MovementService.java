package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.daos.MovementDAO;
import es.savemywallet.com.interfaces.IMovementService;

public class MovementService implements IMovementService {

	/**
	 * Properties
	 */
	private MovementDAO movementDAO;
	
	/**
	 * Constructor
	 */
	public MovementService(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		movementDAO = (MovementDAO) context.getBean("movementDAO");
	}
	
	/**
	 * Method fin by primary id_concept
	 */
	@Override
	public Movement findByPrimaryIdMovement(int idMovement) {
		
		Movement auxMovement = movementDAO.findByPrimaryId(idMovement);
		return auxMovement;
	}

	/**
	 * Method add concept
	 */
	@Override
	public void addMovement(Movement movement) {

		movementDAO.add(movement);		
	}

	/**
	 * Method update concept
	 */
	@Override
	public void updateMovement(Movement movement) {
		
		movementDAO.update(movement);		
	}
	
	/**
	 * Method delete id_concept
	 */
	@Override
	public void deleteMovement(int idMovement) {
		
		movementDAO.delete(idMovement);		
	}

	/**
	 * Method list concept
	 */
	@Override
	public List<Movement> listMovement() {
		
		List<Movement> listMovement = movementDAO.list();
		
		return listMovement;
	}
}
