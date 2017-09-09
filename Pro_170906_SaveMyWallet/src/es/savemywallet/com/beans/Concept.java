package es.savemywallet.com.beans;

public class Concept {
	
	/**
	 * Properties
	 */
	private String nameConcept;
		
	/**
	 * Default Constructor
	 */	
	public Concept() {}

	/**
	 * Constructor
	 * @param idConcept
	 * @param name
	 */
	public Concept(String nameConcept) {
		this.nameConcept = nameConcept;
	}
	

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	
	
	public String getNameConcept() {
		return nameConcept;
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */

	public void setNameConcept(String nameConcept) {
		this.nameConcept = nameConcept;
	}
}
