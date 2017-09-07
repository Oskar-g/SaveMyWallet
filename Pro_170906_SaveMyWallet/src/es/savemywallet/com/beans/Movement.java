package es.savemywallet.com.beans;

import java.util.Date;

public class Movement {
	
	/**
	 * Properties
	 */
	
	private int idMovement;
	private Date dateMovement;
	private double quantity;
	private int idWallet;
	private int idConcept;
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
	
	public Movement(int idMovement, Date dateMovement, double quantity, int idWallet, int idConcept) {
		super();
		this.idMovement = idMovement;
		this.dateMovement = dateMovement;
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
		public Movement(int idMovement, Date dateMovement, double quantity, int idWallet, int idConcept, Wallet wallet,
				Concept concept) {
			super();
			this.idMovement = idMovement;
			this.dateMovement = dateMovement;
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

	public int getIdConcept() {
		return idConcept;
	}

	public Date getDateMovement() {
		return dateMovement;
	}
	public int getIdWallet() {
		return idWallet;
	}

	public double getQuantity() {
		return quantity;
	}
	

	/*
	 * -----------------------------------------------------------------------
	 * Setters
	 * -----------------------------------------------------------------------
	 */
	
	

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setIdWallet(int idWallet) {
		this.idWallet = idWallet;
	}

	public void setIdConcept(int idConcept) {
		this.idConcept = idConcept;
	}
	
	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}
	
	public void setDateMovement(Date dateMovement) {
		this.dateMovement = dateMovement;
	}

}
