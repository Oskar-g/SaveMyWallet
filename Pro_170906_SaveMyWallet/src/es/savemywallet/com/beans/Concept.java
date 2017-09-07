package es.savemywallet.com.beans;

public class Concept {
	
	/**
	 * Properties
	 */
	
	private String idConcept;
	private String name;
		
	/**
	 * Default Constructor
	 */
	
	public Concept(String idConcept, String name) {
		super();
		this.idConcept = idConcept;
		this.name = name;
	}

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	
	public String getIdConcept() {
		return idConcept;
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	public void setIdConcept(String idConcept) {
		this.idConcept = idConcept;
	}
	
	public void setName(String name) {
		this.name = name;

	}
}
