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
	private String idConcept;
	private Wallet wallet;
	private Concept concept;
	
	
	
	/**
	 * Default Constructor
	 */
	
	public Movement() {
		super();
	}
	
	/**
	 * 
	 * @param idMovement
	 * @param date
	 * @param quantity
	 * @param idWallet
	 * @param idConcept
	 */
	
		public Movement(int idMovement, Date date, String quantity, String idWallet, String idConcept) {
		super();
		this.idMovement = idMovement;
		this.date = date;
		this.quantity = quantity;
		this.idWallet = idWallet;
		this.idConcept = idConcept;
		
	}
		/**
		 * 
		 * @param idMovement
		 * @param date
		 * @param quantity
		 * @param idWallet
		 * @param idConcept
		 * @param wallet
		 * @param concept
		 */
		public Movement(int idMovement, Date date, String quantity, String idWallet, String idConcept, Wallet wallet,
				Concept concept) {
			super();
			this.idMovement = idMovement;
			this.date = date;
			this.quantity = quantity;
			this.idWallet = idWallet;
			this.idConcept = idConcept;
			this.wallet = wallet;
			this.concept = concept;
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
		return idConcept;
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
		idConcept = idConcept;
	}
	
	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
