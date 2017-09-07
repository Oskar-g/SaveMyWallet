package es.savemywallet.com.beans;

public class Concept {
	
	/**
	 * Properties
	 */
	
	private int idConcept;
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
	public Concept(int idConcept, String nameConcept) {
		super();
		this.idConcept = idConcept;
		this.nameConcept = nameConcept;
	}
	

	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	
	public int getIdConcept() {
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
	
	public void setIdConcept(int idConcept) {
		this.idConcept = idConcept;
	}
	

	public void setNameConcept(String nameConcept) {
		this.nameConcept = nameConcept;
	}
}
