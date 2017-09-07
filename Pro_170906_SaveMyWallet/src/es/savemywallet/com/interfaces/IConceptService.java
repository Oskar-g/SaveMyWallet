package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Concept;

public interface IConceptService {
	
	@Transactional
	public Concept findByPrimaryIdConcept(int idConcept);
	public void addConcept(Concept concept);
	public void updateConcept(Concept concept);
	public void deleteConcept(int idConcept);
	public List<Concept> listConcept();
}

