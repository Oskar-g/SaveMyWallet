package es.savemywallet.com.beans;

import java.util.Date;

public class Movement {
	
	/**
	 * Properties
	 */
	
	private int idMovement;
	private String nameConcept;
	private Date dateMovement;
	private String typeMovement;
	private double quantity;
	private int idWallet;
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
	
	public Movement(int idMovement, Date dateMovement,String typeMovement, double quantity, int idWallet, String nameConcept) {
		super();
		this.idMovement = idMovement;
		this.nameConcept = nameConcept;
		this.typeMovement = typeMovement;
		this.dateMovement = dateMovement;
		this.quantity = quantity;
		this.idWallet = idWallet;
		
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
		public Movement(int idMovement, Date dateMovement, double quantity, int idWallet, String nameConcept, Wallet wallet,
				Concept concept) {
			super();
			this.idMovement = idMovement;
			this.nameConcept = nameConcept;
			this.dateMovement = dateMovement;
			this.quantity = quantity;
			this.idWallet = idWallet;
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

		public String getNameConcept() {
			return nameConcept;
		}

		public Date getDateMovement() {
			return dateMovement;
		}

		public String getTypeMovement() {
			return typeMovement;
		}

		public double getQuantity() {
			return quantity;
		}

		public int getIdWallet() {
			return idWallet;
		}

		public Wallet getWallet() {
			return wallet;
		}

		public Concept getConcept() {
			return concept;
		}
				
		/*
		 * -----------------------------------------------------------------------
		 * Setters
		 * -----------------------------------------------------------------------
		 */
		
		public void setIdMovement(int idMovement) {
			this.idMovement = idMovement;
		}

		public void setNameConcept(String nameConcept) {
			this.nameConcept = nameConcept;
		}

		public void setDateMovement(Date dateMovement) {
			this.dateMovement = dateMovement;
		}

		public void setTypeMovement(String typeMovement) {
			this.typeMovement = typeMovement;
		}

		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		public void setIdWallet(int idWallet) {
			this.idWallet = idWallet;
		}

		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}

		public void setConcept(Concept concept) {
			this.concept = concept;
		}
	
}
