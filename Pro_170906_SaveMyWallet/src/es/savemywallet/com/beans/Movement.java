package es.savemywallet.com.beans;

import java.util.Date;

public class Movement {
	
	/*
	 * -----------------------------------------------------------------------
	 * Properties
	 * -----------------------------------------------------------------------
	 */
	private int idMovement;
	private String name;
	private Date date;
	private String type;
	private double quantity;
	private int walletId;
	private Wallet wallet;
	private Concept concept;
	
	
	/*
	 * -----------------------------------------------------------------------
	 * Constructors
	 * -----------------------------------------------------------------------
	 */
	
	public Movement() {}
	
	public Movement(int idMovement, String name, Date date, String type, double quantity, int walletId, Concept concept) {
	
		this.idMovement = idMovement;
		this.name = name;
		this.date = date;
		this.type = type;
		this.quantity = quantity;
		this.walletId = walletId;
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

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public double getQuantity() {
		return quantity;
	}

	public int getWalletId() {
		return walletId;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}
}
