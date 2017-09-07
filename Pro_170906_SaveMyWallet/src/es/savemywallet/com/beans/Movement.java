package es.savemywallet.com.beans;

import java.util.Date;

public class Movement {
	
	/**
	 * Properties
	 */
	
	private int idMovement;
	private Date date;
	private String quantity;
	private String idWallet;
	private String IdConcept;
	
	
	/**
	 * Default Constructor
	 */
	
	public Movement(int idMovement, Date date, String quantity, String idWallet, String idConcept) {
		super();
		this.idMovement = idMovement;
		this.date = date;
		this.quantity = quantity;
		this.idWallet = idWallet;
		IdConcept = idConcept;
	}
	
	/*
	 * -----------------------------------------------------------------------
	 * Getters
	 * -----------------------------------------------------------------------
	 */
	

	public int getIdMovement() {
		return idMovement;
	}

	public String getIdConcept() {
		return IdConcept;
	}

	public Date getDate() {
		return date;
	}
	public String getIdWallet() {
		return idWallet;
	}

	public String getQuantity() {
		return quantity;
	}
	

	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setIdWallet(String idWallet) {
		this.idWallet = idWallet;
	}

	public void setIdConcept(String idConcept) {
		IdConcept = idConcept;
	}
	
	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
