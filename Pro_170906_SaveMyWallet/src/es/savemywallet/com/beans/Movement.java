package es.savemywallet.com.beans;

import java.util.Date;

public class Movement {
	
	/*
	 * -----------------------------------------------------------------------
	 * Properties
	 * -----------------------------------------------------------------------
	 */
	private int id;
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
	
	public Movement(int id, String name, Date date, String type, double quantity, int walletId, Concept concept) {
	
		this.id = id;
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
	
	public int getId() {
		return id;
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
	
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Movement [id=" + id + ", date=" + date + ", type=" + type + ", quantity=" + quantity
				+ ", walletId=" + walletId + ", wallet=" + wallet + ", concept=" + concept + "]";
	}
	
	
}
