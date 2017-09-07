package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.Concept;

public interface IConceptDAO {

	public void add(Concept concept);
	public void delete(Concept Concept);
	public Concept findByPrimaryId(Concept concept);
	public void update(Concept concept);
	public List<Concept> list();

}
