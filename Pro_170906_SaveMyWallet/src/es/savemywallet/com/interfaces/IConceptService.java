package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Concept;

public interface IConceptService {
	
	@Transactional
	public Concept findConcept(Concept concept);
	public void addConcept(Concept concept);
	public void updateConcept(Concept concept);
	public void deleteConcept(Concept concept);
	public List<Concept> listConcept();
}

