package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.daos.ConceptDAO;
import es.savemywallet.com.daos.MovementDAO;
import es.savemywallet.com.interfaces.IConceptService;

public class ConceptService implements IConceptService {
	
	/**
	 * Properties
	 */
	private ConceptDAO conceptDAO;
	
	
	/**
	 * Constructor
	 */
	public ConceptService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		conceptDAO = (ConceptDAO) context.getBean("conceptDAO");		
	}
	
	@Override
	public Concept findByPrimaryIdMovement(int idConcept) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addConcept(Concept concept) {
		conceptDAO.add(concept);		

	}

	@Override
	public void updateConcept(Concept concept) {
		conceptDAO.update(concept);		

	}

	@Override
	public void deleteConcept(int idConcept) {
		conceptDAO.delete(idConcept);		
	
	}

	@Override
	public List<Concept> listConcept() {
		List<Concept> listConcept = conceptDAO.list();

		return listConcept;
	}

}
