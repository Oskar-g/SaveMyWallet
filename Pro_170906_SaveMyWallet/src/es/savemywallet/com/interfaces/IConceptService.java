package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Concept;
import es.savemywallet.com.beans.Movement;

public interface IConceptService {
	
	@Transactional
	public Concept findByPrimaryIdMovement(int idConcept);
	public void addConcept(Concept concept);
	public void updateConcept(Concept concept);
	public void deleteConcept(int idConcept);
	public List<Concept> listConcept();
}
