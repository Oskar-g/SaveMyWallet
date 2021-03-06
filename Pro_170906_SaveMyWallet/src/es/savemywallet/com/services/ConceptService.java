package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.daos.ConceptDAO;
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
	
	/**
	 * Method fin by primary id_concept
	 */
	@Override
	public Concept findConcept(Concept concept) {
		Concept aux = conceptDAO.findByPrimaryId(concept);
		return aux;
	}

	/**
	 * Method add concept
	 */
	@Override
	public void addConcept(Concept concept) {
		conceptDAO.add(concept);		
	}
	
	/**
	 * Method update concept
	 */
	@Override
	public void updateConcept(Concept concept) {
		conceptDAO.update(concept);		
	}
	
	/**
	 * Method delete id_concept
	 */
	@Override
	public void deleteConcept(Concept concept) {
		conceptDAO.delete(concept);		
	}

	/**
	 * Method list concept
	 */
	@Override
	public List<Concept> listConcept() {
		List<Concept> listConcept = conceptDAO.list();

		return listConcept;
	}

}
