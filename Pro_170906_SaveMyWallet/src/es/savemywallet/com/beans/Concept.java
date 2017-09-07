package es.savemywallet.com.beans;

public class Concept {
	
	/**
	 * Properties
	 */
	
	private String idConcept;
	private String nameConcept;
		
	/**
	 * Default Constructor
	 */
	
	public Concept() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * @param idConcept
	 * @param name
	 */
	public Concept(String idConcept, String name) {
		super();
		this.idConcept = idConcept;
		this.nameConcept = nameConcept;
	}
	

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	
	public String getIdConcept() {
		return idConcept;
	}
	
	public String getNameConcept() {
		return nameConcept;
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
		this.nameConcept = nameConcept;

	}
}
